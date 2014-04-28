package utn.edu.dds.TP_OPF5;

import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;
import utn.edu.dds.TP_OPF5.Jugador;
import utn.edu.dds.TP_OPF5.exception.PartidoCompletoExcepcion;

@SuppressWarnings("all")
public class Partido {
  private String _nombrePartido;
  
  public String getNombrePartido() {
    return this._nombrePartido;
  }
  
  public void setNombrePartido(final String nombrePartido) {
    this._nombrePartido = nombrePartido;
  }
  
  public Partido(final String nomPartido) {
    this.setNombrePartido(nomPartido);
  }
  
  private List<Jugador> _jugadoresInscriptos;
  
  public List<Jugador> getJugadoresInscriptos() {
    return this._jugadoresInscriptos;
  }
  
  public void setJugadoresInscriptos(final List<Jugador> jugadoresInscriptos) {
    this._jugadoresInscriptos = jugadoresInscriptos;
  }
  
  public void inscribirA(final Jugador jugador) {
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
