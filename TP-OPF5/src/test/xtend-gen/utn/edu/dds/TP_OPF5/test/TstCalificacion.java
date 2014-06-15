package utn.edu.dds.TP_OPF5.test;

import exception.JugadorNoPerteneceAlPartido;
import exception.MeCalificoAMiMismo;
import exception.NotaIncorrecta;
import exception.YaLoCalifique;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import partido.calificaciones.Calificacion;
import partido.core.Jugador;
import partido.core.Partido;
import partido.core.tiposDeInscripcion.Estandar;
import partido.nuevosJugadores.Administrador;

@SuppressWarnings("all")
public class TstCalificacion {
  private Jugador jugador;
  
  private Partido partido;
  
  private Estandar tipoIncEstandar;
  
  private Jugador jugadorCalificado;
  
  @Before
  public void init() {
    Jugador _jugador = new Jugador("Rodolfo", "rodol@aol.com");
    this.jugador = _jugador;
    Administrador _administrador = new Administrador("admin@aol.com");
    Partido _partido = new Partido("Partido_1", _administrador);
    this.partido = _partido;
    Estandar _estandar = new Estandar();
    this.tipoIncEstandar = _estandar;
    this.jugador.inscribite(this.partido, this.tipoIncEstandar);
    Jugador _jugador_1 = new Jugador("Ricardo", "ricky@aol.com");
    this.jugadorCalificado = _jugador_1;
    this.jugadorCalificado.inscribite(this.partido, this.tipoIncEstandar);
  }
  
  @Test
  public void sePuedeCalificarAJugadorSoloConNota() {
    List<Calificacion> _calificaciones = this.jugadorCalificado.getCalificaciones();
    final int len = _calificaciones.size();
    this.jugador.calificarA(this.jugadorCalificado, this.partido, 9, null);
    List<Calificacion> _calificaciones_1 = this.jugadorCalificado.getCalificaciones();
    int _size = _calificaciones_1.size();
    Assert.assertEquals(_size, (len + 1));
  }
  
  @Test
  public void sePuedeCalificarAJugadorConNotaYMensaje() {
    List<Calificacion> _calificaciones = this.jugadorCalificado.getCalificaciones();
    final int len = _calificaciones.size();
    this.jugador.calificarA(this.jugadorCalificado, this.partido, 9, "La gambeta que tiro en el minuto 20 fue impresionante");
    List<Calificacion> _calificaciones_1 = this.jugadorCalificado.getCalificaciones();
    int _size = _calificaciones_1.size();
    Assert.assertEquals(_size, (len + 1));
  }
  
  @Test
  public void noSePuedeCalificarAJugadorConNotaIncorrecta() {
    try {
      this.jugador.calificarA(this.jugadorCalificado, this.partido, 25, null);
      Assert.fail("No se puede calificar a jugador con que no este entre 1 y 10");
    } catch (final Throwable _t) {
      if (_t instanceof NotaIncorrecta) {
        final NotaIncorrecta e = (NotaIncorrecta)_t;
        List<Calificacion> _calificaciones = this.jugadorCalificado.getCalificaciones();
        boolean _isEmpty = _calificaciones.isEmpty();
        Assert.assertTrue(_isEmpty);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Test
  public void noSePuedeCalificarAJugadorQueNoExisteEnPartido() {
    Jugador jugadorNoEstaEnPartido = new Jugador("Robert", "Robert22@aol.com");
    try {
      this.jugador.calificarA(jugadorNoEstaEnPartido, this.partido, 9, null);
      Assert.fail("No se puede calificar a jugador que no existe");
    } catch (final Throwable _t) {
      if (_t instanceof JugadorNoPerteneceAlPartido) {
        final JugadorNoPerteneceAlPartido e = (JugadorNoPerteneceAlPartido)_t;
        List<Calificacion> _calificaciones = this.jugadorCalificado.getCalificaciones();
        boolean _isEmpty = _calificaciones.isEmpty();
        Assert.assertTrue(_isEmpty);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Test
  public void noSePuedeCalificarAlMismoJugadorDosVecesParaUnMismoPartido() {
    this.jugador.calificarA(this.jugadorCalificado, this.partido, 9, null);
    try {
      this.jugador.calificarA(this.jugadorCalificado, this.partido, 9, null);
      Assert.fail("No se puede calificar dos veces al mismo jugador");
    } catch (final Throwable _t) {
      if (_t instanceof YaLoCalifique) {
        final YaLoCalifique e = (YaLoCalifique)_t;
        List<Calificacion> _calificaciones = this.jugadorCalificado.getCalificaciones();
        int _size = _calificaciones.size();
        Assert.assertEquals(_size, 1);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Test
  public void NoSePuedeCalificarAUnoMismo() {
    try {
      this.jugador.calificarA(this.jugador, this.partido, 9, null);
      Assert.fail("No se puede calificar a uno mismo");
    } catch (final Throwable _t) {
      if (_t instanceof MeCalificoAMiMismo) {
        final MeCalificoAMiMismo e = (MeCalificoAMiMismo)_t;
        List<Calificacion> _calificaciones = this.jugadorCalificado.getCalificaciones();
        boolean _isEmpty = _calificaciones.isEmpty();
        Assert.assertTrue(_isEmpty);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
