package utn.edu.dds.TP_OPF5_Observer;

import utn.edu.dds.TP_OPF5_Observer.Jugador;
import utn.edu.dds.TP_OPF5_Observer.Partido;

@SuppressWarnings("all")
public interface TipoInscripcion {
  public abstract void inscribirA(final Jugador jugador, final Partido partido);
  
  public abstract boolean dejaAnotar();
  
  public abstract boolean tienePrioridad();
}
