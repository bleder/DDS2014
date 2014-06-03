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
import org.eclipse.xtext.xbase.lib.IterableExtensions;
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
  
  private List<Calificacion> _calificaciones = new ArrayList<Calificacion>();
  
  public List<Calificacion> getCalificaciones() {
    return this._calificaciones;
  }
  
  public void setCalificaciones(final List<Calificacion> calificaciones) {
    this._calificaciones = calificaciones;
  }
  
  public Jugador(final String nom, final String newMail) {
    this.setMail(newMail);
    this.setNombre(nom);
    ArrayList<Infraccion> _arrayList = new ArrayList<Infraccion>();
    this.setInfracciones(_arrayList);
    ArrayList<String> _arrayList_1 = new ArrayList<String>();
    this.setAmigos(_arrayList_1);
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
            Jugador _jugadorQueCalifico = calificacion.getJugadorQueCalifico();
            return Boolean.valueOf(Objects.equal(_jugadorQueCalifico, Jugador.this));
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
}
