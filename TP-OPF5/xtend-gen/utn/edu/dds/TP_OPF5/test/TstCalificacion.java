package utn.edu.dds.TP_OPF5.test;

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
  
  /* @Before
   */public void init() {
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
  
  /* @Test
   */public void sePuedeCalificarAJugadorSoloConNota() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Assert is undefined for the type TstCalificacion"
      + "\nThe field calificaciones is not visible"
      + "\nThe field calificaciones is not visible"
      + "\nsize cannot be resolved"
      + "\nassertEquals cannot be resolved"
      + "\nsize cannot be resolved"
      + "\n+ cannot be resolved");
  }
  
  /* @Test
   */public void sePuedeCalificarAJugadorConNotaYMensaje() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Assert is undefined for the type TstCalificacion"
      + "\nThe field calificaciones is not visible"
      + "\nThe field calificaciones is not visible"
      + "\nsize cannot be resolved"
      + "\nassertEquals cannot be resolved"
      + "\nsize cannot be resolved"
      + "\n+ cannot be resolved");
  }
  
  /* @Test
   */public void noSePuedeCalificarAJugadorConNotaIncorrecta() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Assert is undefined for the type TstCalificacion"
      + "\nThe method or field Assert is undefined for the type TstCalificacion"
      + "\nThe field calificaciones is not visible"
      + "\nNo exception of type NotaIncorrecta can be thrown; an exception type must be a subclass of Throwable"
      + "\nfail cannot be resolved"
      + "\nassertTrue cannot be resolved"
      + "\nempty cannot be resolved");
  }
  
  /* @Test
   */public void noSePuedeCalificarAJugadorQueNoExisteEnPartido() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Assert is undefined for the type TstCalificacion"
      + "\nThe method or field Assert is undefined for the type TstCalificacion"
      + "\nThe field calificaciones is not visible"
      + "\nNo exception of type JugadorNoPerteneceAlPartido can be thrown; an exception type must be a subclass of Throwable"
      + "\nfail cannot be resolved"
      + "\nassertTrue cannot be resolved"
      + "\nempty cannot be resolved");
  }
  
  /* @Test
   */public void noSePuedeCalificarAlMismoJugadorDosVecesParaUnMismoPartido() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Assert is undefined for the type TstCalificacion"
      + "\nThe method or field Assert is undefined for the type TstCalificacion"
      + "\nThe field calificaciones is not visible"
      + "\nNo exception of type YaLoCalifique can be thrown; an exception type must be a subclass of Throwable"
      + "\nfail cannot be resolved"
      + "\nassertEquals cannot be resolved"
      + "\nsize cannot be resolved");
  }
  
  /* @Test
   */public void NoSePuedeCalificarAUnoMismo() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Assert is undefined for the type TstCalificacion"
      + "\nThe method or field Assert is undefined for the type TstCalificacion"
      + "\nThe field calificaciones is not visible"
      + "\nNo exception of type MeCalificoAMiMismo can be thrown; an exception type must be a subclass of Throwable"
      + "\nfail cannot be resolved"
      + "\nassertTrue cannot be resolved"
      + "\nempty cannot be resolved");
  }
}
