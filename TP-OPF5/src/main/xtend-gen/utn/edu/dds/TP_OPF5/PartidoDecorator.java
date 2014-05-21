package utn.edu.dds.TP_OPF5;

import com.google.common.base.Objects;
import exception.PartidoCompletoExcepcion;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import utn.edu.dds.TP_OPF5.Infraccion;
import utn.edu.dds.TP_OPF5.Inscripcion;
import utn.edu.dds.TP_OPF5.Jugador;
import utn.edu.dds.TP_OPF5.Notificador;
import utn.edu.dds.TP_OPF5.PartidoInterface;
import utn.edu.dds.TP_OPF5.PartidoObserver;
import utn.edu.dds.TP_OPF5.TipoInscripcion;

@SuppressWarnings("all")
public class PartidoDecorator implements PartidoInterface {
  private String _nombrePartido;
  
  public String getNombrePartido() {
    return this._nombrePartido;
  }
  
  public void setNombrePartido(final String nombrePartido) {
    this._nombrePartido = nombrePartido;
  }
  
  private List<Inscripcion> _jugadoresInscriptos;
  
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
  
  private Notificador _notificador;
  
  public Notificador getNotificador() {
    return this._notificador;
  }
  
  public void setNotificador(final Notificador notificador) {
    this._notificador = notificador;
  }
  
  private Jugador _administrador;
  
  public Jugador getAdministrador() {
    return this._administrador;
  }
  
  public void setAdministrador(final Jugador administrador) {
    this._administrador = administrador;
  }
  
  private int _maximoLista;
  
  public int getMaximoLista() {
    return this._maximoLista;
  }
  
  public void setMaximoLista(final int maximoLista) {
    this._maximoLista = maximoLista;
  }
  
  public PartidoDecorator(final String nomPartido, final Notificador notifPartido, final Jugador adminPartido) {
    this.setNombrePartido(nomPartido);
    ArrayList<Inscripcion> _arrayList = new ArrayList<Inscripcion>();
    this.setJugadoresInscriptos(_arrayList);
    ArrayList<PartidoObserver> _arrayList_1 = new ArrayList<PartidoObserver>();
    this.setObservers(_arrayList_1);
    this.setMaximoLista(10);
    this.setNotificador(notifPartido);
    this.setAdministrador(adminPartido);
  }
  
  public void darBajaA(final Jugador jug) {
    this.eliminarInscripcion(jug);
    this.agregarInfraccion(jug);
  }
  
  public void eliminarInscripcion(final Jugador jug) {
    List<Inscripcion> _jugadoresInscriptos = this.getJugadoresInscriptos();
    List<Inscripcion> _jugadoresInscriptos_1 = this.getJugadoresInscriptos();
    final Function1<Inscripcion,Boolean> _function = new Function1<Inscripcion,Boolean>() {
      public Boolean apply(final Inscripcion inscripcion) {
        Jugador _jugador = inscripcion.getJugador();
        return Boolean.valueOf(Objects.equal(_jugador, jug));
      }
    };
    Inscripcion _findFirst = IterableExtensions.<Inscripcion>findFirst(_jugadoresInscriptos_1, _function);
    _jugadoresInscriptos.remove(_findFirst);
  }
  
  public void darBajaA(final Jugador jugBaja, final Jugador jugReemplazo, final TipoInscripcion inscripcion) {
    this.eliminarInscripcion(jugBaja);
    this.agregarJugador(jugReemplazo, inscripcion);
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
  
  public void sacarAlQueDejaAnotar() {
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
    _jugadoresInscriptos_1.remove(inscripcionABorrar);
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
  
  public void agregarInfraccion(final Jugador jug) {
    List<Infraccion> _infracciones = jug.getInfracciones();
    Infraccion _infraccion = new Infraccion("Dado de baja");
    _infracciones.add(_infraccion);
  }
}
