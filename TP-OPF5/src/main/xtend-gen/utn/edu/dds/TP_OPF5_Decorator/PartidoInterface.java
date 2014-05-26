package utn.edu.dds.TP_OPF5_Decorator;

import utn.edu.dds.TP_OPF5_Decorator.Jugador;
import utn.edu.dds.TP_OPF5_Decorator.Notificador;
import utn.edu.dds.TP_OPF5_Decorator.TipoInscripcion;

@SuppressWarnings("all")
public interface PartidoInterface {
  public abstract Jugador getAdministrador();
  
  public abstract int getMaximoLista();
  
  public abstract Notificador getNotificador();
  
  public abstract void darBajaA(final Jugador jug);
  
  public abstract void eliminarInscripcion(final Jugador jug);
  
  public abstract void darBajaA(final Jugador jugBaja, final Jugador jugReemplazo, final TipoInscripcion inscripcion);
  
  public abstract void confirmarJugador(final Jugador jugador);
  
  public abstract void agregarJugador(final Jugador jugador, final TipoInscripcion tipoIncripcion);
  
  public abstract boolean hayLugar();
  
  public abstract boolean hayAlgunoQueDejaAnotar();
  
  public abstract void sacarAlQueDejaAnotar();
  
  public abstract boolean estaInscripto(final Jugador jugador);
  
  public abstract void agregarInfraccion(final Jugador jug);
  
  public abstract void notificarAlta(final Jugador jugador);
  
  public abstract void notificarBaja(final Jugador jugador);
  
  public abstract Boolean estasConfirmado();
}
