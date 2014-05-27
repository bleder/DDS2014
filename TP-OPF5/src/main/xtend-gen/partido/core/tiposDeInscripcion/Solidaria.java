package partido.core.tiposDeInscripcion;

import partido.core.Jugador;
import partido.core.Partido;
import partido.core.tiposDeInscripcion.TipoInscripcion;

@SuppressWarnings("all")
public class Solidaria implements TipoInscripcion {
  public void inscribirA(final Jugador jugador, final Partido partido) {
    partido.agregarJugador(jugador, this);
  }
  
  public boolean tienePrioridad() {
    return true;
  }
  
  public boolean dejaAnotar() {
    return true;
  }
}
