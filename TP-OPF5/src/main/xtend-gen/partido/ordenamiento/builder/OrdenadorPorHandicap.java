package partido.ordenamiento.builder;

import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import partido.core.Inscripcion;
import partido.core.Jugador;
import partido.core.Partido;
import partido.ordenamiento.builder.OrdenadorLista;

@SuppressWarnings("all")
public class OrdenadorPorHandicap extends OrdenadorLista {
  public void ordenar(final Partido partido) {
    List<Inscripcion> _jugadoresInscriptos = partido.getJugadoresInscriptos();
    final Function1<Inscripcion,Integer> _function = new Function1<Inscripcion,Integer>() {
      public Integer apply(final Inscripcion inscripcion) {
        Jugador _jugador = inscripcion.getJugador();
        return Integer.valueOf(_jugador.getHandicap());
      }
    };
    IterableExtensions.<Inscripcion, Integer>sortBy(_jugadoresInscriptos, _function);
  }
}
