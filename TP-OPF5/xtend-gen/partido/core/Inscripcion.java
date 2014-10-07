package partido.core;

import partido.core.Jugador;
import partido.core.tiposDeInscripcion.TipoInscripcion;

@SuppressWarnings("all")
public class Inscripcion {
  /* @Property
   */private TipoInscripcion tipoInscripcion;
  
  /* @Property
   */private Jugador jugador;
  
  /* @Property
   */private boolean estaConfirmada;
  
  public Inscripcion(final Jugador jug, final TipoInscripcion tipoIncrip) {
    this.tipoInscripcion = tipoIncrip;
    this.jugador = jug;
    this.estaConfirmada = false;
  }
  
  public Object sosInscripcionDe(final Jugador otroJugador) {
    throw new Error("Unresolved compilation problems:"
      + "\n== cannot be resolved."
      + "\nThe method or field getJugador is undefined for the type Inscripcion");
  }
  
  public boolean confirmar() {
    return this.estaConfirmada = true;
  }
}
