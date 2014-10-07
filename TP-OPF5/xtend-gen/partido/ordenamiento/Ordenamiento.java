package partido.ordenamiento;

import partido.core.Jugador;
import partido.core.Partido;

@SuppressWarnings("all")
public abstract class Ordenamiento {
  /* @Property
   */private Partido partido;
  
  public Ordenamiento(final Partido partido) {
    this.partido = partido;
  }
  
  public int ordenar(final Jugador jugador) {
    return 1;
  }
}
