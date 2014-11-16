package partido.nuevosJugadores;

import exception.NoExisteTalJugadorException;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;
import partido.core.Jugador;
import partido.nuevosJugadores.Administrador;
import partido.nuevosJugadores.Propuesta;

@SuppressWarnings("all")
public class jugadorBuilder {
  private Propuesta _propuesta;
  
  public Propuesta getPropuesta() {
    return this._propuesta;
  }
  
  public void setPropuesta(final Propuesta propuesta) {
    this._propuesta = propuesta;
  }
  
  private Administrador _administrador;
  
  public Administrador getAdministrador() {
    return this._administrador;
  }
  
  public void setAdministrador(final Administrador administrador) {
    this._administrador = administrador;
  }
  
  public void suAdministrador(final Administrador administrador) {
    this.setAdministrador(administrador);
  }
  
  public void conPropuesta(final Propuesta propuesta) {
    this.setPropuesta(propuesta);
  }
  
  public void build() {
    try {
      Administrador _administrador = this.getAdministrador();
      Propuesta _propuesta = this.getPropuesta();
      boolean _existePropuesta = _administrador.existePropuesta(_propuesta);
      boolean _not = (!_existePropuesta);
      if (_not) {
        throw new NoExisteTalJugadorException("No existe propuesta para ese jugador");
      }
      Propuesta _propuesta_1 = this.getPropuesta();
      String _nombre = _propuesta_1.getNombre();
      Propuesta _propuesta_2 = this.getPropuesta();
      String _mail = _propuesta_2.getMail();
      Jugador jugador = new Jugador(_nombre, _mail);
      Propuesta _propuesta_3 = this.getPropuesta();
      Jugador _amigo = _propuesta_3.getAmigo();
      String __mail = _amigo.get_mail();
      jugador.agregarAmigo(__mail);
      Propuesta _propuesta_4 = this.getPropuesta();
      List<String> _mailsAmigos = _propuesta_4.getMailsAmigos();
      jugador.setAmigos(_mailsAmigos);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
