package utn.edu.dds.TP_OPF5;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import utn.edu.dds.TP_OPF5.Notificador;
import utn.edu.dds.TP_OPF5.PartidoObserver;
import utn.edu.dds.TP_OPF5.TipoInscripcion;

@SuppressWarnings("all")
public class Partido {
  private String _nombrePartido;
  
  public String getNombrePartido() {
    return this._nombrePartido;
  }
  
  public void setNombrePartido(final String nombrePartido) {
    this._nombrePartido = nombrePartido;
  }
  
  private /* List<Inscripcion> */Object _jugadoresInscriptos;
  
  public /* List<Inscripcion> */Object getJugadoresInscriptos() {
    return this._jugadoresInscriptos;
  }
  
  public void setJugadoresInscriptos(final /* List<Inscripcion> */Object jugadoresInscriptos) {
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
  
  private /* Jugador */Object _administrador;
  
  public /* Jugador */Object getAdministrador() {
    return this._administrador;
  }
  
  public void setAdministrador(final /* Jugador */Object administrador) {
    this._administrador = administrador;
  }
  
  private int _maximoLista;
  
  public int getMaximoLista() {
    return this._maximoLista;
  }
  
  public void setMaximoLista(final int maximoLista) {
    this._maximoLista = maximoLista;
  }
  
  public Partido(final String nomPartido, final Notificador notifPartido, final /* Jugador */Object adminPartido) {
    this.setNombrePartido(nomPartido);
    ArrayList<Object> _arrayList = new ArrayList<Object>();
    this.setJugadoresInscriptos(_arrayList);
    ArrayList<PartidoObserver> _arrayList_1 = new ArrayList<PartidoObserver>();
    this.setObservers(_arrayList_1);
    this.setMaximoLista(10);
    this.setNotificador(notifPartido);
    this.setAdministrador(adminPartido);
  }
  
  public void eliminarInscripcion(final /* Jugador */Object jug) {
    List<Object> _jugadoresInscriptos = this.getJugadoresInscriptos();
    Object _buscarInscripcionDelJugador = this.buscarInscripcionDelJugador(jug);
    _jugadoresInscriptos.remove((_buscarInscripcionDelJugador).ObjectValue());
    List<PartidoObserver> _observers = this.getObservers();
    final Procedure1<PartidoObserver> _function = new Procedure1<PartidoObserver>() {
      public void apply(final PartidoObserver observer) {
        observer.jugadorDadoDeBaja(jug, Partido.this);
      }
    };
    IterableExtensions.<PartidoObserver>forEach(_observers, _function);
  }
  
  public Object buscarInscripcionDelJugador(final /* Jugador */Object jug) {
    throw new Error("Unresolved compilation problems:"
      + "\njugador cannot be resolved"
      + "\n== cannot be resolved");
  }
  
  public Object darBajaA(final /* Jugador */Object jug) {
    Object _xblockexpression = null;
    {
      this.eliminarInscripcion(jug);
      _xblockexpression = this.agregarInfraccion(jug);
    }
    return _xblockexpression;
  }
  
  public void darBajaA(final /* Jugador */Object jugBaja, final /* Jugador */Object jugReemplazo, final TipoInscripcion inscripcion) {
    this.eliminarInscripcion(jugBaja);
    this.agregarJugador(jugReemplazo, inscripcion);
  }
  
  public void confirmarJugador(final /* Jugador */Object jugador) {
    throw new Error("Unresolved compilation problems:"
      + "\nconfirmar cannot be resolved");
  }
  
  public void agregarJugador(final /* Jugador */Object jugador, final TipoInscripcion tipoIncripcion) {
    throw new Error("Unresolved compilation problems:"
      + "\nInscripcion cannot be resolved to a type."
      + "\nInscripcion cannot be resolved.");
  }
  
  public boolean hayLugar() {
    List<Object> _jugadoresInscriptos = this.getJugadoresInscriptos();
    int _size = _jugadoresInscriptos.size();
    int _maximoLista = this.getMaximoLista();
    return (_size < _maximoLista);
  }
  
  public boolean hayAlgunoQueDejaAnotar() {
    throw new Error("Unresolved compilation problems:"
      + "\ntipoInscripcion cannot be resolved"
      + "\ndejaAnotar cannot be resolved");
  }
  
  public Object sacarAlQueDejaAnotar() {
    throw new Error("Unresolved compilation problems:"
      + "\nInscripcion cannot be resolved to a type."
      + "\ntipoInscripcion cannot be resolved"
      + "\ndejaAnotar cannot be resolved");
  }
  
  public boolean estaInscripto(final /* Jugador */Object jugador) {
    throw new Error("Unresolved compilation problems:"
      + "\nsosInscripcionDe cannot be resolved");
  }
  
  public Object agregarInfraccion(final /* Jugador */Object jug) {
    throw new Error("Unresolved compilation problems:"
      + "\nInfraccion cannot be resolved."
      + "\nnuevaInfraccion cannot be resolved");
  }
  
  public boolean agregarObserver(final PartidoObserver obs) {
    List<PartidoObserver> _observers = this.getObservers();
    return _observers.add(obs);
  }
  
  public Boolean estasConfirmado() {
    throw new Error("Unresolved compilation problems:"
      + "\nestaConfirmada cannot be resolved");
  }
}
