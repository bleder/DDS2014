package partido.nuevosJugadores;

import java.util.List;
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
  
  private String _nombre;
  
  public String getNombre() {
    return this._nombre;
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
  }
  
  private List<String> _mailsAmigos;
  
  public List<String> getMailsAmigos() {
    return this._mailsAmigos;
  }
  
  public void setMailsAmigos(final List<String> mailsAmigos) {
    this._mailsAmigos = mailsAmigos;
  }
  
  public Propuesta(final String mailDado, final Jugador amigoQueRecomendo, final String nom, final List<String> mails) {
    this.setMail(mailDado);
    this.setAmigo(amigoQueRecomendo);
    this.setNombre(nom);
    this.setMailsAmigos(mails);
  }
}
