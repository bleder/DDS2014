package partido.core.tiposDeInscripcion;

import partido.core.Jugador;
import partido.core.Partido;

@SuppressWarnings("all")
public interface TipoInscripcion {
  public abstract void inscribirA(final Jugador jugador, final Partido partido);
  
  public abstract boolean dejaAnotar();
  
  public abstract boolean tienePrioridad();
}
