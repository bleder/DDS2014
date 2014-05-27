package partido.decorators;

import partido.core.Jugador;
import partido.core.tiposDeInscripcion.TipoInscripcion;

@SuppressWarnings("all")
public interface PartidoInterface {
  public abstract void darBajaA(final Jugador jug);
  
  public abstract void eliminarInscripcion(final Jugador jug);
  
  public abstract void darBajaA(final Jugador jugBaja, final Jugador jugReemplazo, final TipoInscripcion inscripcion);
  
  public abstract void confirmarJugador(final Jugador jug);
  
  public abstract void agregarJugador(final Jugador jug, final TipoInscripcion inscripcion);
  
  public abstract boolean hayLugar();
  
  public abstract boolean hayAlgunoQueDejaAnotar();
  
  public abstract void sacarAlQueDejaAnotar();
  
  public abstract boolean estaInscripto(final Jugador jugador);
  
  public abstract void agregarInfraccion(final Jugador jug);
  
  public abstract boolean estasConfirmado();
  
  public abstract Jugador getAdministrador();
}
