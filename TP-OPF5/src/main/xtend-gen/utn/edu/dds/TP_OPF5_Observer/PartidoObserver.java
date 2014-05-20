package utn.edu.dds.TP_OPF5_Observer;

import utn.edu.dds.TP_OPF5_Observer.Inscripcion;
import utn.edu.dds.TP_OPF5_Observer.Jugador;
import utn.edu.dds.TP_OPF5_Observer.Partido;

@SuppressWarnings("all")
public interface PartidoObserver {
  public abstract void notifyAltaInscripcion(final Inscripcion inscripcion, final Partido partido);
  
  public abstract void notifyBajaInscripcion(final Inscripcion inscripcion, final Partido partido);
  
  public abstract void notifyConfirmacion(final Jugador jugador, final Partido partido);
}
