package utn.edu.dds.TP_OPF5;

import utn.edu.dds.TP_OPF5.Jugador;
import utn.edu.dds.TP_OPF5.TipoInscripcion;

@SuppressWarnings("all")
public interface PartidoInterface {
  public abstract void darBajaA(final Jugador jug);
  
  public abstract void eliminarInscripcion(final Jugador jug);
  
  public abstract void darBajaA(final Jugador jugBaja, final Jugador jugReemplazo, final TipoInscripcion inscripcion);
  
  public abstract void agregarJugador(final Jugador jugador, final TipoInscripcion tipoInscripcion);
  
  public abstract boolean hayLugar();
  
  public abstract boolean hayAlgunoQueDejaAnotar();
  
  public abstract void sacarAlQueDejaAnotar();
  
  public abstract boolean estaInscripto(final Jugador jugador);
  
  public abstract void agregarInfraccion(final Jugador jug);
}
