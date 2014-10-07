package partido.nuevosJugadores;

import partido.core.Jugador;
import partido.nuevosJugadores.Propuesta;

@SuppressWarnings("all")
public class PropuestaBuilder {
  /* @Property
   */private /* String */Object mailPropuesto;
  
  /* @Property
   */private Jugador amigo;
  
  /* @Property
   */private /* String */Object nombre;
  
  /* @Property
   */private /* List<String> */Object mailsAmigos;
  
  public Jugador conAmigoDelPropuesto(final Jugador amigoQuePropuso) {
    return this.amigo = amigoQuePropuso;
  }
  
  public String conMail(final /* String */Object mail) {
    return this.mailPropuesto = mail;
  }
  
  public List conAmigos(final /* List<String> */Object mailsAmigos) {
    return this.mailsAmigos = mailsAmigos;
  }
  
  public String conNombre(final /* String */Object nombre) {
    return this.nombre = nombre;
  }
  
  public Propuesta build() {
    throw new Error("Unresolved compilation problems:"
      + "\n! cannot be resolved");
  }
}
