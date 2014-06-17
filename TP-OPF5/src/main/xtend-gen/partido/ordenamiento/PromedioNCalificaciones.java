package partido.ordenamiento;

import java.util.ArrayList;
import java.util.List;
import partido.core.Inscripcion;
import partido.core.Jugador;
import partido.core.Partido;
import partido.ordenamiento.Ordenamiento;

@SuppressWarnings("all")
public class PromedioNCalificaciones extends Ordenamiento {
  private List<Inscripcion> incripcionesOrdenadas = new ArrayList<Inscripcion>();
  
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
    return (jugador.promedioDeCalificaciones(_n)).intValue();
  }
}
