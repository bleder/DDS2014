package utn.edu.dds.TP_OPF5.test;

import partido.core.Jugador;
import partido.core.Partido;
import partido.core.tiposDeInscripcion.Estandar;
import partido.nuevosJugadores.Administrador;
import partido.ordenamiento.Handicap;
import partido.ordenamiento.MixOrdenamiento;
import partido.ordenamiento.Ordenamiento;
import partido.ordenamiento.PromedioCalificaciones;
import partido.ordenamiento.PromedioNCalificaciones;

@SuppressWarnings("all")
public class TstOrdenamiento {
  private Jugador jugador1;
  
  private Jugador jugador2;
  
  private Jugador jugador3;
  
  private Jugador jugador4;
  
  private Handicap handicap;
  
  private PromedioCalificaciones promcalif;
  
  private PromedioNCalificaciones promNCalif;
  
  private MixOrdenamiento mixOrdenamiento;
  
  private Partido partido;
  
  private Partido partido2;
  
  private Estandar tipoIncEstandar;
  
  private /* List<Jugador> */Object jugadores /* Skipped initializer because of errors */;
  
  private /* List<Ordenamiento> */Object criterios /* Skipped initializer because of errors */;
  
  /* @Before
   */public void init() {
    Administrador _administrador = new Administrador("admin@aol.com");
    Partido _partido = new Partido("Partido_1", _administrador);
    this.partido = _partido;
    Administrador _administrador_1 = new Administrador("admin2@aol.com");
    Partido _partido_1 = new Partido("Partido_2", _administrador_1);
    this.partido2 = _partido_1;
    Estandar _estandar = new Estandar();
    this.tipoIncEstandar = _estandar;
    this.initJugadores();
    this.initCalificacion();
    this.initCriterios();
  }
  
  public Object initCriterios() {
    Object _xblockexpression = null;
    {
      Handicap _handicap = new Handicap(this.partido);
      this.handicap = _handicap;
      PromedioCalificaciones _promedioCalificaciones = new PromedioCalificaciones(this.partido);
      this.promcalif = _promedioCalificaciones;
      PromedioNCalificaciones _promedioNCalificaciones = new PromedioNCalificaciones(this.partido, 3);
      this.promNCalif = _promedioNCalificaciones;
      MixOrdenamiento _mixOrdenamiento = new MixOrdenamiento(this.partido);
      this.mixOrdenamiento = _mixOrdenamiento;
      this.mixOrdenamiento.agregarCriterioHandicap();
      this.mixOrdenamiento.agregarCriterioPromedioUltimoPartido();
      _xblockexpression = this.mixOrdenamiento.agregarCriterioNCalificaciones(int.valueOf(3));
    }
    return _xblockexpression;
  }
  
  public int initJugadores() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field nivelJuego is not visible"
      + "\nThe field nivelJuego is not visible"
      + "\nThe field nivelJuego is not visible"
      + "\nThe field nivelJuego is not visible");
  }
  
  public Object initCalificacion() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field partidosJugados is not visible"
      + "\nThe field partidosJugados is not visible"
      + "\nThe field partidosJugados is not visible"
      + "\nThe field partidosJugados is not visible"
      + "\nThe field partidosJugados is not visible"
      + "\nThe field partidosJugados is not visible"
      + "\nThe field partidosJugados is not visible"
      + "\nThe field partidosJugados is not visible"
      + "\nadd cannot be resolved"
      + "\nadd cannot be resolved"
      + "\nadd cannot be resolved"
      + "\nadd cannot be resolved"
      + "\nadd cannot be resolved"
      + "\nadd cannot be resolved"
      + "\nadd cannot be resolved"
      + "\nadd cannot be resolved");
  }
  
  /* @Test
   */public void SePuedeOrdenarJugadoresDePartidoPorHandiCap() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Assert is undefined for the type TstOrdenamiento"
      + "\nThe field jugadoresInscriptos is not visible"
      + "\nassertArrayEquals cannot be resolved"
      + "\nmap cannot be resolved"
      + "\njugador cannot be resolved");
  }
  
  /* @Test
   */public void SePuedeOrdenarJugadoresDePartidoPorPromedioDeTodasLasCalificaciones() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Assert is undefined for the type TstOrdenamiento"
      + "\nThe field jugadoresInscriptos is not visible"
      + "\nassertArrayEquals cannot be resolved"
      + "\nmap cannot be resolved"
      + "\njugador cannot be resolved");
  }
  
  /* @Test
   */public void sePuedeOrdenarJugadoresDePartidoPorPromedioDe3Calificaciones() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Assert is undefined for the type TstOrdenamiento"
      + "\nThe field jugadoresInscriptos is not visible"
      + "\nassertArrayEquals cannot be resolved"
      + "\nmap cannot be resolved"
      + "\njugador cannot be resolved");
  }
  
  /* @Test
   */public void sePuedeOrdenarJugadoresDePartidoPorMixDeCriterios() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Assert is undefined for the type TstOrdenamiento"
      + "\nThe field jugadoresInscriptos is not visible"
      + "\nassertArrayEquals cannot be resolved"
      + "\nmap cannot be resolved"
      + "\njugador cannot be resolved");
  }
  
  /* @Test
   */public void seObtieneElPromedioDeTodasLasCalificacionesDeUnJugador() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Assert is undefined for the type TstOrdenamiento"
      + "\n/ cannot be resolved."
      + "\nassertEquals cannot be resolved");
  }
  
  /* @Test
   */public void seObtieneElPromedioDe3LasCalificacionesDeUnJugador() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Assert is undefined for the type TstOrdenamiento"
      + "\n/ cannot be resolved."
      + "\nassertEquals cannot be resolved");
  }
  
  public Object jugadoresEnOrdenPorHandicap() {
    throw new Error("Unresolved compilation problems:"
      + "\nadd cannot be resolved"
      + "\nadd cannot be resolved"
      + "\nadd cannot be resolved"
      + "\nadd cannot be resolved");
  }
  
  public Object jugadoresEnOrdenPorPromedioDeLasCalificacionesUltimoPartido() {
    throw new Error("Unresolved compilation problems:"
      + "\nadd cannot be resolved"
      + "\nadd cannot be resolved"
      + "\nadd cannot be resolved"
      + "\nadd cannot be resolved");
  }
  
  public Object jugadoresEnOrdenPorPromedioDeLas3Calificaciones() {
    throw new Error("Unresolved compilation problems:"
      + "\nadd cannot be resolved"
      + "\nadd cannot be resolved"
      + "\nadd cannot be resolved"
      + "\nadd cannot be resolved");
  }
  
  public Object jugadoresEnOrdenPorMixCriterios3() {
    throw new Error("Unresolved compilation problems:"
      + "\nadd cannot be resolved"
      + "\nadd cannot be resolved"
      + "\nadd cannot be resolved"
      + "\nadd cannot be resolved");
  }
}
