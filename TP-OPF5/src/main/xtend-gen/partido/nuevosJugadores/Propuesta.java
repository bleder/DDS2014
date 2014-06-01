package partido.nuevosJugadores;

import partido.core.Jugador;

@SuppressWarnings("all")
public class Propuesta {
  private String _mail;
  
  public String getMail() {
    return this._mail;
  }
  
  public void setMail(final String mail) {
    this._mail = mail;
  }
  
  private Jugador _amigo;
  
  public Jugador getAmigo() {
    return this._amigo;
  }
  
  public void setAmigo(final Jugador amigo) {
    this._amigo = amigo;
  }
  
  public Propuesta(final String mailDado, final Jugador amigoQueRecomendo) {
    this.setMail(mailDado);
    this.setAmigo(amigoQueRecomendo);
  }
}
