package partido.ordenamiento;

import partido.core.Jugador;
import partido.core.Partido;
import partido.ordenamiento.Ordenamiento;

@SuppressWarnings("all")
public class PromedioNCalificaciones extends Ordenamiento {
  private int _n;
  
  public int getN() {
    return this._n;
  }
  
  public void setN(final int n) {
    this._n = n;
  }
  
  public PromedioNCalificaciones(final Partido partido, final int n) {
    super(partido);
    this.setN(n);
  }
  
  public int ordenar(final Jugador jugador) {
    int _n = this.getN();
    return jugador.promedioDeCalificaciones(_n);
  }
}
