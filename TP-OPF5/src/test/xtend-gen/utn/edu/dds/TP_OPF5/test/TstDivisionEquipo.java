package utn.edu.dds.TP_OPF5.test;

import divisionEquipo.DivParImpar;
import divisionEquipo.DivPosiciones;
import exception.PartidoNoPoseeCantidadMaxima;
import exception.PartidoYaConfirmado;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import partido.core.Jugador;
import partido.core.Partido;
import partido.core.tiposDeInscripcion.Estandar;
import partido.nuevosJugadores.Administrador;

@SuppressWarnings("all")
public class TstDivisionEquipo {
  private Jugador jugador1;
  
  private Jugador jugador2;
  
  private Jugador jugador3;
  
  private Jugador jugador4;
  
  private Partido partido;
  
  private Estandar tipoIncEstandar;
  
  private List<Jugador> equipo1 = new ArrayList<Jugador>(2);
  
  private List<Jugador> equipo2 = new ArrayList<Jugador>(2);
  
  private DivParImpar divParImpar;
  
  private DivPosiciones divPosiciones;
  
  private List<Integer> posiciones = new ArrayList<Integer>();
  
  @Before
  public void init() {
    Administrador _administrador = new Administrador("admin@aol.com");
    Partido _partido = new Partido("Partido_1", _administrador);
    this.partido = _partido;
    this.partido.setMaximoLista(4);
    Estandar _estandar = new Estandar();
    this.tipoIncEstandar = _estandar;
    this.initJugadores();
    this.initDivision();
  }
  
  public DivPosiciones initDivision() {
    DivPosiciones _xblockexpression = null;
    {
      DivParImpar _divParImpar = new DivParImpar(this.partido);
      this.divParImpar = _divParImpar;
      this.posiciones.add(Integer.valueOf(0));
      this.posiciones.add(Integer.valueOf(3));
      DivPosiciones _divPosiciones = new DivPosiciones(this.partido, this.posiciones);
      _xblockexpression = this.divPosiciones = _divPosiciones;
    }
    return _xblockexpression;
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
    this.jugador2.inscribite(this.partido, this.tipoIncEstandar);
    this.jugador3.inscribite(this.partido, this.tipoIncEstandar);
    this.jugador4.inscribite(this.partido, this.tipoIncEstandar);
    this.partido.confirmarJugador(this.jugador1);
    this.partido.confirmarJugador(this.jugador2);
    this.partido.confirmarJugador(this.jugador3);
    this.partido.confirmarJugador(this.jugador4);
  }
  
  @Test
  public void dividirEquiposPorPosicionParImpar() {
    this.partido.setDivisorEquipo(this.divParImpar);
    this.equiposDivisionParImpar();
    this.partido.partidoDividiEquipos();
    List<Jugador> _equipo1 = this.partido.getEquipo1();
    Assert.assertArrayEquals(((Object[])Conversions.unwrapArray(_equipo1, Object.class)), ((Object[])Conversions.unwrapArray(this.equipo1, Object.class)));
    List<Jugador> _equipo2 = this.partido.getEquipo2();
    Assert.assertArrayEquals(((Object[])Conversions.unwrapArray(_equipo2, Object.class)), ((Object[])Conversions.unwrapArray(this.equipo2, Object.class)));
  }
  
  @Test
  public void dividirEquiposPorPosiciones1y3EnUnEquipo() {
    this.partido.setDivisorEquipo(this.divPosiciones);
    this.equiposDivisionPosiciones1y3();
    this.partido.partidoDividiEquipos();
    List<Jugador> _equipo1 = this.partido.getEquipo1();
    Assert.assertArrayEquals(((Object[])Conversions.unwrapArray(_equipo1, Object.class)), ((Object[])Conversions.unwrapArray(this.equipo1, Object.class)));
    List<Jugador> _equipo2 = this.partido.getEquipo2();
    Assert.assertArrayEquals(((Object[])Conversions.unwrapArray(_equipo2, Object.class)), ((Object[])Conversions.unwrapArray(this.equipo2, Object.class)));
  }
  
  @Test
  public void noSePuedeDividirEquipoSiElPartidoNoTieneLaCantidadMaxDeJugadores() {
    this.partido.setMaximoLista(10);
    this.partido.setDivisorEquipo(this.divPosiciones);
    try {
      this.partido.partidoDividiEquipos();
      Assert.fail("No se puede dividir equipos si no tiene la cantidad maxima de jugadores para partido");
    } catch (final Throwable _t) {
      if (_t instanceof PartidoNoPoseeCantidadMaxima) {
        final PartidoNoPoseeCantidadMaxima e = (PartidoNoPoseeCantidadMaxima)_t;
        List<Jugador> _equipo1 = this.partido.getEquipo1();
        boolean _isEmpty = _equipo1.isEmpty();
        Assert.assertTrue(_isEmpty);
        List<Jugador> _equipo2 = this.partido.getEquipo2();
        boolean _isEmpty_1 = _equipo2.isEmpty();
        Assert.assertTrue(_isEmpty_1);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Test
  public void noSePuedeDividirEquipoSiElYaEstaConfirmado() {
    this.partido.setConfirmadoAdm(true);
    this.partido.setDivisorEquipo(this.divPosiciones);
    try {
      this.partido.partidoDividiEquipos();
      Assert.fail("No se puede dividir equipos si el partido ya esta confirmado");
    } catch (final Throwable _t) {
      if (_t instanceof PartidoYaConfirmado) {
        final PartidoYaConfirmado e = (PartidoYaConfirmado)_t;
        List<Jugador> _equipo1 = this.partido.getEquipo1();
        boolean _isEmpty = _equipo1.isEmpty();
        Assert.assertTrue(_isEmpty);
        List<Jugador> _equipo2 = this.partido.getEquipo2();
        boolean _isEmpty_1 = _equipo2.isEmpty();
        Assert.assertTrue(_isEmpty_1);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public boolean equiposDivisionParImpar() {
    boolean _xblockexpression = false;
    {
      this.equipo1.clear();
      this.equipo1.add(this.jugador1);
      this.equipo1.add(this.jugador3);
      this.equipo2.clear();
      this.equipo2.add(this.jugador2);
      _xblockexpression = this.equipo2.add(this.jugador4);
    }
    return _xblockexpression;
  }
  
  public boolean equiposDivisionPosiciones1y3() {
    boolean _xblockexpression = false;
    {
      this.equipo1.clear();
      this.equipo1.add(this.jugador1);
      this.equipo1.add(this.jugador4);
      this.equipo2.clear();
      this.equipo2.add(this.jugador2);
      _xblockexpression = this.equipo2.add(this.jugador3);
    }
    return _xblockexpression;
  }
}
