package partido.core;

import java.util.List;
import partido.core.Jugador;

@SuppressWarnings("all")
public class Equipo {
  private List<Jugador> _jugadoresInscriptos;
  
  public List<Jugador> getJugadoresInscriptos() {
    return this._jugadoresInscriptos;
  }
  
  public void setJugadoresInscriptos(final List<Jugador> jugadoresInscriptos) {
    this._jugadoresInscriptos = jugadoresInscriptos;
  }
}
