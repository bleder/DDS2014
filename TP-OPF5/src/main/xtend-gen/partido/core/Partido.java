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
  /**
   * @Property
   */
  private int id_partido;
  
  private List<Inscripcion> incripcionesOrdenadas = new ArrayList<Inscripcion>();
  
  /**
   * @Property
   */
  private String nombrePartido;
  
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
  
  /**
   * @Property
   */
  private int maximoLista;
  
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
  
  /**
   * @Property
   */
  private boolean confirmadoAdm;
  
  private List<Jugador> _jugadoresHome;
  
  public List<Jugador> getJugadoresHome() {
    return this._jugadoresHome;
  }
  
  public void setJugadoresHome(final List<Jugador> jugadoresHome) {
    this._jugadoresHome = jugadoresHome;
  }
  
  public Partido(final String nomPartido, final Administrador adminPartido) {
    this.nombrePartido = nomPartido;
    ArrayList<Inscripcion> _arrayList = new ArrayList<Inscripcion>();
    this.setJugadoresInscriptos(_arrayList);
    ArrayList<PartidoObserver> _arrayList_1 = new ArrayList<PartidoObserver>();
    this.setObservers(_arrayList_1);
    this.maximoLista = 10;
    this.setAdministrador(adminPartido);
    this.confirmadoAdm = false;
  }
  
  public int set_id_partido(final int id_partido) {
    return this.id_partido = id_partido;
  }
  
  public int get_id_partido() {
    return this.id_partido;
  }
  
  public String get_nombrePartido() {
    return this.nombrePartido;
  }
  
  public String set_nombrePartido(final String nombrePartido) {
    return this.nombrePartido = nombrePartido;
  }
  
  public int set_maximoLista(final int maximoLista) {
    return this.maximoLista = maximoLista;
  }
  
  public int get_maximoLista() {
    return this.maximoLista;
  }
  
  public boolean set_confirmadoAdm(final Boolean confirmadoAdm) {
    return this.confirmadoAdm = (confirmadoAdm).booleanValue();
  }
  
  public boolean get_confirmadoAdm() {
    return this.confirmadoAdm;
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
        if (this.confirmadoAdm) {
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
      if (this.confirmadoAdm) {
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
    return (_size < this.maximoLista);
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
        return Boolean.valueOf(inscripto.getEstaConfirmada());
      }
    };
    Iterable<Inscripcion> _filter = IterableExtensions.<Inscripcion>filter(_jugadoresInscriptos, _function);
    return IterableExtensions.size(_filter);
  }
  
  public boolean estasConfirmado() {
    int _cantidadConfirmados = this.cantidadConfirmados();
    return (_cantidadConfirmados == this.maximoLista);
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
      if (this.confirmadoAdm) {
        throw new PartidoYaConfirmado("El partido ya se encuentra confirmado");
      }
      Divisor _divisorEquipo = this.getDivisorEquipo();
      _divisorEquipo.dividir();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public boolean confirmate() {
    try {
      boolean _xblockexpression = false;
      {
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
        if (this.confirmadoAdm) {
          throw new PartidoYaConfirmado("El partido ya se encuentra confirmado");
        }
        _xblockexpression = this.confirmadoAdm = true;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
