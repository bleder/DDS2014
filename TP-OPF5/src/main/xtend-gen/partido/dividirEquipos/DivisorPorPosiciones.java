package partido.dividirEquipos;

import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import partido.core.Inscripcion;
import partido.core.Partido;
import partido.dividirEquipos.DivisorDeEquipos;

@SuppressWarnings("all")
public class DivisorPorPosiciones extends DivisorDeEquipos {
  private List<Integer> posiciones;
  
  public void dividirEquiposDeUnPartido(final Partido partido) {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from Iterable<Inscripcion> to List<Jugador>");
  }
  
  public Iterable<Inscripcion> equipo1(final Partido partido) {
    List<Inscripcion> _jugadoresInscriptos = partido.getJugadoresInscriptos();
    final Function1<Inscripcion,Boolean> _function = new Function1<Inscripcion,Boolean>() {
      public Boolean apply(final Inscripcion it) {
        return Boolean.valueOf(DivisorPorPosiciones.this.esPosicionBuscada(it, partido));
      }
    };
    return IterableExtensions.<Inscripcion>filter(_jugadoresInscriptos, _function);
  }
  
  public boolean esPosicionBuscada(final Inscripcion inscripcion, final Partido partido) {
    List<Inscripcion> _jugadoresInscriptos = partido.getJugadoresInscriptos();
    int _indexOf = _jugadoresInscriptos.indexOf(inscripcion);
    return this.posiciones.contains(Integer.valueOf(_indexOf));
  }
}
