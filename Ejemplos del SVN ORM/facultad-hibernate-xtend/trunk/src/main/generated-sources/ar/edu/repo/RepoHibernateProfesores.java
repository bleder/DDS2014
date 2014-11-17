package ar.edu.repo;

import ar.edu.domain.Materia;
import ar.edu.domain.Profesor;
import ar.edu.repo.AbstractRepoHibernate;
import java.util.List;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

@SuppressWarnings("all")
public class RepoHibernateProfesores extends AbstractRepoHibernate<Profesor> {
  public RepoHibernateProfesores() {
  }
  
  public List<Profesor> getProfesores(final Materia materia) {
    List<Profesor> _xblockexpression = null;
    {
      List<Profesor> result = null;
      SessionFactory _sessionFactory = this.getSessionFactory();
      final Session session = _sessionFactory.openSession();
      try {
        Criteria _createCriteria = session.createCriteria(Profesor.class);
        Criteria _createAlias = _createCriteria.createAlias("_materias", "materias");
        Long _id = materia.getId();
        SimpleExpression _eq = Restrictions.eq("materias.id", _id);
        Criteria _add = _createAlias.add(_eq);
        List _list = _add.list();
        result = _list;
      } catch (final Throwable _t) {
        if (_t instanceof HibernateException) {
          final HibernateException e = (HibernateException)_t;
          throw new RuntimeException(e);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      } finally {
        session.close();
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  public Profesor get(final Long id, final boolean deep) {
    Profesor _xblockexpression = null;
    {
      Profesor profesor = null;
      SessionFactory _sessionFactory = this.getSessionFactory();
      final Session session = _sessionFactory.openSession();
      try {
        Object _get = session.get(Profesor.class, id);
        profesor = ((Profesor) _get);
        if (deep) {
          Set<Materia> _materias = profesor.getMaterias();
          _materias.size();
        }
      } catch (final Throwable _t) {
        if (_t instanceof HibernateException) {
          final HibernateException e = (HibernateException)_t;
          throw new RuntimeException(e);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      } finally {
        session.close();
      }
      _xblockexpression = profesor;
    }
    return _xblockexpression;
  }
  
  public void delete(final Profesor profesor) {
    profesor.clearMaterias();
    super.delete(profesor);
  }
}
