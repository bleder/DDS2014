package utn.edu.dds.TP_OPF5.test;

import exception.PartidoCompletoExcepcion;
import exception.PartidoNoCumpleCondicionesExcepcion;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import partido.core.Infraccion;
import partido.core.Jugador;
import partido.core.Partido;
import partido.core.tiposDeInscripcion.Condicional;
import partido.core.tiposDeInscripcion.Estandar;
import partido.core.tiposDeInscripcion.Solidaria;
import partido.mailSender.MailSender;
import partido.nuevosJugadores.Administrador;

@SuppressWarnings("all")
public class TstInscripcion {
  private Jugador jugador;
  
  private Partido partido;
  
  private Estandar tipoIncEstandar;
  
  private Condicional tipoIncCondicional;
  
  private Solidaria tipoIncSolidaria;
  
  private MailSender mockMailSender;
  
  @Before
  public void init() {
    Jugador _jugador = new Jugador("Rodolfo", "rodol@aol.com");
    this.jugador = _jugador;
    MailSender _mailSender = new MailSender();
    Administrador _administrador = new Administrador("admin@aol.com");
    Partido _partido = new Partido("Partido_1", _mailSender, _administrador);
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
    MailSender _mock = Mockito.<MailSender>mock(MailSender.class);
    this.mockMailSender = _mock;
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
        return;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    Assert.assertFalse(true);
  }
  
  public Partido crearPartidoCompleto() {
    Partido _xblockexpression = null;
    {
      MailSender _mailSender = new MailSender();
      Administrador _administrador = new Administrador("admin@aol.com");
      final Partido completo = new Partido("Hola", _mailSender, _administrador);
      completo.setMaximoLista(0);
      _xblockexpression = completo;
    }
    return _xblockexpression;
  }
  
  @Test
  public void jugadorSeDaDeBajaYDejaReemplazante() {
    Jugador jugador2 = new Jugador("Ricardo", "ricky@aol.com");
    this.partido.agregarJugador(this.jugador, this.tipoIncEstandar);
    this.partido.darBajaA(this.jugador, jugador2, this.tipoIncEstandar);
    boolean _and = false;
    boolean _estaInscripto = this.partido.estaInscripto(jugador2);
    if (!_estaInscripto) {
      _and = false;
    } else {
      boolean _estaInscripto_1 = this.partido.estaInscripto(this.jugador);
      boolean _not = (!_estaInscripto_1);
      _and = _not;
    }
    Assert.assertTrue(_and);
  }
  
  @Test
  public void jugadorSeDaDeBajaSinReemplazanteRecibeInfraccion() {
    this.partido.agregarJugador(this.jugador, this.tipoIncEstandar);
    this.partido.darBajaA(this.jugador);
    List<Infraccion> _infracciones = this.jugador.getInfracciones();
    int _size = _infracciones.size();
    boolean _equals = (_size == 1);
    Assert.assertTrue(_equals);
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
        return;
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
        return;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    Assert.assertFalse(true);
  }
  
  @Test
  public void jugadorEstandarTienePrioridadSobreSolidario() {
    MailSender _mailSender = new MailSender();
    Administrador _administrador = new Administrador("admin@aol.com");
    Partido partido = new Partido("Cancha 2", _mailSender, _administrador);
    partido.setMaximoLista(1);
    Jugador _jugador = new Jugador("Roberto", "rober@hotmail.com");
    _jugador.inscribite(partido, this.tipoIncSolidaria);
    this.jugador.inscribite(partido, this.tipoIncEstandar);
    boolean _estaInscripto = partido.estaInscripto(this.jugador);
    Assert.assertTrue(_estaInscripto);
  }
}
