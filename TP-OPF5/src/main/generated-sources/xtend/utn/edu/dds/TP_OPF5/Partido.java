package utn.edu.dds.TP_OPF5;

import java.util.List;
import utn.edu.dds.TP_OPF5.Inscripcion;
import utn.edu.dds.TP_OPF5.Jugador;
import utn.edu.dds.TP_OPF5.TipoInscripcion;

@SuppressWarnings("all")
public class Partido {
  private String _nombrePartido;
  
  public String getNombrePartido() {
    return this._nombrePartido;
  }
  
  public void setNombrePartido(final String nombrePartido) {
    this._nombrePartido = nombrePartido;
  }
  
  private List<Inscripcion> _jugadoresInscriptos;
  
  public List<Inscripcion> getJugadoresInscriptos() {
    return this._jugadoresInscriptos;
  }
  
  public void setJugadoresInscriptos(final List<Inscripcion> jugadoresInscriptos) {
    this._jugadoresInscriptos = jugadoresInscriptos;
  }
  
  private int _maximoLista = 10;
  
  public int getMaximoLista() {
    return this._maximoLista;
  }
  
  public void setMaximoLista(final int maximoLista) {
    this._maximoLista = maximoLista;
  }
  
  public Partido(final String nomPartido) {
    this.setNombrePartido(nomPartido);
  }
  
  public boolean agregarJugador(final Jugador jugador, final TipoInscripcion tipoIncripcion) {
    boolean _xblockexpression = false;
    {
      Inscripcion inscripcion = null;
      Inscripcion _inscripcion = new Inscripcion(jugador, tipoIncripcion);
      inscripcion = _inscripcion;
      List<Inscripcion> _jugadoresInscriptos = this.getJugadoresInscriptos();
      _xblockexpression = _jugadoresInscriptos.add(inscripcion);
    }
    return _xblockexpression;
  }
  
  public boolean hayLugarPara(final Jugador jugador) {
    List<Inscripcion> _jugadoresInscriptos = this.getJugadoresInscriptos();
    int _size = _jugadoresInscriptos.size();
    int _maximoLista = this.getMaximoLista();
    return (_size < _maximoLista);
  }
}
