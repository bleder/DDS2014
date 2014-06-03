package partido.nuevosJugadores;

import partido.nuevosJugadores.Propuesta;

@SuppressWarnings("all")
public class Rechazo {
  private String _mail;
  
  public String getMail() {
    return this._mail;
  }
  
  public void setMail(final String mail) {
    this._mail = mail;
  }
  
  private String _razon;
  
  public String getRazon() {
    return this._razon;
  }
  
  public void setRazon(final String razon) {
    this._razon = razon;
  }
  
  private Propuesta _propuesta;
  
  public Propuesta getPropuesta() {
    return this._propuesta;
  }
  
  public void setPropuesta(final Propuesta propuesta) {
    this._propuesta = propuesta;
  }
  
  public Rechazo(final String elMail, final String laRazon, final Propuesta propuestaRechazada) {
    this.setMail(elMail);
    this.setRazon(laRazon);
    this.setPropuesta(propuestaRechazada);
  }
}
