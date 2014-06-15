package partido.core;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import partido.calificaciones.Calificacion;
import partido.calificaciones.ClasificacionBuilder;
import partido.core.Infraccion;
import partido.core.Partido;
import partido.core.tiposDeInscripcion.TipoInscripcion;
import partido.nuevosJugadores.Administrador;
import partido.nuevosJugadores.Propuesta;
import partido.nuevosJugadores.PropuestaBuilder;

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
  
  private List<String> _amigos;
  
  public List<String> getAmigos() {
    return this._amigos;
  }
  
  public void setAmigos(final List<String> amigos) {
    this._amigos = amigos;
  }
  
  private List<Calificacion> _calificaciones = new ArrayList<Calificacion>();
  
  public List<Calificacion> getCalificaciones() {
    return this._calificaciones;
  }
  
  public void setCalificaciones(final List<Calificacion> calificaciones) {
    this._calificaciones = calificaciones;
  }
  
  public Jugador(final String nom, final String newMail) {
    this.setMail(newMail);
    this.setNombre(nom);
    ArrayList<Infraccion> _arrayList = new ArrayList<Infraccion>();
    this.setInfracciones(_arrayList);
    ArrayList<String> _arrayList_1 = new ArrayList<String>();
    this.setAmigos(_arrayList_1);
  }
  
  public void inscribite(final Partido partido, final TipoInscripcion tipoInscripcion) {
    tipoInscripcion.inscribirA(this, partido);
  }
  
  public void confirmarse(final Partido partido) {
    partido.confirmarJugador(this);
  }
  
  public boolean nuevaInfraccion(final Infraccion infraccion) {
    List<Infraccion> _infracciones = this.getInfracciones();
    return _infracciones.add(infraccion);
  }
  
  public boolean agregarAmigo(final String mailAmigo) {
    List<String> _amigos = this.getAmigos();
    return _amigos.add(mailAmigo);
  }
  
  public boolean calificarA(final Jugador jugador, final Partido partido, final int nota, final String critica) {
    boolean _xblockexpression = false;
    {
      ClasificacionBuilder calificacion = new ClasificacionBuilder();
      calificacion.conPartido(partido);
      calificacion.conNota(nota);
      calificacion.conCritica(critica);
      calificacion.conCalificador(this);
      calificacion.conCalificado(jugador);
      Calificacion _build = calificacion.build();
      _xblockexpression = jugador.agregateCalificacion(_build);
    }
    return _xblockexpression;
  }
  
  public boolean agregateCalificacion(final Calificacion calificacion) {
    List<Calificacion> _calificaciones = this.getCalificaciones();
    return _calificaciones.add(calificacion);
  }
  
  public boolean crearPropuesta(final String amigo, final Administrador admin, final String nombre, final List<String> mailsDeAmigos) {
    boolean _xblockexpression = false;
    {
      PropuestaBuilder propuesta = new PropuestaBuilder();
      propuesta.conMail(amigo);
      propuesta.conAmigoDelPropuesto(this);
      propuesta.conAmigos(mailsDeAmigos);
      propuesta.conNombre(nombre);
      Propuesta _build = propuesta.build();
      _xblockexpression = admin.nuevaPropuesta(_build);
    }
    return _xblockexpression;
  }
  
  public boolean existeAmigo(final String mail) {
    List<String> _amigos = this.getAmigos();
    final Function1<String,Boolean> _function = new Function1<String,Boolean>() {
      public Boolean apply(final String amigo) {
        return Boolean.valueOf(Objects.equal(amigo, mail));
      }
    };
    return IterableExtensions.<String>exists(_amigos, _function);
  }
}
