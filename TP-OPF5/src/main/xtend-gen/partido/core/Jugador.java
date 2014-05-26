package partido.core;

import java.util.ArrayList;
import java.util.List;
import partido.core.Infraccion;
import utn.edu.dds.TP_OPF5.Partido;
import utn.edu.dds.TP_OPF5.TipoInscripcion;

@SuppressWarnings("all")
public class Jugador {
  private String _nombre;
  
  public String getNombre() {
    return this._nombre;
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
  }
  
  private String _mail;
  
  public String getMail() {
    return this._mail;
  }
  
  public void setMail(final String mail) {
    this._mail = mail;
  }
  
  private List<Infraccion> _infracciones;
  
  public List<Infraccion> getInfracciones() {
    return this._infracciones;
  }
  
  public void setInfracciones(final List<Infraccion> infracciones) {
    this._infracciones = infracciones;
  }
  
  private List<Jugador> _amigos;
  
  public List<Jugador> getAmigos() {
    return this._amigos;
  }
  
  public void setAmigos(final List<Jugador> amigos) {
    this._amigos = amigos;
  }
  
  public Jugador(final String nom) {
    this.setNombre(nom);
    ArrayList<Infraccion> _arrayList = new ArrayList<Infraccion>();
    this.setInfracciones(_arrayList);
  }
  
  public void inscribite(final Partido partido, final TipoInscripcion tipoInscripcion) {
    final Jugador _converted_this = (Jugador)this;
    tipoInscripcion.inscribirA(_converted_this, partido);
  }
  
  public void confirmarse(final Partido partido) {
    final Jugador _converted_this = (Jugador)this;
    partido.confirmarJugador(_converted_this);
  }
  
  public boolean nuevaInfraccion(final Infraccion infraccion) {
    List<Infraccion> _infracciones = this.getInfracciones();
    return _infracciones.add(infraccion);
  }
}
