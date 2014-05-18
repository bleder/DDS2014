package utn.edu.dds.TP_OPF5.test;

import exception.PartidoCompletoExcepcion;
import exception.PartidoNoCumpleCondicionesExcepcion;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utn.edu.dds.TP_OPF5.Condicional;
import utn.edu.dds.TP_OPF5.Estandar;
import utn.edu.dds.TP_OPF5.Jugador;
import utn.edu.dds.TP_OPF5.Partido;
import utn.edu.dds.TP_OPF5.Solidaria;

@SuppressWarnings("all")
public class TstInscripcion {
  private Jugador jugador;
  
  private Partido partido;
  
  private Estandar tipoIncEstandar;
  
  private Condicional tipoIncCondicional;
  
  private Solidaria tipoIncSolidaria;
  
  @Before
  public void init() {
    Jugador _jugador = new Jugador("Rodolfo");
    this.jugador = _jugador;
    Partido _partido = new Partido("Partido_1");
    this.partido = _partido;
    Estandar _estandar = new Estandar();
    this.tipoIncEstandar = _estandar;
    final Function1<Partido,Boolean> _function = new Function1<Partido,Boolean>() {
      public Boolean apply(final Partido part) {
        return Boolean.valueOf(true);
      }
    };
    Condicional _condicional = new Condicional(_function);
    this.tipoIncCondicional = _condicional;
    Solidaria _solidaria = new Solidaria();
    this.tipoIncSolidaria = _solidaria;
  }
  
  @Test
  public void inscribirJugadorModoEstandarConLugar() {
    this.jugador.inscribite(this.partido, this.tipoIncEstandar);
    boolean _estaInscripto = this.partido.estaInscripto(this.jugador);
    Assert.assertTrue(_estaInscripto);
  }
  
  @Test
  public void noSePuedeInscribirUnJugadorCuandoElPartidoEstaCompleto() {
    Partido partidoCompleto = this.crearPartidoCompleto();
    try {
      this.jugador.inscribite(partidoCompleto, this.tipoIncEstandar);
    } catch (final Throwable _t) {
      if (_t instanceof PartidoCompletoExcepcion) {
        final PartidoCompletoExcepcion e = (PartidoCompletoExcepcion)_t;
        boolean _estaInscripto = partidoCompleto.estaInscripto(this.jugador);
        Assert.assertFalse(_estaInscripto);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    Assert.assertFalse(true);
  }
  
  public Partido crearPartidoCompleto() {
    Partido _xblockexpression = null;
    {
      final Partido completo = new Partido("Hola");
      completo.setMaximoLista(0);
      _xblockexpression = completo;
    }
    return _xblockexpression;
  }
  
  @Test
  public void inscribirJugadorModoSolidarioConLugar() {
    this.jugador.inscribite(this.partido, this.tipoIncSolidaria);
    boolean _estaInscripto = this.partido.estaInscripto(this.jugador);
    Assert.assertTrue(_estaInscripto);
  }
  
  @Test
  public void inscribirJugadorModoSolidarioSinLugar() {
    Partido partidoCompleto = this.crearPartidoCompleto();
    try {
      this.jugador.inscribite(partidoCompleto, this.tipoIncSolidaria);
    } catch (final Throwable _t) {
      if (_t instanceof PartidoCompletoExcepcion) {
        final PartidoCompletoExcepcion e = (PartidoCompletoExcepcion)_t;
        boolean _estaInscripto = partidoCompleto.estaInscripto(this.jugador);
        Assert.assertFalse(_estaInscripto);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    Assert.assertFalse(true);
  }
  
  @Test
  public void inscribirJugadorModoCondicionalCumpleCondicion() {
    this.jugador.inscribite(this.partido, this.tipoIncCondicional);
    boolean _estaInscripto = this.partido.estaInscripto(this.jugador);
    Assert.assertTrue(_estaInscripto);
  }
  
  @Test
  public void inscribirJugadorModoCondicionalNoCumpleCondicion() {
    final Function1<Partido,Boolean> _function = new Function1<Partido,Boolean>() {
      public Boolean apply(final Partido part) {
        return Boolean.valueOf(false);
      }
    };
    this.tipoIncCondicional.setCondicion(_function);
    Partido partidoCompleto = this.crearPartidoCompleto();
    try {
      this.jugador.inscribite(partidoCompleto, this.tipoIncCondicional);
    } catch (final Throwable _t) {
      if (_t instanceof PartidoNoCumpleCondicionesExcepcion) {
        final PartidoNoCumpleCondicionesExcepcion e = (PartidoNoCumpleCondicionesExcepcion)_t;
        boolean _estaInscripto = partidoCompleto.estaInscripto(this.jugador);
        Assert.assertFalse(_estaInscripto);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    Assert.assertFalse(true);
  }
  
  @Test
  public void jugadorEstandarTienePrioridadSobreSolidario() {
    Partido partido = new Partido("Cancha 2");
    partido.setMaximoLista(1);
    Jugador _jugador = new Jugador("Roberto");
    _jugador.inscribite(partido, this.tipoIncSolidaria);
    this.jugador.inscribite(partido, this.tipoIncEstandar);
    boolean _estaInscripto = partido.estaInscripto(this.jugador);
    Assert.assertTrue(_estaInscripto);
  }
}
