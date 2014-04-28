package ar.edu.utn.frba.TP.OPF5;

import ar.edu.utn.frba.TP.OPF5.Incripciones.TipoInscripcion;
import ar.edu.utn.frba.TP.OPF5.Partido;

@SuppressWarnings("all")
public class Jugador {
  private String _nombre;
  
  public String getNombre() {
    return this._nombre;
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
  }
  
  public void inscribite(final Partido partido, final TipoInscripcion tipoInscripcion) {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from Jugador to Jugador");
  }
}
