package partido.ordenamiento;

import partido.core.Jugador;
import partido.core.Partido;

@SuppressWarnings("all")
public abstract class Ordenamiento {
  private Partido _partido;
  
  public Partido getPartido() {
    return this._partido;
  }
  
  public void setPartido(final Partido partido) {
    this._partido = partido;
  }
  
  public Ordenamiento(final Partido partido) {
    this.setPartido(partido);
  }
  
  public int ordenar(final Jugador jugador) {
    return 1;
  }
}
