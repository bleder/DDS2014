package partido.nuevosJugadores;

import partido.nuevosJugadores.Administrador;
import partido.nuevosJugadores.Propuesta;

@SuppressWarnings("all")
public class jugadorBuilder {
  /* @Property
   */private Propuesta propuesta;
  
  /* @Property
   */private Administrador administrador;
  
  public Administrador suAdministrador(final Administrador administrador) {
    return this.administrador = administrador;
  }
  
  public Propuesta conPropuesta(final Propuesta propuesta) {
    return this.propuesta = propuesta;
  }
  
  public List build() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field nombre is not visible"
      + "\nThe field mail is not visible"
      + "\nThe field amigo is not visible"
      + "\nThe field mail is not visible"
      + "\nThe field amigos is not visible"
      + "\nThe field mailsAmigos is not visible"
      + "\n! cannot be resolved");
  }
}
