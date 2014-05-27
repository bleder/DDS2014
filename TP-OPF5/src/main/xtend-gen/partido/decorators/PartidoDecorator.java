package partido.decorators;

import partido.core.Jugador;
import partido.core.tiposDeInscripcion.TipoInscripcion;
import partido.decorators.PartidoInterface;

@SuppressWarnings("all")
public class PartidoDecorator implements PartidoInterface {
  private PartidoInterface decorado;
  
  public PartidoDecorator(final PartidoInterface partido) {
    this.decorado = partido;
  }
  
  public void darBajaA(final Jugador jug) {
    this.decorado.darBajaA(jug);
  }
  
  public void eliminarInscripcion(final Jugador jug) {
    this.decorado.eliminarInscripcion(jug);
  }
  
  public void darBajaA(final Jugador jugBaja, final Jugador jugReemplazo, final TipoInscripcion inscripcion) {
    this.decorado.darBajaA(jugBaja, jugReemplazo, inscripcion);
  }
  
  public void confirmarJugador(final Jugador jug) {
    this.decorado.confirmarJugador(jug);
  }
  
  public void agregarJugador(final Jugador jug, final TipoInscripcion inscripcion) {
    this.decorado.agregarJugador(jug, inscripcion);
  }
  
  public boolean hayLugar() {
    return this.decorado.hayLugar();
  }
  
  public boolean hayAlgunoQueDejaAnotar() {
    return this.decorado.hayAlgunoQueDejaAnotar();
  }
  
  public void sacarAlQueDejaAnotar() {
    this.decorado.sacarAlQueDejaAnotar();
  }
  
  public boolean estaInscripto(final Jugador jugador) {
    return this.decorado.estaInscripto(jugador);
  }
  
  public void agregarInfraccion(final Jugador jug) {
    this.decorado.agregarInfraccion(jug);
  }
  
  public boolean estasConfirmado() {
    return this.decorado.estasConfirmado();
  }
  
  public Jugador getAdministrador() {
    return this.decorado.getAdministrador();
  }
}
