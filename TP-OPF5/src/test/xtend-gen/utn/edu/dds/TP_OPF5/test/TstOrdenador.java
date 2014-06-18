package utn.edu.dds.TP_OPF5.test;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import partido.core.Jugador;
import partido.core.Partido;
import partido.core.tiposDeInscripcion.Estandar;
import partido.core.tiposDeInscripcion.TipoInscripcion;
import partido.generacionEquipos.Ordenador;
import partido.nuevosJugadores.Administrador;

@SuppressWarnings("all")
public class TstOrdenador {
  private Ordenador ordenador;
  
  private Partido partido;
  
  private Jugador jugador1;
  
  private Jugador jugador2;
  
  private List<Jugador> jugadores;
  
  private TipoInscripcion inscripcion;
  
  @Before
  public void init() {
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    this.jugadores = _arrayList;
    Ordenador _ordenador = new Ordenador();
    this.ordenador = _ordenador;
    Jugador _jugador = new Jugador("", "");
    this.jugador1 = _jugador;
    Jugador _jugador_1 = new Jugador("", "");
    this.jugador2 = _jugador_1;
    Administrador _administrador = new Administrador("");
    Partido _partido = new Partido("", _administrador);
    this.partido = _partido;
    Estandar _estandar = new Estandar();
    this.inscripcion = _estandar;
    this.jugador1.setHandicap(7);
    this.jugador2.setHandicap(3);
    this.jugador1.jugarPartido(this.partido);
    this.jugador2.jugarPartido(this.partido);
    this.jugadores.add(this.jugador2);
    this.jugadores.add(this.jugador1);
    this.jugador1.inscribite(this.partido, this.inscripcion);
    this.jugador2.inscribite(this.partido, this.inscripcion);
    this.jugador2.calificarA(this.jugador1, this.partido, 7, "");
    this.jugador1.calificarA(this.jugador2, this.partido, 3, "");
  }
  
  @Test
  public void seOrdenaBienPorHandicap() {
    this.ordenador.agregarCriterioHandicap();
    final List<Jugador> listaOrdenada = this.ordenador.buildListaOrdenada(this.jugadores);
    Jugador _get = listaOrdenada.get(0);
    Assert.assertEquals(_get, this.jugador1);
    Jugador _get_1 = listaOrdenada.get(1);
    Assert.assertEquals(_get_1, this.jugador2);
  }
  
  @Test
  public void seOrdenaBienPorUltimoPartido() {
    this.ordenador.agregarCriterioPromedioUltimoPartido();
    final List<Jugador> listaOrdenada = this.ordenador.buildListaOrdenada(this.jugadores);
    Jugador _get = listaOrdenada.get(0);
    Assert.assertEquals(_get, this.jugador1);
    Jugador _get_1 = listaOrdenada.get(1);
    Assert.assertEquals(_get_1, this.jugador2);
  }
  
  @Test
  public void seOrdenaBienPorMix() {
    this.ordenador.agregarCriterioPromedioUltimoPartido();
    this.ordenador.agregarCriterioHandicap();
    final List<Jugador> listaOrdenada = this.ordenador.buildListaOrdenada(this.jugadores);
    Jugador _get = listaOrdenada.get(0);
    Assert.assertEquals(_get, this.jugador1);
    Jugador _get_1 = listaOrdenada.get(1);
    Assert.assertEquals(_get_1, this.jugador2);
  }
  
  @Test
  public void seOrdenaBienPorUltimasCalificaciones() {
    this.ordenador.agregarCriterioUltimasCalificaciones(Integer.valueOf(1));
    final List<Jugador> listaOrdenada = this.ordenador.buildListaOrdenada(this.jugadores);
    Jugador _get = listaOrdenada.get(0);
    Assert.assertEquals(_get, this.jugador1);
    Jugador _get_1 = listaOrdenada.get(1);
    Assert.assertEquals(_get_1, this.jugador2);
  }
}
