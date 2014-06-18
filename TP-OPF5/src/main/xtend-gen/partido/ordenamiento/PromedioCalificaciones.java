package partido.ordenamiento;

import partido.core.Jugador;
import partido.core.Partido;
import partido.ordenamiento.Ordenamiento;

@SuppressWarnings("all")
public class PromedioCalificaciones extends Ordenamiento {
  public PromedioCalificaciones(final Partido partido) {
    super(partido);
  }
  
  public int ordenar(final Jugador jugador) {
    return jugador.promedioDeCalificacionesUltimoPartido();
  }
}
