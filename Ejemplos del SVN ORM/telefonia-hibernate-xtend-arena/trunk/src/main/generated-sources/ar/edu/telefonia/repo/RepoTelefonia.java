package ar.edu.telefonia.repo;

import ar.edu.telefonia.appModel.BusquedaAbonados;
import ar.edu.telefonia.domain.Abonado;
import ar.edu.telefonia.domain.Empresa;
import ar.edu.telefonia.domain.Factura;
import ar.edu.telefonia.domain.Llamada;
import ar.edu.telefonia.domain.Residencial;
import ar.edu.telefonia.domain.Rural;
import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

@SuppressWarnings("all")
public class RepoTelefonia {
  private static RepoTelefonia instance = null;
  
  private RepoTelefonia() {
  }
  
  public static RepoTelefonia getInstance() {
    RepoTelefonia _xblockexpression = null;
    {
      boolean _equals = Objects.equal(RepoTelefonia.instance, null);
      if (_equals) {
        RepoTelefonia _repoTelefonia = new RepoTelefonia();
        RepoTelefonia.instance = _repoTelefonia;
      }
      _xblockexpression = RepoTelefonia.instance;
    }
    return _xblockexpression;
  }
  
  private final static SessionFactory sessionFactory = new AnnotationConfiguration().configure().addAnnotatedClass(Factura.class).addAnnotatedClass(Residencial.class).addAnnotatedClass(Rural.class).addAnnotatedClass(Empresa.class).addAnnotatedClass(Abonado.class).addAnnotatedClass(Llamada.class).buildSessionFactory();
  
  public Abonado getAbonado(final Abonado abonado) {
    return this.getAbonado(abonado, false);
  }
  
  public Abonado getAbonado(final Abonado unAbonado, final boolean full) {
    Abonado _xblockexpression = null;
    {
      final Session session = RepoTelefonia.sessionFactory.openSession();
      Abonado _xtrycatchfinallyexpression = null;
      try {
        Abonado _xblockexpression_1 = null;
        {
          Criteria _createCriteria = session.createCriteria(Abonado.class);
          String _nombre = unAbonado.getNombre();
          SimpleExpression _eq = Restrictions.eq("nombre", _nombre);
          Criteria _add = _createCriteria.add(_eq);
          List result = _add.list();
          Abonado _xifexpression = null;
          boolean _isEmpty = result.isEmpty();
          if (_isEmpty) {
            _xifexpression = null;
          } else {
            Abonado _xblockexpression_2 = null;
            {
              Object _get = result.get(0);
              Abonado abonado = ((Abonado) _get);
              if (full) {
                List<Factura> _facturas = abonado.getFacturas();
                _facturas.size();
                List<Llamada> _llamadas = abonado.getLlamadas();
                _llamadas.size();
              }
              _xblockexpression_2 = abonado;
            }
            _xifexpression = _xblockexpression_2;
          }
          _xblockexpression_1 = _xifexpression;
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
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
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  public List<Abonado> getAbonados(final BusquedaAbonados busquedaAbonados) {
    List<Abonado> _xblockexpression = null;
    {
      final Session session = RepoTelefonia.sessionFactory.openSession();
      List<Abonado> _xtrycatchfinallyexpression = null;
      try {
        List<Abonado> _xblockexpression_1 = null;
        {
          Criteria _createCriteria = session.createCriteria(Abonado.class);
          Criterion _isNotNull = Restrictions.isNotNull("id");
          final Criteria criteria = _createCriteria.add(_isNotNull);
          boolean _ingresoNombreDesde = busquedaAbonados.ingresoNombreDesde();
          if (_ingresoNombreDesde) {
            String _nombreDesde = busquedaAbonados.getNombreDesde();
            SimpleExpression _ge = Restrictions.ge("nombre", _nombreDesde);
            criteria.add(_ge);
          }
          boolean _ingresoNombreHasta = busquedaAbonados.ingresoNombreHasta();
          if (_ingresoNombreHasta) {
            String _nombreHasta = busquedaAbonados.getNombreHasta();
            SimpleExpression _le = Restrictions.le("nombre", _nombreHasta);
            criteria.add(_le);
          }
          List _list = criteria.list();
          final Function1<Abonado,Boolean> _function = new Function1<Abonado,Boolean>() {
            public Boolean apply(final Abonado abonado) {
              return Boolean.valueOf(busquedaAbonados.cumple(abonado));
            }
          };
          Iterable<Abonado> _filter = IterableExtensions.<Abonado>filter(_list, _function);
          _xblockexpression_1 = IterableExtensions.<Abonado>toList(_filter);
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
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
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  public void actualizarAbonado(final Abonado abonado) {
    final Session session = RepoTelefonia.sessionFactory.openSession();
    try {
      session.beginTransaction();
      session.saveOrUpdate(abonado);
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
  
  public void eliminarAbonado(final Abonado abonado) {
    final Session session = RepoTelefonia.sessionFactory.openSession();
    try {
      session.beginTransaction();
      session.delete(abonado);
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
