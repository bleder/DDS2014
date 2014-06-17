package partido.ordenamiento;

import java.util.ArrayList;
import java.util.List;
import partido.core.Inscripcion;
import partido.core.Jugador;
import partido.core.Partido;
import partido.ordenamiento.Ordenamiento;

@SuppressWarnings("all")
public class PromedioCalificaciones extends Ordenamiento {
  private List<Inscripcion> incripcionesOrdenadas = new ArrayList<Inscripcion>();
  
  public PromedioCalificaciones(final Partido partido) {
    super(partido);
  }
  
  public int ordenar(final Jugador jugador) {
    return (jugador.promedioDeCalificacionesUltimoPartido()).intValue();
  }
}
