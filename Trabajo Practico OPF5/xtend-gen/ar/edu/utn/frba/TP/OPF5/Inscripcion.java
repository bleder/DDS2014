package ar.edu.utn.frba.TP.OPF5;

import ar.edu.utn.frba.TP.OPF5.Jugador;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class Inscripcion {
  private List<Jugador> _jugadoresInscriptos;
  
  public List<Jugador> getJugadoresInscriptos() {
    return this._jugadoresInscriptos;
  }
  
  public void setJugadoresInscriptos(final List<Jugador> jugadoresInscriptos) {
    this._jugadoresInscriptos = jugadoresInscriptos;
  }
  
  public Inscripcion() {
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    this.setJugadoresInscriptos(_arrayList);
  }
  
  private int _maxInscriptos = 10;
  
  public int getMaxInscriptos() {
    return this._maxInscriptos;
  }
  
  public void setMaxInscriptos(final int maxInscriptos) {
    this._maxInscriptos = maxInscriptos;
  }
}
