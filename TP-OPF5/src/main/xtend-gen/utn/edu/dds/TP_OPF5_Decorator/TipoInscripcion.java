package utn.edu.dds.TP_OPF5_Decorator;

import utn.edu.dds.TP_OPF5_Decorator.Jugador;
import utn.edu.dds.TP_OPF5_Decorator.Partido;

@SuppressWarnings("all")
public interface TipoInscripcion {
  public abstract void inscribirA(final Jugador jugador, final Partido partido);
  
  public abstract boolean dejaAnotar();
  
  public abstract boolean tienePrioridad();
}
