package utn.edu.dds.TP_OPF5;

import utn.edu.dds.TP_OPF5.Partido;

@SuppressWarnings("all")
public interface TipoInscripcion {
  public abstract void inscribirA(final /* Jugador */Object jugador, final Partido partido);
  
  public abstract boolean dejaAnotar();
  
  public abstract boolean tienePrioridad();
}
