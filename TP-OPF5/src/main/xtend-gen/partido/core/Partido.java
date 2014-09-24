package partido.core;

import com.google.common.base.Objects;
import divisionEquipo.Divisor;
import exception.NoSeRealizoDivisionDeEquipos;
import exception.PartidoCompletoExcepcion;
import exception.PartidoConfirmadoNoAceptaBaja;
import exception.PartidoNoPoseeCantidadMaxima;
import exception.PartidoYaConfirmado;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.commons.model.Entity;
import partido.core.Infraccion;
import partido.core.Inscripcion;
import partido.core.Jugador;
import partido.core.tiposDeInscripcion.Estandar;
import partido.core.tiposDeInscripcion.TipoInscripcion;
import partido.nuevosJugadores.Administrador;
import partido.observers.PartidoObserver;
import partido.ordenamiento.Ordenamiento;

@SuppressWarnings("all")
public class Partido extends Entity {
  private List<Inscripcion> incripcionesOrdenadas = new ArrayList<Inscripcion>();
  
  private String _nombrePartido;
  
  public String getNombrePartido() {
    return this._nombrePartido;
  }
  
  public void setNombrePartido(final String nombrePartido) {
    this._nombrePartido = nombrePartido;
  }
  
  private List<Inscripcion> _jugadoresInscriptos = new ArrayList<Inscripcion>();
  
  public List<Inscripcion> getJugadoresInscriptos() {
    return this._jugadoresInscriptos;
  }
  
  public void setJugadoresInscriptos(final List<Inscripcion> jugadoresInscriptos) {
    this._jugadoresInscriptos = jugadoresInscriptos;
  }
  
  private List<PartidoObserver> _observers;
  
  public List<PartidoObserver> getObservers() {
    return this._observers;
  }
  
  public void setObservers(final List<PartidoObserver> observers) {
    this._observers = observers;
  }
  
  private List<Jugador> _jugadores;
  
  public List<Jugador> getJugadores() {
    return this._jugadores;
  }
  
  public void setJugadores(final List<Jugador> jugadores) {
    this._jugadores = jugadores;
  }
  
  private Administrador _administrador;
  
  public Administrador getAdministrador() {
    return this._administrador;
  }
  
  public void setAdministrador(final Administrador administrador) {
    this._administrador = administrador;
  }
  
  private int _maximoLista;
  
  public int getMaximoLista() {
    return this._maximoLista;
  }
  
  public void setMaximoLista(final int maximoLista) {
    this._maximoLista = maximoLista;
  }
  
  private List<Jugador> _equipo1 = new ArrayList<Jugador>();
  
  public List<Jugador> getEquipo1() {
    return this._equipo1;
  }
  
  public void setEquipo1(final List<Jugador> equipo1) {
    this._equipo1 = equipo1;
  }
  
  private List<Jugador> _equipo2 = new ArrayList<Jugador>();
  
  public List<Jugador> getEquipo2() {
    return this._equipo2;
  }
  
  public void setEquipo2(final List<Jugador> equipo2) {
    this._equipo2 = equipo2;
  }
  
  private Divisor _divisorEquipo;
  
  public Divisor getDivisorEquipo() {
    return this._divisorEquipo;
  }
  
  public void setDivisorEquipo(final Divisor divisorEquipo) {
    this._divisorEquipo = divisorEquipo;
  }
  
  private boolean _confirmadoAdm;
  
  public boolean isConfirmadoAdm() {
    return this._confirmadoAdm;
  }
  
  public void setConfirmadoAdm(final boolean confirmadoAdm) {
    this._confirmadoAdm = confirmadoAdm;
  }
  
  private List<Jugador> _jugadoresHome;
  
  public List<Jugador> getJugadoresHome() {
    return this._jugadoresHome;
  }
  
  public void setJugadoresHome(final List<Jugador> jugadoresHome) {
    this._jugadoresHome = jugadoresHome;
  }
  
  public Partido(final String nomPartido, final Administrador adminPartido) {
    this.setNombrePartido(nomPartido);
    ArrayList<Inscripcion> _arrayList = new ArrayList<Inscripcion>();
    this.setJugadoresInscriptos(_arrayList);
    ArrayList<PartidoObserver> _arrayList_1 = new ArrayList<PartidoObserver>();
    this.setObservers(_arrayList_1);
    this.setMaximoLista(10);
    this.setAdministrador(adminPartido);
    this.setConfirmadoAdm(false);
  }
  
  public void eliminarInscripcion(final Jugador jug) {
    List<Inscripcion> _jugadoresInscriptos = this.getJugadoresInscriptos();
    Inscripcion _buscarInscripcionDelJugador = this.buscarInscripcionDelJugador(jug);
    _jugadoresInscriptos.remove(_buscarInscripcionDelJugador);
    List<PartidoObserver> _observers = this.getObservers();
    final Procedure1<PartidoObserver> _function = new Procedure1<PartidoObserver>() {
      public void apply(final PartidoObserver observer) {
        observer.jugadorDadoDeBaja(jug, Partido.this);
      }
    };
    IterableExtensions.<PartidoObserver>forEach(_observers, _function);
  }
  
