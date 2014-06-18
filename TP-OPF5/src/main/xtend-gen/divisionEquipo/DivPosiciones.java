package divisionEquipo;

import divisionEquipo.Divisor;
import java.util.ArrayList;
import java.util.List;
import partido.core.Partido;

@SuppressWarnings("all")
public class DivPosiciones extends Divisor {
  private List<Integer> _posiciones = new ArrayList<Integer>();
  
  public List<Integer> getPosiciones() {
    return this._posiciones;
  }
  
  public void setPosiciones(final List<Integer> posiciones) {
    this._posiciones = posiciones;
  }
  
  public DivPosiciones(final Partido partido, final List<Integer> posiciones) {
    super(partido);
    this.setPosiciones(posiciones);
  }
  
  public boolean vaAlEquipo1(final int idx) {
    List<Integer> _posiciones = this.getPosiciones();
    return _posiciones.contains(Integer.valueOf(idx));
  }
}
