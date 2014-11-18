package partido.ordenamiento;

import partido.core.Jugador;
import partido.core.Partido;
import partido.ordenamiento.Ordenamiento;

@SuppressWarnings("all")
public class Handicap extends Ordenamiento {
  public Handicap(final Partido partido) {
    super(partido);
  }
  
  public int ordenar(final Jugador jugador) {
    return jugador.getNivelJuego();
  }
}
