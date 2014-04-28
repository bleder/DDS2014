package utn.edu.dds.TP_OPF5;

import java.util.ArrayList;
import java.util.List;
import utn.edu.dds.TP_OPF5.Jugador;

@SuppressWarnings("all")
public class Inscripcion {
  private List<Jugador> _jugadoresInscriptos;
  
  public List<Jugador> getJugadoresInscriptos() {
    return this._jugadoresInscriptos;
  }
  
  public void setJugadoresInscriptos(final List<Jugador> jugadoresInscriptos) {
    this._jugadoresInscriptos = jugadoresInscriptos;
  }
  
  private int _maxInscriptos = 10;
  
  public int getMaxInscriptos() {
    return this._maxInscriptos;
  }
  
  public void setMaxInscriptos(final int maxInscriptos) {
    this._maxInscriptos = maxInscriptos;
  }
  
  public Inscripcion() {
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    this.setJugadoresInscriptos(_arrayList);
  }
}
