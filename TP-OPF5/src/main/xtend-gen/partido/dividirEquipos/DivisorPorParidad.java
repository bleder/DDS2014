package partido.dividirEquipos;

import java.util.List;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import partido.core.Equipo;
import partido.core.Inscripcion;
import partido.core.Jugador;
import partido.core.Partido;
import partido.dividirEquipos.DivisorDeEquipos;

@SuppressWarnings("all")
public class DivisorPorParidad extends DivisorDeEquipos {
  public void dividirEquiposDeUnPartido(final Partido partido) {
    List<Inscripcion> _jugadoresInscriptos = partido.getJugadoresInscriptos();
    int _size = _jugadoresInscriptos.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer a : _doubleDotLessThan) {
      if ((((a).intValue() % 2) == 0)) {
        Equipo _equipo1 = partido.getEquipo1();
        List<Jugador> _jugadoresInscriptos_1 = _equipo1.getJugadoresInscriptos();
        List<Inscripcion> _jugadoresInscriptos_2 = partido.getJugadoresInscriptos();
        Inscripcion _get = _jugadoresInscriptos_2.get((a).intValue());
        Jugador _jugador = _get.getJugador();
        _jugadoresInscriptos_1.add(_jugador);
      } else {
        Equipo _equipo2 = partido.getEquipo2();
        List<Jugador> _jugadoresInscriptos_3 = _equipo2.getJugadoresInscriptos();
        List<Inscripcion> _jugadoresInscriptos_4 = partido.getJugadoresInscriptos();
        Inscripcion _get_1 = _jugadoresInscriptos_4.get((a).intValue());
        Jugador _jugador_1 = _get_1.getJugador();
        _jugadoresInscriptos_3.add(_jugador_1);
      }
    }
  }
}
