package partido.nuevosJugadores;

import java.util.List;
import partido.core.Jugador;

@SuppressWarnings("all")
public class Propuesta {
  /**
   * @Property
   */
  private int id_propuesta;
  
  /**
   * @Property
   */
  private String mail;
  
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
  
  public Propuesta() {
  }
  
  public Propuesta(final String mailDado, final Jugador amigoQueRecomendo, final String nom, final List<String> mails) {
    this.mail = mailDado;
    this.setAmigo(amigoQueRecomendo);
    this.setNombre(nom);
    this.setMailsAmigos(mails);
  }
  
  public int setId_Propuesta(final int id_propuesta) {
    return this.id_propuesta = id_propuesta;
  }
  
  public int getId_Propuesta() {
    return this.id_propuesta;
  }
  
  public String setMail(final String mail) {
    return this.mail = mail;
  }
  
  public String getMail() {
    return this.mail;
  }
}
