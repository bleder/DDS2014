package partido.generacionEquipos;

import java.util.ArrayList;
import java.util.List;
import partido.core.Jugador;

@SuppressWarnings("all")
public class Equipo {
  private List<Jugador> _equipo;
  
  public List<Jugador> getEquipo() {
    return this._equipo;
  }
  
  public void setEquipo(final List<Jugador> equipo) {
    this._equipo = equipo;
  }
  
  public Equipo() {
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    this.setEquipo(_arrayList);
  }
  
  public boolean agregarJugador(final Jugador jug) {
    List<Jugador> _equipo = this.getEquipo();
    return _equipo.add(jug);
  }
}
