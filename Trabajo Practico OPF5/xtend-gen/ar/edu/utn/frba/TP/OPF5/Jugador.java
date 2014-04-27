package ar.edu.utn.frba.TP.OPF5;

import ar.edu.utn.frba.TP.OPF5.Incripciones.TipoDeInscripcion;

@SuppressWarnings("all")
public class Jugador {
  private TipoDeInscripcion _TipoDeInscripcion;
  
  public TipoDeInscripcion getTipoDeInscripcion() {
    return this._TipoDeInscripcion;
  }
  
  public void setTipoDeInscripcion(final TipoDeInscripcion TipoDeInscripcion) {
    this._TipoDeInscripcion = TipoDeInscripcion;
  }
  
  private String _nombre;
  
  public String getNombre() {
    return this._nombre;
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
  }
}
