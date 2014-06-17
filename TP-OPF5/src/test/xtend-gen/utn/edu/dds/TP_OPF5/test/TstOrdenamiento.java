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
import partido.ordenamiento.PromedioCalificaciones;

@SuppressWarnings("all")
public class TstOrdenamiento {
  private Jugador jugador1;
  
  private Jugador jugador2;
  
  private Jugador jugador3;
  
  private Jugador jugador4;
  
  private Handicap handicap;
  
  private PromedioCalificaciones promcalif;
  
  private Partido partido;
  
  private Partido partido2;
  
  private Estandar tipoIncEstandar;
  
  private List<Jugador> jugadores = new ArrayList<Jugador>();
  
  private Inscripcion i;
  
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
    Handicap _handicap = new Handicap(this.partido);
    this.handicap = _handicap;
    PromedioCalificaciones _promedioCalificaciones = new PromedioCalificaciones(this.partido);
    this.promcalif = _promedioCalificaciones;
  }
  
  public void initJugadores() {
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
    this.jugador1.setNivelJuego(5);
    this.jugador2.setNivelJuego(2);
    this.jugador3.setNivelJuego(8);
    this.jugador4.setNivelJuego(1);
  }
  
  public boolean initCalificacion() {
    boolean _xblockexpression = false;
    {
      this.jugador2.calificarA(this.jugador1, this.partido, 9, null);
      this.jugador3.calificarA(this.jugador1, this.partido, 9, null);
      this.jugador4.calificarA(this.jugador1, this.partido, 5, null);
      this.jugador4.calificarA(this.jugador1, this.partido2, 10, null);
      this.jugador1.calificarA(this.jugador2, this.partido, 2, null);
      this.jugador3.calificarA(this.jugador2, this.partido, 4, null);
      this.jugador4.calificarA(this.jugador2, this.partido, 7, null);
      this.jugador4.calificarA(this.jugador2, this.partido2, 1, null);
      this.jugador1.calificarA(this.jugador3, this.partido, 1, null);
      this.jugador2.calificarA(this.jugador3, this.partido, 1, null);
      this.jugador4.calificarA(this.jugador3, this.partido, 1, null);
      this.jugador4.calificarA(this.jugador3, this.partido2, 1, null);
      this.jugador1.calificarA(this.jugador4, this.partido, 5, null);
      this.jugador2.calificarA(this.jugador4, this.partido, 8, null);
      this.jugador3.calificarA(this.jugador4, this.partido, 1, null);
      _xblockexpression = this.jugador3.calificarA(this.jugador4, this.partido2, 9, null);
    }
    return _xblockexpression;
  }
  
  @Test
  public void SePuedeOrdenarJugadoresDePartidoPorHandiCap() {
    this.jugadoresEnOrdenPorHandicap();
    this.partido.setOrdenamiento(this.handicap);
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
    this.jugadoresEnOrdenPorPromedioDeTodasLasCalificaciones();
    this.partido.setOrdenamiento(this.promcalif);
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
  public void sePuedeOrdenarJugadoresDePartidoPorPromedioDe3Calificaciones() {
  }
  
  @Test
  public void sePuedeOrdenarJugadoresDePartidoPorMixDeCriterios() {
  }
  
  @Test
  public void seObtieneElPromedioDeTodasLasCalificacionesDeUnJugador() {
    List<Partido> _partidosJugados = this.jugador1.getPartidosJugados();
    _partidosJugados.add(this.partido);
    List<Partido> _partidosJugados_1 = this.jugador1.getPartidosJugados();
    _partidosJugados_1.add(this.partido2);
    Integer _promedioDeCalificacionesUltimoPartido = this.jugador1.promedioDeCalificacionesUltimoPartido();
    Assert.assertEquals((_promedioDeCalificacionesUltimoPartido).intValue(), 5);
  }
  
  @Test
  public void seObtieneElPromedioDe3LasCalificacionesDeUnJugador() {
    Integer _promedioDeCalificaciones = this.jugador1.promedioDeCalificaciones(3);
    Assert.assertEquals((_promedioDeCalificaciones).intValue(), ((9 + 9) + 5));
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
  
  public boolean jugadoresEnOrdenPorPromedioDeTodasLasCalificaciones() {
    boolean _xblockexpression = false;
    {
      this.jugadores.add(this.jugador3);
      this.jugadores.add(this.jugador2);
      this.jugadores.add(this.jugador4);
      _xblockexpression = this.jugadores.add(this.jugador1);
    }
    return _xblockexpression;
  }
}
