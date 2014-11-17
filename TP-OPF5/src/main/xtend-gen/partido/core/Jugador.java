package partido.core;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.uqbar.commons.model.Entity;
import partido.calificaciones.Calificacion;
import partido.calificaciones.ClasificacionBuilder;
import partido.core.Infraccion;
import partido.core.Partido;
import partido.core.tiposDeInscripcion.TipoInscripcion;
import partido.nuevosJugadores.Administrador;
import partido.nuevosJugadores.Propuesta;
import partido.nuevosJugadores.PropuestaBuilder;

@SuppressWarnings("all")
public class Jugador extends Entity {
  /**
   * @Property
   */
  private int id_jugador;
  
  /**
   * @Property
   */
  private String nombre;
  
  /**
   * @Property
   */
  private String apodo;
  
  /**
   * @Property
   */
  private String fechaNac;
  
  /**
   * @Property
   */
  private String mail;
  
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
  
  /**
   * @Property
   */
  private int nivelJuego;
  
  private List<Partido> _partidosJugados = new ArrayList<Partido>();
  
  public List<Partido> getPartidosJugados() {
    return this._partidosJugados;
  }
  
  public void setPartidosJugados(final List<Partido> partidosJugados) {
    this._partidosJugados = partidosJugados;
  }
  
  private int cantidadDePartidos;
  
  private int promedioUltimoPartido;
  
  private int promedioTodosLosPartidos;
  
  public Jugador(final String nom, final String newMail) {
    this.mail = newMail;
    this.nombre = nom;
    int _length = this.nombre.length();
    int _divide = (_length / 2);
    String _substring = this.nombre.substring(0, _divide);
    this.apodo = _substring;
    this.fechaNac = "01/07/2013";
    ArrayList<Infraccion> _arrayList = new ArrayList<Infraccion>();
    this.setInfracciones(_arrayList);
    ArrayList<String> _arrayList_1 = new ArrayList<String>();
    this.setAmigos(_arrayList_1);
    this.nivelJuego = 0;
  }
  
  public int set_id_jugador(final int id_jugador) {
    return this.id_jugador = id_jugador;
  }
  
  public int get_id_jugador() {
    return this.id_jugador;
  }
  
  public String set_nombre(final String nombre) {
    return this.nombre = nombre;
  }
  
  public String get_nombre() {
    return this.nombre;
  }
  
  public String set_apodo(final String apodo) {
    return this.apodo = apodo;
  }
  
  public String get_apodo() {
    return this.apodo;
  }
  
  public String set_mail(final String mail) {
    return this.mail = mail;
  }
  
  public String get_mail() {
    return this.mail;
  }
  
  public int set_nivelJuego(final int nivelJuego) {
    return this.nivelJuego = nivelJuego;
  }
  
  public int get_nivelJuego() {
    return this.nivelJuego;
  }
  
  public String set_fechaNac(final String fecha) {
    return this.fechaNac = fecha;
  }
  
  public String get_fechaNac() {
    return this.fechaNac;
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
  
  public int promedioDeCalificacionesUltimoPartido() {
    int _xblockexpression = (int) 0;
    {
      Iterable<Integer> _notasUltimoPartido = this.notasUltimoPartido();
      final Function2<Integer,Integer,Integer> _function = new Function2<Integer,Integer,Integer>() {
        public Integer apply(final Integer n1, final Integer n2) {
          return Integer.valueOf(((n1).intValue() + (n2).intValue()));
        }
      };
      final Integer sum = IterableExtensions.<Integer>reduce(_notasUltimoPartido, _function);
      Iterable<Integer> _notasUltimoPartido_1 = this.notasUltimoPartido();
      final int cant = IterableExtensions.size(_notasUltimoPartido_1);
      if ((cant != 0)) {
        final int resultado = ((sum).intValue() / cant);
        return Integer.valueOf(resultado).intValue();
      }
      _xblockexpression = 0;
    }
    return _xblockexpression;
  }
  
  public Iterable<Integer> notasUltimoPartido() {
    List<Calificacion> _calificaciones = this.getCalificaciones();
    final Function1<Calificacion,Boolean> _function = new Function1<Calificacion,Boolean>() {
      public Boolean apply(final Calificacion calificacion) {
        Partido _partido = calificacion.getPartido();
        Partido _ultimoPartido = Jugador.this.ultimoPartido();
        return Boolean.valueOf(Objects.equal(_partido, _ultimoPartido));
      }
    };
    Iterable<Calificacion> _filter = IterableExtensions.<Calificacion>filter(_calificaciones, _function);
    final Function1<Calificacion,Integer> _function_1 = new Function1<Calificacion,Integer>() {
      public Integer apply(final Calificacion calificacion) {
        return Integer.valueOf(calificacion.getNota());
      }
    };
    return IterableExtensions.<Calificacion, Integer>map(_filter, _function_1);
  }
  
  public Partido ultimoPartido() {
    List<Partido> _partidosJugados = this.getPartidosJugados();
    return IterableExtensions.<Partido>last(_partidosJugados);
  }
  
  public int promedioDeCalificaciones(final int n) {
    int _xblockexpression = (int) 0;
    {
      List<Calificacion> _calificaciones = this.getCalificaciones();
      Iterable<Calificacion> _take = IterableExtensions.<Calificacion>take(_calificaciones, n);
      final Function1<Calificacion,Integer> _function = new Function1<Calificacion,Integer>() {
        public Integer apply(final Calificacion calificacion) {
          return Integer.valueOf(calificacion.getNota());
        }
      };
      Iterable<Integer> _map = IterableExtensions.<Calificacion, Integer>map(_take, _function);
      final Function2<Integer,Integer,Integer> _function_1 = new Function2<Integer,Integer,Integer>() {
        public Integer apply(final Integer n1, final Integer n2) {
          return Integer.valueOf(((n1).intValue() + (n2).intValue()));
        }
      };
      final Integer sum = IterableExtensions.<Integer>reduce(_map, _function_1);
      List<Calificacion> _calificaciones_1 = this.getCalificaciones();
      Iterable<Calificacion> _take_1 = IterableExtensions.<Calificacion>take(_calificaciones_1, n);
      final int cant = IterableExtensions.size(_take_1);
      if ((cant != 0)) {
        final int resultado = ((sum).intValue() / cant);
        Integer.valueOf(resultado).intValue();
      }
      _xblockexpression = 0;
    }
    return _xblockexpression;
  }
  
  public int tuNivelDeJuegoEs(final int nv) {
    return this.nivelJuego = nv;
  }
  
  public int cantidadPartidosJugados() {
    List<Partido> _partidosJugados = this.getPartidosJugados();
    return ((Object[])Conversions.unwrapArray(_partidosJugados, Object.class)).length;
  }
  
  public int getCantidadDePartidos() {
    return this.cantidadPartidosJugados();
  }
  
  public int getPromedioUltimoPartido() {
    return this.promedioDeCalificacionesUltimoPartido();
  }
  
  public int getPromedioTodosLosPartidos() {
    return this.promedioDeCalificaciones(this.cantidadDePartidos);
  }
}
