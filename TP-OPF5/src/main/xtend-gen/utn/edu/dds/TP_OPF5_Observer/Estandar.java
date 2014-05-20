package utn.edu.dds.TP_OPF5_Observer;

import utn.edu.dds.TP_OPF5_Observer.Jugador;
import utn.edu.dds.TP_OPF5_Observer.Partido;
import utn.edu.dds.TP_OPF5_Observer.TipoInscripcion;

@SuppressWarnings("all")
public class Estandar implements TipoInscripcion {
  public void inscribirA(final Jugador jugador, final Partido partido) {
    partido.agregarJugador(jugador, this);
  }
  
  public boolean tienePrioridad() {
    return true;
  }
  
  public boolean dejaAnotar() {
    return false;
  }
}
