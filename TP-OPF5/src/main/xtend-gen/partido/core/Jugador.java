package partido.core;

import com.google.common.base.Objects;
import exception.JugadorNoPerteneceAlPartido;
import exception.MeCalificoAMiMismo;
import exception.NoExisteMailException;
import exception.NotaIncorrecta;
import exception.YaLoCalifique;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import partido.calificaciones.Calificacion;
import partido.core.Infraccion;
import partido.core.Partido;
import partido.core.tiposDeInscripcion.TipoInscripcion;
import partido.nuevosJugadores.Administrador;
import partido.nuevosJugadores.Propuesta;

@SuppressWarnings("all")
public class Jugador {
  private String _nombre;
  
  public String getNombre() {
    return this._nombre;
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
  }
  
  private String _mail;
  
  public String getMail() {
    return this._mail;
  }
  
  public void setMail(final String mail) {
    this._mail = mail;
  }
  
  private List<Infraccion> _infracciones;
  
  public List<Infraccion> getInfracciones() {
    return this._infracciones;
  }
  
  public void setInfracciones(final List<Infraccion> infracciones) {
    this._infracciones = infracciones;
  }
  
  private List<String> _amigos;
  
  public List<String> getAmigos() {
    return this._amigos;
  }
  
  public void setAmigos(final List<String> amigos) {
    this._amigos = amigos;
  }
  
  private List<Calificacion> _calificaciones;
  
  public List<Calificacion> getCalificaciones() {
    return this._calificaciones;
  }
  
  public void setCalificaciones(final List<Calificacion> calificaciones) {
    this._calificaciones = calificaciones;
  }
  
  private int _handicap;
  
  public int getHandicap() {
    return this._handicap;
  }
  
  public void setHandicap(final int handicap) {
    this._handicap = handicap;
  }
  
  private List<Partido> _partidosJugados;
  
  public List<Partido> getPartidosJugados() {
    return this._partidosJugados;
  }
  
  public void setPartidosJugados(final List<Partido> partidosJugados) {
    this._partidosJugados = partidosJugados;
  }
  
  public Jugador(final String nom, final String newMail) {
    this.setMail(newMail);
    this.setNombre(nom);
    ArrayList<Infraccion> _arrayList = new ArrayList<Infraccion>();
    this.setInfracciones(_arrayList);
    ArrayList<String> _arrayList_1 = new ArrayList<String>();
    this.setAmigos(_arrayList_1);
    ArrayList<Partido> _arrayList_2 = new ArrayList<Partido>();
    this.setPartidosJugados(_arrayList_2);
    ArrayList<Calificacion> _arrayList_3 = new ArrayList<Calificacion>();
    this.setCalificaciones(_arrayList_3);
  }
  
  public void inscribite(final Partido partido, final TipoInscripcion tipoInscripcion) {
    tipoInscripcion.inscribirA(this, partido);
  }
  
  public void confirmarse(final Partido partido) {
    partido.confirmarJugador(this);
  }
  
  public boolean nuevaInfraccion(final Infraccion infraccion) {
    List<Infraccion> _infracciones = this.getInfracciones();
    return _infracciones.add(infraccion);
  }
  
  public boolean agregarAmigo(final String mailAmigo) {
    List<String> _amigos = this.getAmigos();
    return _amigos.add(mailAmigo);
  }
  
