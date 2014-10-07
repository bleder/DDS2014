package partido.calificaciones;

import partido.core.Jugador;
import partido.core.Partido;

@SuppressWarnings("all")
public class Calificacion {
  /* @Property
   */private /* String */Object critica;
  
  /* @Property
   */private Jugador jugadorQueCalifico;
  
  /* @Property
   */private Partido partido;
  
  /* @Property
   */private int nota;
  
  public Calificacion(final /* String */Object string, final Jugador jugador, final Partido partidop, final int i) {
    this.critica = string;
    this.jugadorQueCalifico = jugador;
    this.partido = partidop;
    this.nota = i;
  }
}
