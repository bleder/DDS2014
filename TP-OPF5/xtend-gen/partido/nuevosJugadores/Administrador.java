package partido.nuevosJugadores;

import partido.core.Jugador;
import partido.nuevosJugadores.Propuesta;
import partido.nuevosJugadores.Rechazo;
import partido.nuevosJugadores.jugadorBuilder;

@SuppressWarnings("all")
public class Administrador {
  /* @Property
   */private /* String */Object mail;
  
  /* @Property
   */private /* List<Propuesta> */Object posiblesJugadores;
  
  /* @Property
   */private /* List<Rechazo> */Object jugadoresRechazados;
  
  public Administrador(final /* String */Object adminMail) {
    throw new Error("Unresolved compilation problems:"
      + "\nArrayList cannot be resolved."
      + "\nArrayList cannot be resolved.");
  }
  
  public Object existePropuesta(final Propuesta propuesta) {
    throw new Error("Unresolved compilation problems:"
      + "\nexists cannot be resolved"
      + "\n== cannot be resolved");
  }
  
  public Object getPropuesta(final /* String */Object mail) {
    throw new Error("Unresolved compilation problems:"
      + "\nfindFirst cannot be resolved"
      + "\nmail cannot be resolved"
      + "\n== cannot be resolved");
  }
  
  public Object removerPropuesta(final Propuesta propuesta) {
    throw new Error("Unresolved compilation problems:"
      + "\nremove cannot be resolved");
  }
  
  public Object nuevaPropuesta(final Propuesta nuevaPropuesta) {
    throw new Error("Unresolved compilation problems:"
      + "\nadd cannot be resolved");
  }
  
  public Object ultimaPropuestaAgregada() {
    throw new Error("Unresolved compilation problems:"
      + "\nsize cannot be resolved"
      + "\nget cannot be resolved"
      + "\n- cannot be resolved");
  }
  
  public Object nuevoRechazo(final Rechazo nuevoRechazo) {
    throw new Error("Unresolved compilation problems:"
      + "\nadd cannot be resolved");
  }
  
  public Object aceptarPropuesta(final Propuesta propuesta) {
    Object _xblockexpression = null;
    {
      jugadorBuilder nuevoJugador = new jugadorBuilder();
      nuevoJugador.conPropuesta(propuesta);
      nuevoJugador.suAdministrador(this);
      nuevoJugador.build();
      _xblockexpression = this.removerPropuesta(propuesta);
    }
    return _xblockexpression;
  }
  
  public Object rechazarPropuesta(final Propuesta propuesta, final /* String */Object razon) {
    throw new Error("Unresolved compilation problems:"
      + "\n! cannot be resolved");
  }
  
  public int otogarNivelJuego(final Jugador jugador, final int nivelJuego) {
    return jugador.tuNivelDeJuegoEs(nivelJuego);
  }
}