  public boolean calificarA(final Jugador jugador, final Partido partido, final int nota, final String critica) {
    try {
      boolean _xifexpression = false;
      boolean _estaInscripto = partido.estaInscripto(jugador);
      if (_estaInscripto) {
        boolean _xifexpression_1 = false;
        List<Calificacion> _calificaciones = jugador.getCalificaciones();
        final Function1<Calificacion,Boolean> _function = new Function1<Calificacion,Boolean>() {
          public Boolean apply(final Calificacion calificacion) {
            boolean _and = false;
            Jugador _jugadorQueCalifico = calificacion.getJugadorQueCalifico();
            boolean _equals = Objects.equal(_jugadorQueCalifico, jugador);
            if (!_equals) {
              _and = false;
            } else {
              Partido _partido = calificacion.getPartido();
              boolean _equals_1 = Objects.equal(_partido, partido);
              _and = _equals_1;
            }
            return Boolean.valueOf(_and);
          }
        };
        boolean _exists = IterableExtensions.<Calificacion>exists(_calificaciones, _function);
        if (_exists) {
          throw new YaLoCalifique("Ya califique a este jugador");
        } else {
          boolean _xifexpression_2 = false;
          if (((nota >= 1) && (nota <= 10))) {
            boolean _xifexpression_3 = false;
            boolean _notEquals = (!Objects.equal(jugador, this));
            if (_notEquals) {
              _xifexpression_3 = this.crearCalificacion(jugador, partido, nota, critica);
            } else {
              throw new MeCalificoAMiMismo("No puedo calificarme a mi mismo");
            }
            _xifexpression_2 = _xifexpression_3;
          } else {
            throw new NotaIncorrecta("La nota ingresada no es correcta");
          }
          _xifexpression_1 = _xifexpression_2;
        }
        _xifexpression = _xifexpression_1;
      } else {
        throw new JugadorNoPerteneceAlPartido("No esta ese jugador en el partido");
      }
      return _xifexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public boolean agregateCalificacion(final Calificacion calificacion) {
    List<Calificacion> _calificaciones = this.getCalificaciones();
    return _calificaciones.add(calificacion);
  }
  
  public boolean crearCalificacion(final Jugador jugador, final Partido partido, final int nota, final String critica) {
    Calificacion _calificacion = new Calificacion(critica, jugador, partido, nota);
    return jugador.agregateCalificacion(_calificacion);
  }
  
  public boolean crearPropuesta(final String amigo, final Administrador admin, final String nombre, final List<String> mailsDeAmigos) {
    try {
      boolean _xblockexpression = false;
      {
        boolean _existeAmigo = this.existeAmigo(amigo);
        boolean _not = (!_existeAmigo);
        if (_not) {
          throw new NoExisteMailException("El jugador no tiene a ese amigo");
        }
        Propuesta _propuesta = new Propuesta(amigo, this, nombre, mailsDeAmigos);
        _xblockexpression = admin.nuevaPropuesta(_propuesta);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public boolean existeAmigo(final String mail) {
    List<String> _amigos = this.getAmigos();
    final Function1<String,Boolean> _function = new Function1<String,Boolean>() {
      public Boolean apply(final String amigo) {
        return Boolean.valueOf(Objects.equal(amigo, mail));
      }
    };
    return IterableExtensions.<String>exists(_amigos, _function);
  }
  
  public boolean jugarPartido(final Partido partido) {
    List<Partido> _partidosJugados = this.getPartidosJugados();
    return _partidosJugados.add(partido);
  }
  
  public int promedioUltimoPartido() {
    int _xblockexpression = (int) 0;
    {
      final Iterable<Calificacion> ultimasCalificaciones = this.calificacionesUltimoPartido();
      final Function1<Calificacion,Integer> _function = new Function1<Calificacion,Integer>() {
        public Integer apply(final Calificacion calificaciones) {
          return Integer.valueOf(calificaciones.getNota());
        }
      };
      Iterable<Integer> _map = IterableExtensions.<Calificacion, Integer>map(ultimasCalificaciones, _function);
      final Function2<Integer,Integer,Integer> _function_1 = new Function2<Integer,Integer,Integer>() {
        public Integer apply(final Integer a, final Integer b) {
          return Integer.valueOf(((a).intValue() + (b).intValue()));
        }
      };
      Integer _reduce = IterableExtensions.<Integer>reduce(_map, _function_1);
      int _size = IterableExtensions.size(ultimasCalificaciones);
      _xblockexpression = ((_reduce).intValue() / _size);
    }
    return _xblockexpression;
  }
  
  public Iterable<Calificacion> calificacionesUltimoPartido() {
    Iterable<Calificacion> _xblockexpression = null;
    {
      List<Partido> _partidosJugados = this.getPartidosJugados();
      final Partido ultimoPartido = IterableExtensions.<Partido>last(_partidosJugados);
      List<Calificacion> _calificaciones = this.getCalificaciones();
      final Function1<Calificacion,Boolean> _function = new Function1<Calificacion,Boolean>() {
        public Boolean apply(final Calificacion calificacion) {
          Partido _partido = calificacion.getPartido();
          return Boolean.valueOf(Objects.equal(_partido, ultimoPartido));
        }
      };
      _xblockexpression = IterableExtensions.<Calificacion>filter(_calificaciones, _function);
    }
    return _xblockexpression;
  }
  
  public Iterable<Calificacion> ultimasCalificaciones(final Integer n) {
    List<Calificacion> _calificaciones = this.getCalificaciones();
    List<Calificacion> _reverse = ListExtensions.<Calificacion>reverse(_calificaciones);
    return IterableExtensions.<Calificacion>take(_reverse, (n).intValue());
  }
}
