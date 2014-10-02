package divisionEquipo;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import partido.core.Inscripcion;
import partido.core.Jugador;
import partido.core.Partido;

@SuppressWarnings("all")
public abstract class Divisor {
  private Partido _partido;
  
  public Partido getPartido() {
    return this._partido;
  }
  
  public void setPartido(final Partido partido) {
    this._partido = partido;
  }
  
  public Divisor(final Partido partido) {
    this.setPartido(partido);
  }
  
  public void dividir() {
    Partido _partido = this.getPartido();
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    _partido.setEquipo1(_arrayList);
    Partido _partido_1 = this.getPartido();
    ArrayList<Jugador> _arrayList_1 = new ArrayList<Jugador>();
    _partido_1.setEquipo2(_arrayList_1);
    Partido _partido_2 = this.getPartido();
    List<Inscripcion> _jugadoresInscriptos = _partido_2.getJugadoresInscriptos();
    int _size = _jugadoresInscriptos.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer idx : _doubleDotLessThan) {
      boolean _vaAlEquipo1 = this.vaAlEquipo1((idx).intValue());
      if (_vaAlEquipo1) {
        Partido _partido_3 = this.getPartido();
        List<Jugador> _equipo1 = _partido_3.getEquipo1();
        Partido _partido_4 = this.getPartido();
        List<Inscripcion> _jugadoresInscriptos_1 = _partido_4.getJugadoresInscriptos();
        Inscripcion _get = _jugadoresInscriptos_1.get((idx).intValue());
        Jugador _jugador = _get.getJugador();
        _equipo1.add(_jugador);
      } else {
        Partido _partido_5 = this.getPartido();
        List<Jugador> _equipo2 = _partido_5.getEquipo2();
        Partido _partido_6 = this.getPartido();
        List<Inscripcion> _jugadoresInscriptos_2 = _partido_6.getJugadoresInscriptos();
        Inscripcion _get_1 = _jugadoresInscriptos_2.get((idx).intValue());
        Jugador _jugador_1 = _get_1.getJugador();
        _equipo2.add(_jugador_1);
      }
    }
  }
  
  public abstract boolean vaAlEquipo1(final int idx);
}
