package utn.edu.dds.TP_OPF5_Decorator;

import utn.edu.dds.TP_OPF5_Decorator.Jugador;
import utn.edu.dds.TP_OPF5_Decorator.Partido;
import utn.edu.dds.TP_OPF5_Decorator.TipoInscripcion;

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
