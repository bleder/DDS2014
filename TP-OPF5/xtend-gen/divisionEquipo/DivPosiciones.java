package divisionEquipo;

import divisionEquipo.Divisor;
import partido.core.Partido;

@SuppressWarnings("all")
public class DivPosiciones extends Divisor {
  /* @Property
   */private /* List<Integer> */Object posiciones /* Skipped initializer because of errors */;
  
  public DivPosiciones(final Partido partido, final /* List<Integer> */Object posiciones) {
    super(partido);
    this.posiciones = posiciones;
  }
  
  public boolean vaAlEquipo1(final int idx) {
    throw new Error("Unresolved compilation problems:"
      + "\ncontains cannot be resolved");
  }
}
