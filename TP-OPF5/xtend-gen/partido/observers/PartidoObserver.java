package partido.observers;

import partido.core.Jugador;
import partido.core.Partido;

@SuppressWarnings("all")
public interface PartidoObserver {
  public abstract void jugadorInscripto(final Jugador jugador, final Partido partido);
  
  public abstract void jugadorDadoDeBaja(final Jugador jugador, final Partido partido);
  
  public abstract void jugadorConfirmado(final Jugador jugador, final Partido partido);
}
