package partido.core.tiposDeInscripcion;

import partido.core.Jugador;
import partido.core.Partido;
import partido.core.tiposDeInscripcion.TipoInscripcion;

@SuppressWarnings("all")
public class Condicional implements /* Object */TipoInscripcion {
  /* @Property
   */private /* Function1<Partido, Boolean> */Object condicion = new Object() {
  };
  
  public Condicional(final /* Function1<Partido, Boolean> */Object miCondicion) {
    this.condicion = miCondicion;
  }
  
  public void inscribirA(final Jugador jugador, final Partido partido) {
    throw new Error("Unresolved compilation problems:"
      + "\napply cannot be resolved"
      + "\n! cannot be resolved");
  }
  
  public boolean tienePrioridad() {
    return false;
  }
  
  public boolean dejaAnotar() {
    return true;
  }
}
