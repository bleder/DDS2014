package utn.edu.dds.TP_OPF5.test;

import exception.PartidoConfirmadoNoAceptaBaja;
import exception.PartidoYaConfirmado;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import partido.core.Jugador;
import partido.core.NoSeRealizoDivisionDeEquipos;
import partido.core.Partido;
import partido.core.tiposDeInscripcion.Estandar;
import partido.nuevosJugadores.Administrador;

@SuppressWarnings("all")
public class TstConfirmacionEquipo {
  private Jugador jugador1;
  
  private Jugador jugador2;
  
  private Partido partido;
  
  private Estandar tipoIncEstandar;
  
  @Before
  public void init() {
    Administrador _administrador = new Administrador("admin@aol.com");
    Partido _partido = new Partido("Partido_1", _administrador);
    this.partido = _partido;
    Estandar _estandar = new Estandar();
    this.tipoIncEstandar = _estandar;
    this.initJugadores();
  }
  
  public void initJugadores() {
    Jugador _jugador = new Jugador("Rodolfo", "rodol@aol.com");
    this.jugador1 = _jugador;
    Jugador _jugador_1 = new Jugador("Pepe", "pepe@gmail.com");
    this.jugador2 = _jugador_1;
    this.jugador1.inscribite(this.partido, this.tipoIncEstandar);
    this.jugador2.inscribite(this.partido, this.tipoIncEstandar);
    this.partido.confirmarJugador(this.jugador1);
    this.partido.confirmarJugador(this.jugador2);
  }
  
  @Test
  public void sePuedeConfirmarEquipoQueAlcanzaMaximoDeJugadoresYSeRealizoDivisionDeEquipos() {
    this.partidoParaConfirmar();
    this.partido.confirmate();
    boolean _isConfirmadoAdm = this.partido.isConfirmadoAdm();
    Assert.assertTrue(_isConfirmadoAdm);
  }
  
  public boolean partidoParaConfirmar() {
    boolean _xblockexpression = false;
    {
      this.partido.setMaximoLista(2);
      List<Jugador> _equipo1 = this.partido.getEquipo1();
      _equipo1.add(this.jugador1);
      List<Jugador> _equipo2 = this.partido.getEquipo2();
      _xblockexpression = _equipo2.add(this.jugador2);
    }
    return _xblockexpression;
  }
  
  public void partidoYaConfirmadoConDivisionEquipos() {
    this.partido.setMaximoLista(2);
    List<Jugador> _equipo1 = this.partido.getEquipo1();
    _equipo1.add(this.jugador1);
    List<Jugador> _equipo2 = this.partido.getEquipo2();
    _equipo2.add(this.jugador2);
    this.partido.setConfirmadoAdm(true);
  }
  
  @Test
  public void noSePuedeConfirmarEquipoQueNoSeRealizoDivisionDeEquipos() {
    this.partido.setMaximoLista(2);
    try {
      this.partido.confirmate();
      Assert.fail("No se realizo division de equipos, no se puede confirmar partido");
    } catch (final Throwable _t) {
      if (_t instanceof NoSeRealizoDivisionDeEquipos) {
        final NoSeRealizoDivisionDeEquipos e = (NoSeRealizoDivisionDeEquipos)_t;
        boolean _isConfirmadoAdm = this.partido.isConfirmadoAdm();
        Assert.assertFalse(_isConfirmadoAdm);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Test
  public void noSePuedeConfirmarEquipoQueSeYaEstaConfirmado() {
    this.partidoYaConfirmadoConDivisionEquipos();
    try {
      this.partido.confirmate();
      Assert.fail("El partido se encuentra confirmado no se puede realizar division de equipos");
    } catch (final Throwable _t) {
      if (_t instanceof PartidoYaConfirmado) {
        final PartidoYaConfirmado e = (PartidoYaConfirmado)_t;
        boolean _isConfirmadoAdm = this.partido.isConfirmadoAdm();
        Assert.assertTrue(_isConfirmadoAdm);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Test
  public void noSePuedeDarDeBajaJugadorDeUnPartidoConfirmadoPorAdm() {
    this.partidoParaConfirmar();
    this.partido.confirmate();
    try {
      this.partido.darBajaA(this.jugador1);
      Assert.fail("No se puede dar de baja si el partido esta confirmado");
    } catch (final Throwable _t) {
      if (_t instanceof PartidoConfirmadoNoAceptaBaja) {
        final PartidoConfirmadoNoAceptaBaja e = (PartidoConfirmadoNoAceptaBaja)_t;
        boolean _estasConfirmado = this.partido.estasConfirmado();
        Assert.assertTrue(_estasConfirmado);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Test
  public void noSePuedeDarDeBajaAJugadorAunqueSePongaReemplazanteDeUnPartidoConfirmadoPorAdm() {
    this.partidoParaConfirmar();
    this.partido.confirmate();
    try {
      this.partido.darBajaA(this.jugador1, this.jugador2, this.tipoIncEstandar);
      Assert.fail("No se puede dar de baja si el partido esta confirmado");
    } catch (final Throwable _t) {
      if (_t instanceof PartidoConfirmadoNoAceptaBaja) {
        final PartidoConfirmadoNoAceptaBaja e = (PartidoConfirmadoNoAceptaBaja)_t;
        boolean _estasConfirmado = this.partido.estasConfirmado();
        Assert.assertTrue(_estasConfirmado);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
