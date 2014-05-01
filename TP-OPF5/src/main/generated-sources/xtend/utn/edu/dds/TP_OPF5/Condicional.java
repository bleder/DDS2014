package utn.edu.dds.TP_OPF5;

import utn.edu.dds.TP_OPF5.Jugador;
import utn.edu.dds.TP_OPF5.Partido;
import utn.edu.dds.TP_OPF5.TipoInscripcion;

@SuppressWarnings("all")
public class Condicional implements TipoInscripcion {
  private boolean _condicion = true;
  
  public boolean isCondicion() {
    return this._condicion;
  }
  
  public void setCondicion(final boolean condicion) {
    this._condicion = condicion;
  }
  
  public void inscribirA(final Jugador jugador, final Partido partido) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method hayLugar is undefined for the type Condicional"
      + "\n! cannot be resolved");
  }
  
  public boolean dejaAnotar() {
    return true;
  }
}
