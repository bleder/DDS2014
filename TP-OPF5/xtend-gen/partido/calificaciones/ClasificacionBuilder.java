package partido.calificaciones;

import partido.calificaciones.Calificacion;
import partido.core.Jugador;
import partido.core.Partido;

@SuppressWarnings("all")
public class ClasificacionBuilder {
  /* @Property
   */private Partido partido;
  
  /* @Property
   */private int nota;
  
  /* @Property
   */private /* String */Object critica;
  
  /* @Property
   */private Jugador calificador;
  
  /* @Property
   */private Jugador calificado;
  
  public Calificacion build() {
    throw new Error("Unresolved compilation problems:"
      + "\n< cannot be resolved."
      + "\n> cannot be resolved."
      + "\n== cannot be resolved."
      + "\n! cannot be resolved"
      + "\n|| cannot be resolved");
  }
  
  public Object fueCalificado() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field calificaciones is not visible"
      + "\nexists cannot be resolved"
      + "\njugadorQueCalifico cannot be resolved"
      + "\n== cannot be resolved"
      + "\n&& cannot be resolved"
      + "\npartido cannot be resolved"
      + "\n== cannot be resolved");
  }
  
  public Partido conPartido(final Partido partido) {
    return this.partido = partido;
  }
  
  public int conNota(final int nota) {
    return this.nota = nota;
  }
  
  public String conCritica(final /* String */Object critica) {
    return this.critica = critica;
  }
  
  public Jugador conCalificador(final Jugador calificador) {
    return this.calificador = calificador;
  }
  
  public Jugador conCalificado(final Jugador calificado) {
    return this.calificado = calificado;
  }
}
