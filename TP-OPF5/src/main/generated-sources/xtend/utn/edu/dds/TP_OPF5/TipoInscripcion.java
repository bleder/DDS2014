package utn.edu.dds.TP_OPF5;

import utn.edu.dds.TP_OPF5.Jugador;
import utn.edu.dds.TP_OPF5.Partido;

@SuppressWarnings("all")
public interface TipoInscripcion {
  public abstract void inscribirA(final Jugador jugador, final Partido partido);
  
  public abstract boolean sePuedeInscribir(final Partido partido);
  
  public abstract boolean dejaAnotar();
}
