package partido.ordenamiento;

import java.util.ArrayList;
import java.util.List;
import partido.ordenamiento.Ordenamiento;

@SuppressWarnings("all")
public class MixOrdenamiento {
  private List<Ordenamiento> _ordenamientos = new ArrayList<Ordenamiento>();
  
  public List<Ordenamiento> getOrdenamientos() {
    return this._ordenamientos;
  }
  
  public void setOrdenamientos(final List<Ordenamiento> ordenamientos) {
    this._ordenamientos = ordenamientos;
  }
}
