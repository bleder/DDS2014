package utn.edu.dds.TP_OPF5;

import utn.edu.dds.TP_OPF5.Partido;
import utn.edu.dds.TP_OPF5.TipoInscripcion;

@SuppressWarnings("all")
public class Jugador {
  private String _nombre;
  
  public String getNombre() {
    return this._nombre;
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
  }
  
  public Jugador(final String nom) {
    this.setNombre(nom);
  }
  
  public boolean inscribite(final Partido partido, final TipoInscripcion tipoInscripcion) {
    tipoInscripcion.inscribirA(this, partido);
    return true;
  }
}
