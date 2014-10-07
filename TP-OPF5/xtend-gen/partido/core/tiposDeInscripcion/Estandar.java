package partido.core.tiposDeInscripcion;

import partido.core.Jugador;
import partido.core.Partido;
import partido.core.tiposDeInscripcion.TipoInscripcion;

@SuppressWarnings("all")
public class Estandar implements /* Object */TipoInscripcion {
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
