package utn.edu.dds.TP_OPF5;

import utn.edu.dds.TP_OPF5.Inscripcion;
import utn.edu.dds.TP_OPF5.Jugador;
import utn.edu.dds.TP_OPF5.Partido;

@SuppressWarnings("all")
public interface PartidoObserver {
  public abstract void notifyAltaInscripcion(final Inscripcion inscripcion, final Partido partido);
  
  public abstract void notifyBajaInscripcion(final Inscripcion inscripcion, final Partido partido);
  
  public abstract void notifyConfirmacion(final Jugador jugador, final Partido partido);
}
