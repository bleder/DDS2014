package partido.nuevosJugadores;

import exception.NoExisteMailException;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;
import partido.core.Jugador;
import partido.nuevosJugadores.Propuesta;

@SuppressWarnings("all")
public class PropuestaBuilder {
  private String _mailPropuesto;
  
  public String getMailPropuesto() {
    return this._mailPropuesto;
  }
  
  public void setMailPropuesto(final String mailPropuesto) {
    this._mailPropuesto = mailPropuesto;
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
  
  public void conAmigoDelPropuesto(final Jugador amigoQuePropuso) {
    this.setAmigo(amigoQuePropuso);
  }
  
  public void conMail(final String mail) {
    this.setMailPropuesto(mail);
  }
  
  public void conAmigos(final List<String> mailsAmigos) {
    this.setMailsAmigos(mailsAmigos);
  }
  
  public void conNombre(final String nombre) {
    this.setNombre(nombre);
  }
  
  public Propuesta build() {
    try {
      Jugador _amigo = this.getAmigo();
      String _mailPropuesto = this.getMailPropuesto();
      boolean _existeAmigo = _amigo.existeAmigo(_mailPropuesto);
      boolean _not = (!_existeAmigo);
      if (_not) {
        throw new NoExisteMailException("El jugador no tiene a ese amigo");
      }
      String _mailPropuesto_1 = this.getMailPropuesto();
      Jugador _amigo_1 = this.getAmigo();
      String _nombre = this.getNombre();
      List<String> _mailsAmigos = this.getMailsAmigos();
      Propuesta propuesta = new Propuesta(_mailPropuesto_1, _amigo_1, _nombre, _mailsAmigos);
      return propuesta;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
