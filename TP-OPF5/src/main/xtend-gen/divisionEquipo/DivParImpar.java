package divisionEquipo;

import divisionEquipo.Divisor;
import java.util.List;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import partido.core.Inscripcion;
import partido.core.Jugador;
import partido.core.Partido;

@SuppressWarnings("all")
public class DivParImpar extends Divisor {
  public DivParImpar(final Partido partido) {
    super(partido);
  }
  
  public void dividir() {
    Partido _partido = this.getPartido();
    List<Inscripcion> _jugadoresInscriptos = _partido.getJugadoresInscriptos();
    int _size = _jugadoresInscriptos.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer idx : _doubleDotLessThan) {
      boolean _esPar = this.esPar((idx).intValue());
      if (_esPar) {
        Partido _partido_1 = this.getPartido();
        List<Jugador> _equipo1 = _partido_1.getEquipo1();
        Partido _partido_2 = this.getPartido();
        List<Inscripcion> _jugadoresInscriptos_1 = _partido_2.getJugadoresInscriptos();
        Inscripcion _get = _jugadoresInscriptos_1.get((idx).intValue());
        Jugador _jugador = _get.getJugador();
        _equipo1.add(_jugador);
      } else {
        Partido _partido_3 = this.getPartido();
        List<Jugador> _equipo2 = _partido_3.getEquipo2();
        Partido _partido_4 = this.getPartido();
        List<Inscripcion> _jugadoresInscriptos_2 = _partido_4.getJugadoresInscriptos();
        Inscripcion _get_1 = _jugadoresInscriptos_2.get((idx).intValue());
        Jugador _jugador_1 = _get_1.getJugador();
        _equipo2.add(_jugador_1);
      }
    }
  }
  
  public boolean esPar(final int x) {
    return ((x % 2) == 0);
  }
}
