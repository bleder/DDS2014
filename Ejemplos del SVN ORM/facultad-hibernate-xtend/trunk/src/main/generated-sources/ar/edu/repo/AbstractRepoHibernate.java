package ar.edu.repo;

import ar.edu.domain.Materia;
import ar.edu.domain.Profesor;
import org.apache.commons.collections.Closure;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("all")
public abstract class AbstractRepoHibernate<T extends Object> {
  private final static SessionFactory sessionFactory = new AnnotationConfiguration().configure().addAnnotatedClass(Materia.class).addAnnotatedClass(Profesor.class).buildSessionFactory();
  
  public SessionFactory getSessionFactory() {
    return AbstractRepoHibernate.sessionFactory;
  }
  
  public T get(final Long id) {
    return this.get(id, false);
  }
  
  public abstract T get(final Long id, final boolean deep);
  
  /**
   * Necesitamos siempre hacer lo mismo:
   * 1) abrir la sesión
   * 2) ejecutar un query que actualice
   * 3) commitear los cambios
   * 4) y cerrar la sesión
   * 5) pero además controlar errores
   * Entonces definimos un método executeBatch que hace eso
   * y recibimos un closure que es lo que cambia cada vez
   * (otra opción podría haber sido definir un template method)
   */
  public void add(final T object) {
    final Closure _function = new Closure() {
      public void execute(final Object session) {
        ((Session) session).save(object);
      }
    };
    this.executeBatch(_function);
  }
  
  public void delete(final T object) {
    final Closure _function = new Closure() {
      public void execute(final Object session) {
        ((Session) session).delete(object);
      }
    };
    this.executeBatch(_function);
  }
  
  public void executeBatch(final Closure closure) {
    final org.hibernate.classic.Session session = AbstractRepoHibernate.sessionFactory.openSession();
    try {
      session.beginTransaction();
      closure.execute(session);
      Transaction _transaction = session.getTransaction();
      _transaction.commit();
    } catch (final Throwable _t) {
      if (_t instanceof HibernateException) {
        final HibernateException e = (HibernateException)_t;
        Transaction _transaction_1 = session.getTransaction();
        _transaction_1.rollback();
        throw new RuntimeException(e);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    } finally {
      session.close();
    }
  }
}
