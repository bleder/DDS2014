package utn.edu.dds.TP_OPF5;

import java.util.ArrayList;
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
  
  private int _maximoLista;
  
  public int getMaximoLista() {
    return this._maximoLista;
  }
  
  public void setMaximoLista(final int maximoLista) {
    this._maximoLista = maximoLista;
  }
  
  public Partido(final String nomPartido) {
    this.setNombrePartido(nomPartido);
    ArrayList<Inscripcion> _arrayList = new ArrayList<Inscripcion>();
    this.setJugadoresInscriptos(_arrayList);
    this.setMaximoLista(10);
  }
  
  public Object agregarJugador(final Jugador jugador, final TipoInscripcion tipoIncripcion) {
    throw new Error("Unresolved compilation problems:"
      + "\nmissing \'(\' at \'llegue\'"
      + "\nmissing \')\' at \'a\'"
      + "\nmissing \')\' at \'mi\'"
      + "\nmismatched input \':\' expecting \'}\'"
      + "\nThe method or field llegue is undefined for the type Partido"
      + "\nThe method or field a is undefined for the type Partido"
      + "\nThe method or field mi is undefined for the type Partido"
      + "\nThe method or field limite is undefined for the type Partido");
  }
}
