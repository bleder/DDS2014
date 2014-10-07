package partido.ordenamiento;

import partido.core.Jugador;
import partido.core.Partido;
import partido.ordenamiento.Ordenamiento;

@SuppressWarnings("all")
public class PromedioNCalificaciones extends Ordenamiento {
  /* @Property
   */private int n;
  
  public PromedioNCalificaciones(final Partido partido, final int n) {
    super(partido);
    this.n = n;
  }
  
  public int ordenar(final Jugador jugador) {
    return (jugador.promedioDeCalificaciones(this.n)).ObjectValue();
  }
}
