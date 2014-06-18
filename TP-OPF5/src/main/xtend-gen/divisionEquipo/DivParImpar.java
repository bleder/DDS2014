package divisionEquipo;

import divisionEquipo.Divisor;
import partido.core.Partido;

@SuppressWarnings("all")
public class DivParImpar extends Divisor {
  public DivParImpar(final Partido partido) {
    super(partido);
  }
  
  public boolean vaAlEquipo1(final int x) {
    return ((x % 2) == 0);
  }
}
