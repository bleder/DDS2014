package utn.edu.dds.TP_OPF5;

import java.util.ArrayList;
import java.util.List;
import utn.edu.dds.TP_OPF5.Infraccion;
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
  
  private List<Infraccion> _infraccionesJugador;
  
  public List<Infraccion> getInfraccionesJugador() {
    return this._infraccionesJugador;
  }
  
  public void setInfraccionesJugador(final List<Infraccion> infraccionesJugador) {
    this._infraccionesJugador = infraccionesJugador;
  }
  
  private List<Jugador> _amigosJugador;
  
  public List<Jugador> getAmigosJugador() {
    return this._amigosJugador;
  }
  
  public void setAmigosJugador(final List<Jugador> amigosJugador) {
    this._amigosJugador = amigosJugador;
  }
  
  public Jugador(final String nom) {
    this.setNombre(nom);
    ArrayList<Infraccion> _arrayList = new ArrayList<Infraccion>();
    this.setInfraccionesJugador(_arrayList);
    ArrayList<Jugador> _arrayList_1 = new ArrayList<Jugador>();
    this.setAmigosJugador(_arrayList_1);
  }
  
  public void inscribite(final Partido partido, final TipoInscripcion tipoInscripcion) {
    tipoInscripcion.inscribirA(this, partido);
  }
  
  public void confirmarse(final Partido partido) {
    partido.confirmarJugador(this);
  }
}
