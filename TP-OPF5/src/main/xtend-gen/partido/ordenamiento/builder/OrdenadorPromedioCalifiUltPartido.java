package partido.ordenamiento.builder;

import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import partido.core.Inscripcion;
import partido.core.Jugador;
import partido.core.Partido;
import partido.ordenamiento.builder.OrdenadorLista;

@SuppressWarnings("all")
public class OrdenadorPromedioCalifiUltPartido extends OrdenadorLista {
  public void ordenar(final Partido partido) {
    List<Inscripcion> _jugadoresInscriptos = partido.getJugadoresInscriptos();
    final Function1<Inscripcion,Double> _function = new Function1<Inscripcion,Double>() {
      public Double apply(final Inscripcion inscripcion) {
        Jugador _jugador = inscripcion.getJugador();
        return Double.valueOf(_jugador.promedioUltimoPartido());
      }
    };
    IterableExtensions.<Inscripcion, Double>sortBy(_jugadoresInscriptos, _function);
  }
}
