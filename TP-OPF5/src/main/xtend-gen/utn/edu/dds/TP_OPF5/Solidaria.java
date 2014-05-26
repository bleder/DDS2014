package utn.edu.dds.TP_OPF5;

import utn.edu.dds.TP_OPF5.Partido;
import utn.edu.dds.TP_OPF5.TipoInscripcion;

@SuppressWarnings("all")
public class Solidaria implements TipoInscripcion {
  public void inscribirA(final /* Jugador */Object jugador, final Partido partido) {
    partido.agregarJugador(jugador, this);
  }
  
  public boolean tienePrioridad() {
    return true;
  }
  
  public boolean dejaAnotar() {
    return true;
  }
}
