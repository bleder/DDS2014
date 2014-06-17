package divisionEquipo;

import partido.core.Partido;

@SuppressWarnings("all")
public abstract class Divisor {
  private Partido _partido;
  
  public Partido getPartido() {
    return this._partido;
  }
  
  public void setPartido(final Partido partido) {
    this._partido = partido;
  }
  
  public Divisor(final Partido partido) {
    this.setPartido(partido);
  }
  
  public abstract void dividir();
}
