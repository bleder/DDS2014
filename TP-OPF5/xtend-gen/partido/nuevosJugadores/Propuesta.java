package partido.nuevosJugadores;

import partido.core.Jugador;

@SuppressWarnings("all")
public class Propuesta {
  /* @Property
   */private /* String */Object mail;
  
  /* @Property
   */private Jugador amigo;
  
  /* @Property
   */private /* String */Object nombre;
  
  /* @Property
   */private /* List<String> */Object mailsAmigos;
  
  public Propuesta(final /* String */Object mailDado, final Jugador amigoQueRecomendo, final /* String */Object nom, final /* List<String> */Object mails) {
    this.mail = mailDado;
    this.amigo = amigoQueRecomendo;
    this.nombre = nom;
    this.mailsAmigos = mails;
  }
}
