package utn.edu.dds.TP_OPF5;

import utn.edu.dds.TP_OPF5.Jugador;
import utn.edu.dds.TP_OPF5.Partido;
import utn.edu.dds.TP_OPF5.TipoInscripcion;

@SuppressWarnings("all")
public class Solidaria implements TipoInscripcion {
  public void inscribirA(final Jugador jugador, final Partido partido) {
    boolean _hayLugar = partido.hayLugar();
    if (_hayLugar) {
      partido.agregarJugador(jugador, this);
    }
  }
  
  public boolean sePuedeInscribir(final Partido partido) {
    return partido.hayLugar();
  }
  
  public boolean dejaAnotar() {
    return true;
  }
}
