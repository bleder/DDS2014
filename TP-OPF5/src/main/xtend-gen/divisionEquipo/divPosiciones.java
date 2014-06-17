package divisionEquipo;

import divisionEquipo.Divisor;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import partido.core.Inscripcion;
import partido.core.Jugador;
import partido.core.Partido;

@SuppressWarnings("all")
public class divPosiciones extends Divisor {
  private List<Integer> _posiciones = new ArrayList<Integer>(5);
  
  public List<Integer> getPosiciones() {
    return this._posiciones;
  }
  
  public void setPosiciones(final List<Integer> posiciones) {
    this._posiciones = posiciones;
  }
  
  public divPosiciones(final Partido partido, final List<Integer> posiciones) {
    super(partido);
    this.setPosiciones(posiciones);
  }
  
  public void dividir() {
    Partido _partido = this.getPartido();
    List<Inscripcion> _jugadoresInscriptos = _partido.getJugadoresInscriptos();
    int _size = _jugadoresInscriptos.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer idx : _doubleDotLessThan) {
      boolean _estaEnPosiciones = this.estaEnPosiciones((idx).intValue());
      if (_estaEnPosiciones) {
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
  
  public boolean estaEnPosiciones(final int idx) {
    List<Integer> _posiciones = this.getPosiciones();
    return _posiciones.contains(Integer.valueOf(idx));
  }
}
