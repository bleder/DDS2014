package ar.edu.utn.frba.TP.OPF5;

import ar.edu.utn.frba.TP.OPF5.DateTime;
import ar.edu.utn.frba.TP.OPF5.Jugador;
import ar.edu.utn.frba.TP.OPF5.excepcion.PartidoCompletoExcepcion;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public abstract class Partido {
  private List<Jugador> _jugadoresInscriptos;
  
  public List<Jugador> getJugadoresInscriptos() {
    return this._jugadoresInscriptos;
  }
  
  public void setJugadoresInscriptos(final List<Jugador> jugadoresInscriptos) {
    this._jugadoresInscriptos = jugadoresInscriptos;
  }
  
  private DateTime _fechaHora;
  
  public DateTime getFechaHora() {
    return this._fechaHora;
  }
  
  public void setFechaHora(final DateTime fechaHora) {
    this._fechaHora = fechaHora;
  }
  
  public Partido(final DateTime fechaHora) {
    this.setFechaHora(fechaHora);
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    this.setJugadoresInscriptos(_arrayList);
  }
  
  public void agregarUnJugador(final Jugador jugador) {
    try {
      boolean _hayLugarPara = this.hayLugarPara(jugador);
      if (_hayLugarPara) {
        List<Jugador> _jugadoresInscriptos = this.getJugadoresInscriptos();
        _jugadoresInscriptos.add(jugador);
      } else {
        throw new PartidoCompletoExcepcion("No hay mas lugar, la lista de jugadores esta llena, n");
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public boolean hayLugarPara(final Jugador jugador) {
    List<Jugador> _jugadoresInscriptos = this.getJugadoresInscriptos();
    int _size = _jugadoresInscriptos.size();
    return (_size < 10);
  }
}
