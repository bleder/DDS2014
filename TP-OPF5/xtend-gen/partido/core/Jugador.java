package partido.core;

import partido.calificaciones.Calificacion;
import partido.calificaciones.ClasificacionBuilder;
import partido.core.Infraccion;
import partido.core.Partido;
import partido.core.tiposDeInscripcion.TipoInscripcion;
import partido.nuevosJugadores.Administrador;
import partido.nuevosJugadores.Propuesta;
import partido.nuevosJugadores.PropuestaBuilder;

@SuppressWarnings("all")
public class Jugador /* implements Entity  */{
  /* @Property
   */private /* String */Object nombre;
  
  /* @Property
   */private /* String */Object mail;
  
  /* @Property
   */private /* List<Infraccion> */Object infracciones;
  
  /* @Property
   */private /* List<String> */Object amigos;
  
  /* @Property
   */private /* List<Calificacion> */Object calificaciones /* Skipped initializer because of errors */;
  
  /* @Property
   */private int nivelJuego;
  
  /* @Property
   */private /* List<Partido> */Object partidosJugados /* Skipped initializer because of errors */;
  
  public Jugador(final /* String */Object nom, final /* String */Object newMail) {
    throw new Error("Unresolved compilation problems:"
      + "\nArrayList cannot be resolved."
      + "\nArrayList cannot be resolved.");
  }
  
  public void inscribite(final Partido partido, final TipoInscripcion tipoInscripcion) {
    tipoInscripcion.inscribirA(this, partido);
  }
  
  public Object confirmarse(final Partido partido) {
    return partido.confirmarJugador(this);
  }
  
  public Object nuevaInfraccion(final Infraccion infraccion) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getInfracciones is undefined for the type Jugador"
      + "\nadd cannot be resolved");
  }
  
  public Object agregarAmigo(final /* String */Object mailAmigo) {
    throw new Error("Unresolved compilation problems:"
      + "\nadd cannot be resolved");
  }
  
  public Object calificarA(final Jugador jugador, final Partido partido, final int nota, final /* String */Object critica) {
    Object _xblockexpression = null;
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
  
  public Object agregateCalificacion(final Calificacion calificacion) {
    throw new Error("Unresolved compilation problems:"
      + "\nadd cannot be resolved");
  }
  
  public Object crearPropuesta(final /* String */Object amigo, final Administrador admin, final /* String */Object nombre, final /* List<String> */Object mailsDeAmigos) {
    Object _xblockexpression = null;
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
  
  public Object existeAmigo(final /* String */Object mail) {
    throw new Error("Unresolved compilation problems:"
      + "\nexists cannot be resolved"
      + "\n== cannot be resolved");
  }
  
  public Object promedioDeCalificacionesUltimoPartido() {
    throw new Error("Unresolved compilation problems:"
      + "\nreduce cannot be resolved"
      + "\n+ cannot be resolved"
      + "\nsize cannot be resolved"
      + "\n/ cannot be resolved"
      + "\nintValue cannot be resolved");
  }
  
  public /* Iterable<Integer> */Object notasUltimoPartido() {
    throw new Error("Unresolved compilation problems:"
      + "\nfilter cannot be resolved"
      + "\npartido cannot be resolved"
      + "\n== cannot be resolved"
      + "\nmap cannot be resolved"
      + "\nnota cannot be resolved");
  }
  
  public Partido ultimoPartido() {
    throw new Error("Unresolved compilation problems:"
      + "\nlast cannot be resolved");
  }
  
  public Object promedioDeCalificaciones(final int n) {
    throw new Error("Unresolved compilation problems:"
      + "\ntake cannot be resolved"
      + "\nmap cannot be resolved"
      + "\nnota cannot be resolved"
      + "\nreduce cannot be resolved"
      + "\n+ cannot be resolved"
      + "\ntake cannot be resolved"
      + "\nsize cannot be resolved"
      + "\n/ cannot be resolved"
      + "\nintValue cannot be resolved");
  }
  
  public int tuNivelDeJuegoEs(final int nv) {
    return this.nivelJuego = nv;
  }
  
  public Object cantidadPartidosJugados() {
    throw new Error("Unresolved compilation problems:"
      + "\nlength cannot be resolved");
  }
}
