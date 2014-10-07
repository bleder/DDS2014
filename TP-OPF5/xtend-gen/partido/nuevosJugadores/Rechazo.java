package partido.nuevosJugadores;

import partido.nuevosJugadores.Propuesta;

@SuppressWarnings("all")
public class Rechazo {
  /* @Property
   */private /* String */Object razon;
  
  /* @Property
   */private Propuesta propuesta;
  
  public Rechazo(final /* String */Object laRazon, final Propuesta propuestaRechazada) {
    this.razon = laRazon;
    this.propuesta = propuestaRechazada;
  }
}
