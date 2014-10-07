package partido.core;

import divisionEquipo.Divisor;
import exception.PartidoConfirmadoNoAceptaBaja;
import org.eclipse.xtext.xbase.lib.Exceptions;
import partido.core.Infraccion;
import partido.core.Inscripcion;
import partido.core.Jugador;
import partido.core.tiposDeInscripcion.TipoInscripcion;
import partido.nuevosJugadores.Administrador;
import partido.observers.PartidoObserver;
import partido.ordenamiento.Ordenamiento;

@SuppressWarnings("all")
public class Partido /* implements Entity  */{
  private /* List<Inscripcion> */Object incripcionesOrdenadas /* Skipped initializer because of errors */;
  
  /* @Property
   */private /* String */Object nombrePartido;
  
  /* @Property
   */private /* List<Inscripcion> */Object jugadoresInscriptos /* Skipped initializer because of errors */;
  
  /* @Property
   */private /* List<PartidoObserver> */Object observers;
  
  /* @Property
   */private /* List<Jugador> */Object jugadores;
  
  /* @Property
   */private Administrador administrador;
  
  /* @Property
   */private int maximoLista;
  
  /* @Property
   */private /* List<Jugador> */Object equipo1 /* Skipped initializer because of errors */;
  
  /* @Property
   */private /* List<Jugador> */Object equipo2 /* Skipped initializer because of errors */;
  
  /* @Property
   */private Divisor divisorEquipo;
  
  /* @Property
   */private boolean confirmadoAdm;
  
  /* @Property
   */private /* List<Jugador> */Object jugadoresHome;
  
  public Partido(final /* String */Object nomPartido, final Administrador adminPartido) {
    throw new Error("Unresolved compilation problems:"
      + "\nArrayList cannot be resolved."
      + "\nArrayList cannot be resolved.");
  }
  
  public Object eliminarInscripcion(final Jugador jug) {
    throw new Error("Unresolved compilation problems:"
      + "\nremove cannot be resolved"
      + "\nforEach cannot be resolved"
      + "\njugadorDadoDeBaja cannot be resolved");
  }
  
  public Object buscarInscripcionDelJugador(final Jugador jug) {
    throw new Error("Unresolved compilation problems:"
      + "\nfindFirst cannot be resolved"
      + "\njugador cannot be resolved"
      + "\n== cannot be resolved");
  }
  
  public Object darBajaA(final Jugador jug) {
    try {
      Object _xblockexpression = null;
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
  
  public Object darBajaA(final Jugador jugBaja, final Jugador jugReemplazo, final TipoInscripcion inscripcion) {
    try {
      Object _xblockexpression = null;
      {
        if (this.confirmadoAdm) {
          throw new PartidoConfirmadoNoAceptaBaja("El partido esta confirmado no se puede dar de baja el jugador");
        }
        this.eliminarInscripcion(jugBaja);
        _xblockexpression = this.agregarJugador(jugReemplazo, inscripcion);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Object confirmarJugador(final Jugador jugador) {
    throw new Error("Unresolved compilation problems:"
      + "\nconfirmar cannot be resolved"
      + "\nforEach cannot be resolved"
      + "\njugadorConfirmado cannot be resolved");
  }
  
  public Object agregarJugador(final Jugador jugador, final TipoInscripcion tipoIncripcion) {
    throw new Error("Unresolved compilation problems:"
      + "\nadd cannot be resolved"
      + "\nadd cannot be resolved"
      + "\nforEach cannot be resolved"
      + "\njugadorInscripto cannot be resolved");
  }
  
  public boolean hayLugar() {
    throw new Error("Unresolved compilation problems:"
      + "\nsize cannot be resolved"
      + "\n< cannot be resolved");
  }
  
  public Object hayAlgunoQueDejaAnotar() {
    throw new Error("Unresolved compilation problems:"
      + "\nexists cannot be resolved"
      + "\ntipoInscripcion cannot be resolved"
      + "\ndejaAnotar cannot be resolved");
  }
  
  public Object sacarAlQueDejaAnotar() {
    throw new Error("Unresolved compilation problems:"
      + "\nfindFirst cannot be resolved"
      + "\ntipoInscripcion cannot be resolved"
      + "\ndejaAnotar cannot be resolved"
      + "\nremove cannot be resolved");
  }
  
  public Object estaInscripto(final Jugador jugador) {
    throw new Error("Unresolved compilation problems:"
      + "\nexists cannot be resolved"
      + "\nsosInscripcionDe cannot be resolved");
  }
  
  public Object agregarInfraccion(final Jugador jug) {
    Infraccion _infraccion = new Infraccion("Dado de baja");
    return jug.nuevaInfraccion(_infraccion);
  }
  
  public Object agregarObserver(final PartidoObserver obs) {
    throw new Error("Unresolved compilation problems:"
      + "\nadd cannot be resolved");
  }
  
  public Object cantidadConfirmados() {
    throw new Error("Unresolved compilation problems:"
      + "\nfilter cannot be resolved"
      + "\nestaConfirmada cannot be resolved"
      + "\nsize cannot be resolved");
  }
  
  public boolean estasConfirmado() {
    throw new Error("Unresolved compilation problems:"
      + "\n== cannot be resolved");
  }
  
  public List partidoOrdenaJugadores(final Ordenamiento criterio) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field jugador is undefined for the type Partido"
      + "\nsortBy cannot be resolved");
  }
  
  public void partidoDividiEquipos() {
    throw new Error("Unresolved compilation problems:"
      + "\n! cannot be resolved.");
  }
  
  public boolean confirmate() {
    throw new Error("Unresolved compilation problems:"
      + "\nempty cannot be resolved"
      + "\n&& cannot be resolved"
      + "\nempty cannot be resolved");
  }
}
