package utn.edu.dds.TP_OPF5.test;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import partido.core.Inscripcion;
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
  
  private List<Jugador> jugadores = new ArrayList<Jugador>();
  
  private List<Ordenamiento> criterios = new ArrayList<Ordenamiento>();
  
  @Before
  public void init() {
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
  
  public boolean initCriterios() {
    boolean _xblockexpression = false;
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
      _xblockexpression = this.mixOrdenamiento.agregarCriterioNCalificaciones(Integer.valueOf(3));
    }
    return _xblockexpression;
  }
  
  public int initJugadores() {
    int _xblockexpression = (int) 0;
    {
      Jugador _jugador = new Jugador("Rodolfo", "rodol@aol.com");
      this.jugador1 = _jugador;
      Jugador _jugador_1 = new Jugador("Pepe", "pepe@gmail.com");
      this.jugador2 = _jugador_1;
      Jugador _jugador_2 = new Jugador("Carlos", "carlos@gmail.com");
      this.jugador3 = _jugador_2;
      Jugador _jugador_3 = new Jugador("Lucas", "lucas@gmail.com");
      this.jugador4 = _jugador_3;
      this.jugador1.inscribite(this.partido, this.tipoIncEstandar);
      this.jugador1.inscribite(this.partido2, this.tipoIncEstandar);
      this.jugador2.inscribite(this.partido, this.tipoIncEstandar);
      this.jugador2.inscribite(this.partido2, this.tipoIncEstandar);
      this.jugador3.inscribite(this.partido, this.tipoIncEstandar);
      this.jugador3.inscribite(this.partido2, this.tipoIncEstandar);
      this.jugador4.inscribite(this.partido, this.tipoIncEstandar);
      this.jugador4.inscribite(this.partido2, this.tipoIncEstandar);
      this.jugador1.set_nivelJuego(5);
      this.jugador2.set_nivelJuego(2);
      this.jugador3.set_nivelJuego(8);
      _xblockexpression = this.jugador4.set_nivelJuego(1);
    }
    return _xblockexpression;
  }
  
  public boolean initCalificacion() {
    boolean _xblockexpression = false;
    {
      this.jugador2.calificarA(this.jugador1, this.partido, 9, null);
      this.jugador3.calificarA(this.jugador1, this.partido, 9, null);
      this.jugador4.calificarA(this.jugador1, this.partido, 5, null);
      this.jugador4.calificarA(this.jugador1, this.partido2, 10, null);
      List<Partido> _partidosJugados = this.jugador1.getPartidosJugados();
      _partidosJugados.add(this.partido2);
      List<Partido> _partidosJugados_1 = this.jugador1.getPartidosJugados();
      _partidosJugados_1.add(this.partido);
      this.jugador1.calificarA(this.jugador2, this.partido, 2, null);
      this.jugador3.calificarA(this.jugador2, this.partido, 4, null);
      this.jugador4.calificarA(this.jugador2, this.partido, 7, null);
      this.jugador4.calificarA(this.jugador2, this.partido2, 1, null);
      List<Partido> _partidosJugados_2 = this.jugador2.getPartidosJugados();
      _partidosJugados_2.add(this.partido2);
      List<Partido> _partidosJugados_3 = this.jugador2.getPartidosJugados();
      _partidosJugados_3.add(this.partido);
      this.jugador1.calificarA(this.jugador3, this.partido, 1, null);
      this.jugador2.calificarA(this.jugador3, this.partido, 1, null);
      this.jugador4.calificarA(this.jugador3, this.partido, 1, null);
      this.jugador4.calificarA(this.jugador3, this.partido2, 1, null);
      List<Partido> _partidosJugados_4 = this.jugador3.getPartidosJugados();
      _partidosJugados_4.add(this.partido2);
      List<Partido> _partidosJugados_5 = this.jugador3.getPartidosJugados();
      _partidosJugados_5.add(this.partido);
      this.jugador1.calificarA(this.jugador4, this.partido, 5, null);
      this.jugador2.calificarA(this.jugador4, this.partido, 8, null);
      this.jugador3.calificarA(this.jugador4, this.partido, 1, null);
      this.jugador3.calificarA(this.jugador4, this.partido2, 9, null);
      List<Partido> _partidosJugados_6 = this.jugador4.getPartidosJugados();
      _partidosJugados_6.add(this.partido2);
      List<Partido> _partidosJugados_7 = this.jugador4.getPartidosJugados();
      _xblockexpression = _partidosJugados_7.add(this.partido);
    }
    return _xblockexpression;
  }
  
  @Test
  public void SePuedeOrdenarJugadoresDePartidoPorHandiCap() {
    this.jugadoresEnOrdenPorHandicap();
    this.partido.partidoOrdenaJugadores(this.handicap);
    List<Inscripcion> _jugadoresInscriptos = this.partido.getJugadoresInscriptos();
    final Function1<Inscripcion,Jugador> _function = new Function1<Inscripcion,Jugador>() {
      public Jugador apply(final Inscripcion inscripcion) {
        return inscripcion.getJugador();
      }
    };
    List<Jugador> _map = ListExtensions.<Inscripcion, Jugador>map(_jugadoresInscriptos, _function);
    Assert.assertArrayEquals(((Object[])Conversions.unwrapArray(_map, Object.class)), ((Object[])Conversions.unwrapArray(this.jugadores, Object.class)));
  }
  
  @Test
  public void SePuedeOrdenarJugadoresDePartidoPorPromedioDeTodasLasCalificaciones() {
    this.jugadoresEnOrdenPorPromedioDeLasCalificacionesUltimoPartido();
    this.partido.partidoOrdenaJugadores(this.promcalif);
    List<Inscripcion> _jugadoresInscriptos = this.partido.getJugadoresInscriptos();
    final Function1<Inscripcion,Jugador> _function = new Function1<Inscripcion,Jugador>() {
      public Jugador apply(final Inscripcion inscripcion) {
        return inscripcion.getJugador();
      }
    };
    List<Jugador> _map = ListExtensions.<Inscripcion, Jugador>map(_jugadoresInscriptos, _function);
    Assert.assertArrayEquals(((Object[])Conversions.unwrapArray(_map, Object.class)), ((Object[])Conversions.unwrapArray(this.jugadores, Object.class)));
  }
  
  @Test
  public void sePuedeOrdenarJugadoresDePartidoPorPromedioDe3Calificaciones() {
    this.jugadoresEnOrdenPorPromedioDeLas3Calificaciones();
    this.partido.partidoOrdenaJugadores(this.promNCalif);
    List<Inscripcion> _jugadoresInscriptos = this.partido.getJugadoresInscriptos();
    final Function1<Inscripcion,Jugador> _function = new Function1<Inscripcion,Jugador>() {
      public Jugador apply(final Inscripcion inscripcion) {
        return inscripcion.getJugador();
      }
    };
    List<Jugador> _map = ListExtensions.<Inscripcion, Jugador>map(_jugadoresInscriptos, _function);
    Assert.assertArrayEquals(((Object[])Conversions.unwrapArray(_map, Object.class)), ((Object[])Conversions.unwrapArray(this.jugadores, Object.class)));
  }
  
  @Test
  public void sePuedeOrdenarJugadoresDePartidoPorMixDeCriterios() {
    this.jugadoresEnOrdenPorMixCriterios3();
    this.partido.partidoOrdenaJugadores(this.mixOrdenamiento);
    List<Inscripcion> _jugadoresInscriptos = this.partido.getJugadoresInscriptos();
    final Function1<Inscripcion,Jugador> _function = new Function1<Inscripcion,Jugador>() {
      public Jugador apply(final Inscripcion inscripcion) {
        return inscripcion.getJugador();
      }
    };
    List<Jugador> _map = ListExtensions.<Inscripcion, Jugador>map(_jugadoresInscriptos, _function);
    Assert.assertArrayEquals(((Object[])Conversions.unwrapArray(_map, Object.class)), ((Object[])Conversions.unwrapArray(this.jugadores, Object.class)));
  }
  
  @Test
  public void seObtieneElPromedioDeTodasLasCalificacionesDeUnJugador() {
    int _promedioDeCalificacionesUltimoPartido = this.jugador1.promedioDeCalificacionesUltimoPartido();
    Assert.assertEquals(_promedioDeCalificacionesUltimoPartido, (23 / 3));
  }
  
  @Test
  public void seObtieneElPromedioDe3LasCalificacionesDeUnJugador() {
    int _promedioDeCalificaciones = this.jugador1.promedioDeCalificaciones(3);
    Assert.assertEquals(_promedioDeCalificaciones, (23 / 3));
  }
  
  public boolean jugadoresEnOrdenPorHandicap() {
    boolean _xblockexpression = false;
    {
      this.jugadores.add(this.jugador4);
      this.jugadores.add(this.jugador2);
      this.jugadores.add(this.jugador1);
      _xblockexpression = this.jugadores.add(this.jugador3);
    }
    return _xblockexpression;
  }
  
  public boolean jugadoresEnOrdenPorPromedioDeLasCalificacionesUltimoPartido() {
    boolean _xblockexpression = false;
    {
      this.jugadores.add(this.jugador3);
      this.jugadores.add(this.jugador2);
      this.jugadores.add(this.jugador4);
      _xblockexpression = this.jugadores.add(this.jugador1);
    }
    return _xblockexpression;
  }
  
  public boolean jugadoresEnOrdenPorPromedioDeLas3Calificaciones() {
    boolean _xblockexpression = false;
    {
      this.jugadores.add(this.jugador3);
      this.jugadores.add(this.jugador2);
      this.jugadores.add(this.jugador4);
      _xblockexpression = this.jugadores.add(this.jugador1);
    }
    return _xblockexpression;
  }
  
  public boolean jugadoresEnOrdenPorMixCriterios3() {
    boolean _xblockexpression = false;
    {
      this.jugadores.add(this.jugador2);
      this.jugadores.add(this.jugador3);
      this.jugadores.add(this.jugador4);
      _xblockexpression = this.jugadores.add(this.jugador1);
    }
    return _xblockexpression;
  }
}
