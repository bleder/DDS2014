package divisionEquipo;

import partido.core.Partido;

@SuppressWarnings("all")
public abstract class Divisor /* implements Entity  */{
  /* @Property
   */private Partido partido;
  
  public Divisor(final Partido partido) {
    this.partido = partido;
  }
  
  public void dividir() {
    throw new Error("Unresolved compilation problems:"
      + "\n..< cannot be resolved."
      + "\nThe field jugadoresInscriptos is not visible"
      + "\nThe field equipo1 is not visible"
      + "\nThe field jugadoresInscriptos is not visible"
      + "\nThe field equipo2 is not visible"
      + "\nThe field jugadoresInscriptos is not visible"
      + "\nsize cannot be resolved"
      + "\nadd cannot be resolved"
      + "\nget cannot be resolved"
      + "\njugador cannot be resolved"
      + "\nadd cannot be resolved"
      + "\nget cannot be resolved"
      + "\njugador cannot be resolved");
  }
  
  public abstract boolean vaAlEquipo1(final int idx);
}