  public Inscripcion buscarInscripcionDelJugador(final Jugador jug) {
    List<Inscripcion> _jugadoresInscriptos = this.getJugadoresInscriptos();
    final Function1<Inscripcion,Boolean> _function = new Function1<Inscripcion,Boolean>() {
      public Boolean apply(final Inscripcion inscripcion) {
        Jugador _jugador = inscripcion.getJugador();
        return Boolean.valueOf(Objects.equal(_jugador, jug));
      }
    };
    return IterableExtensions.<Inscripcion>findFirst(_jugadoresInscriptos, _function);
  }
  
  public boolean darBajaA(final Jugador jug) {
    try {
      boolean _xblockexpression = false;
      {
        boolean _isConfirmadoAdm = this.isConfirmadoAdm();
        if (_isConfirmadoAdm) {
          throw new PartidoConfirmadoNoAceptaBaja("El partido esta confirmado no se puede dar de baja el jugador");
        }
        this.eliminarInscripcion(jug);
        _xblockexpression = this.agregarInfraccion(jug);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void darBajaA(final Jugador jugBaja, final Jugador jugReemplazo, final TipoInscripcion inscripcion) {
    try {
      boolean _isConfirmadoAdm = this.isConfirmadoAdm();
      if (_isConfirmadoAdm) {
        throw new PartidoConfirmadoNoAceptaBaja("El partido esta confirmado no se puede dar de baja el jugador");
      }
      this.eliminarInscripcion(jugBaja);
      this.agregarJugador(jugReemplazo, inscripcion);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void confirmarJugador(final Jugador jugador) {
    Inscripcion _buscarInscripcionDelJugador = this.buscarInscripcionDelJugador(jugador);
    _buscarInscripcionDelJugador.confirmar();
    List<PartidoObserver> _observers = this.getObservers();
    final Procedure1<PartidoObserver> _function = new Procedure1<PartidoObserver>() {
      public void apply(final PartidoObserver observer) {
        observer.jugadorConfirmado(jugador, Partido.this);
      }
    };
    IterableExtensions.<PartidoObserver>forEach(_observers, _function);
  }
  
  public void inscribiYConfirmarATodosLosJugadores() {
    final Estandar tipoIncEstandar = new Estandar();
    List<Jugador> _jugadores = this.getJugadores();
    final Procedure1<Jugador> _function = new Procedure1<Jugador>() {
      public void apply(final Jugador jugador) {
        jugador.inscribite(Partido.this, tipoIncEstandar);
        Partido.this.confirmarJugador(jugador);
      }
    };
    IterableExtensions.<Jugador>forEach(_jugadores, _function);
  }
  
  public void agregarJugador(final Jugador jugador, final TipoInscripcion tipoIncripcion) {
    try {
      Inscripcion inscripcion = new Inscripcion(jugador, tipoIncripcion);
      boolean _hayLugar = this.hayLugar();
      if (_hayLugar) {
        List<Inscripcion> _jugadoresInscriptos = this.getJugadoresInscriptos();
        _jugadoresInscriptos.add(inscripcion);
      } else {
        boolean _hayAlgunoQueDejaAnotar = this.hayAlgunoQueDejaAnotar();
        if (_hayAlgunoQueDejaAnotar) {
          this.sacarAlQueDejaAnotar();
          List<Inscripcion> _jugadoresInscriptos_1 = this.getJugadoresInscriptos();
          _jugadoresInscriptos_1.add(inscripcion);
        } else {
          throw new PartidoCompletoExcepcion("No puede anotarse al partido");
        }
      }
      List<PartidoObserver> _observers = this.getObservers();
      final Procedure1<PartidoObserver> _function = new Procedure1<PartidoObserver>() {
        public void apply(final PartidoObserver observer) {
          observer.jugadorInscripto(jugador, Partido.this);
        }
      };
      IterableExtensions.<PartidoObserver>forEach(_observers, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public boolean hayLugar() {
    List<Inscripcion> _jugadoresInscriptos = this.getJugadoresInscriptos();
    int _size = _jugadoresInscriptos.size();
    int _maximoLista = this.getMaximoLista();
    return (_size < _maximoLista);
  }
  
  public boolean hayAlgunoQueDejaAnotar() {
    List<Inscripcion> _jugadoresInscriptos = this.getJugadoresInscriptos();
    final Function1<Inscripcion,Boolean> _function = new Function1<Inscripcion,Boolean>() {
      public Boolean apply(final Inscripcion inscripcion) {
        TipoInscripcion _tipoInscripcion = inscripcion.getTipoInscripcion();
        return Boolean.valueOf(_tipoInscripcion.dejaAnotar());
      }
    };
    return IterableExtensions.<Inscripcion>exists(_jugadoresInscriptos, _function);
  }
  
  public boolean sacarAlQueDejaAnotar() {
    boolean _xblockexpression = false;
    {
      Inscripcion inscripcionABorrar = null;
      List<Inscripcion> _jugadoresInscriptos = this.getJugadoresInscriptos();
      final Function1<Inscripcion,Boolean> _function = new Function1<Inscripcion,Boolean>() {
        public Boolean apply(final Inscripcion inscripcion) {
          TipoInscripcion _tipoInscripcion = inscripcion.getTipoInscripcion();
          return Boolean.valueOf(_tipoInscripcion.dejaAnotar());
        }
      };
      Inscripcion _findFirst = IterableExtensions.<Inscripcion>findFirst(_jugadoresInscriptos, _function);
      inscripcionABorrar = _findFirst;
      List<Inscripcion> _jugadoresInscriptos_1 = this.getJugadoresInscriptos();
      _xblockexpression = _jugadoresInscriptos_1.remove(inscripcionABorrar);
    }
    return _xblockexpression;
  }
  
  public boolean estaInscripto(final Jugador jugador) {
    List<Inscripcion> _jugadoresInscriptos = this.getJugadoresInscriptos();
    final Function1<Inscripcion,Boolean> _function = new Function1<Inscripcion,Boolean>() {
      public Boolean apply(final Inscripcion inscripcion) {
        return Boolean.valueOf(inscripcion.sosInscripcionDe(jugador));
      }
    };
    return IterableExtensions.<Inscripcion>exists(_jugadoresInscriptos, _function);
  }
  
  public boolean agregarInfraccion(final Jugador jug) {
    Infraccion _infraccion = new Infraccion("Dado de baja");
    return jug.nuevaInfraccion(_infraccion);
  }
  
  public boolean agregarObserver(final PartidoObserver obs) {
    List<PartidoObserver> _observers = this.getObservers();
    return _observers.add(obs);
  }
  
  public int cantidadConfirmados() {
    List<Inscripcion> _jugadoresInscriptos = this.getJugadoresInscriptos();
    final Function1<Inscripcion,Boolean> _function = new Function1<Inscripcion,Boolean>() {
      public Boolean apply(final Inscripcion inscripto) {
        return Boolean.valueOf(inscripto.isEstaConfirmada());
      }
    };
    Iterable<Inscripcion> _filter = IterableExtensions.<Inscripcion>filter(_jugadoresInscriptos, _function);
    return IterableExtensions.size(_filter);
  }
  
  public boolean estasConfirmado() {
    int _cantidadConfirmados = this.cantidadConfirmados();
    int _maximoLista = this.getMaximoLista();
    return (_cantidadConfirmados == _maximoLista);
  }
  
  public void partidoOrdenaJugadores(final Ordenamiento criterio) {
    List<Inscripcion> _jugadoresInscriptos = this.getJugadoresInscriptos();
    final Function1<Inscripcion,Integer> _function = new Function1<Inscripcion,Integer>() {
      public Integer apply(final Inscripcion it) {
        Jugador _jugador = it.getJugador();
        return Integer.valueOf(criterio.ordenar(_jugador));
      }
    };
    List<Inscripcion> _sortBy = IterableExtensions.<Inscripcion, Integer>sortBy(_jugadoresInscriptos, _function);
    this.incripcionesOrdenadas = _sortBy;
    this.setJugadoresInscriptos(this.incripcionesOrdenadas);
  }
  
  public void partidoDividiEquipos() {
    try {
      boolean _estasConfirmado = this.estasConfirmado();
      boolean _not = (!_estasConfirmado);
      if (_not) {
        throw new PartidoNoPoseeCantidadMaxima("Partido no alcanza cantidad de jugadores para dividir en 2 partidos");
      }
      boolean _isConfirmadoAdm = this.isConfirmadoAdm();
      if (_isConfirmadoAdm) {
        throw new PartidoYaConfirmado("El partido ya se encuentra confirmado");
      }
      Divisor _divisorEquipo = this.getDivisorEquipo();
      _divisorEquipo.dividir();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void confirmate() {
    try {
      boolean _and = false;
      List<Jugador> _equipo1 = this.getEquipo1();
      boolean _isEmpty = _equipo1.isEmpty();
      if (!_isEmpty) {
        _and = false;
      } else {
        List<Jugador> _equipo2 = this.getEquipo2();
        boolean _isEmpty_1 = _equipo2.isEmpty();
        _and = _isEmpty_1;
      }
      if (_and) {
        throw new NoSeRealizoDivisionDeEquipos("No se Realizo la division de equipos para poder confirmar el mismo");
      }
      boolean _isConfirmadoAdm = this.isConfirmadoAdm();
      if (_isConfirmadoAdm) {
        throw new PartidoYaConfirmado("El partido ya se encuentra confirmado");
      }
      this.setConfirmadoAdm(true);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
