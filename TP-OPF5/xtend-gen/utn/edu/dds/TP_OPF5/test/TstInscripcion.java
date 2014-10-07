package utn.edu.dds.TP_OPF5.test;

import partido.core.Jugador;
import partido.core.Partido;
import partido.core.tiposDeInscripcion.Condicional;
import partido.core.tiposDeInscripcion.Estandar;
import partido.core.tiposDeInscripcion.Solidaria;
import partido.mailSender.MailSender;

@SuppressWarnings("all")
public class TstInscripcion {
  private Jugador jugador;
  
  private Partido partido;
  
  private Estandar tipoIncEstandar;
  
  private Condicional tipoIncCondicional;
  
  private Solidaria tipoIncSolidaria;
  
  private MailSender mockMailSender;
  
  /* @Before
   */public void init() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method mock is undefined for the type TstInscripcion");
  }
  
  /* @Test
   */public void inscribirJugadorModoEstandarConLugar() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Assert is undefined for the type TstInscripcion"
      + "\nassertTrue cannot be resolved");
  }
  
  /* @Test
   */public void noSePuedeInscribirUnJugadorCuandoElPartidoEstaCompleto() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Assert is undefined for the type TstInscripcion"
      + "\nThe method or field Assert is undefined for the type TstInscripcion"
      + "\nNo exception of type PartidoCompletoExcepcion can be thrown; an exception type must be a subclass of Throwable"
      + "\nassertFalse cannot be resolved"
      + "\nassertFalse cannot be resolved");
  }
  
  public Partido crearPartidoCompleto() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field maximoLista is not visible");
  }
  
  /* @Test
   */public void jugadorSeDaDeBajaYDejaReemplazante() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Assert is undefined for the type TstInscripcion"
      + "\nassertTrue cannot be resolved"
      + "\n&& cannot be resolved"
      + "\n! cannot be resolved");
  }
  
  /* @Test
   */public void jugadorSeDaDeBajaSinReemplazanteRecibeInfraccion() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Assert is undefined for the type TstInscripcion"
      + "\nThe field infracciones is not visible"
      + "\nassertTrue cannot be resolved"
      + "\nsize cannot be resolved"
      + "\n== cannot be resolved");
  }
  
  /* @Test
   */public void inscribirJugadorModoSolidarioConLugar() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Assert is undefined for the type TstInscripcion"
      + "\nassertTrue cannot be resolved");
  }
  
  /* @Test
   */public void inscribirJugadorModoSolidarioSinLugar() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Assert is undefined for the type TstInscripcion"
      + "\nThe method or field Assert is undefined for the type TstInscripcion"
      + "\nNo exception of type PartidoCompletoExcepcion can be thrown; an exception type must be a subclass of Throwable"
      + "\nassertFalse cannot be resolved"
      + "\nassertFalse cannot be resolved");
  }
  
  /* @Test
   */public void inscribirJugadorModoCondicionalCumpleCondicion() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Assert is undefined for the type TstInscripcion"
      + "\nassertTrue cannot be resolved");
  }
  
  /* @Test
   */public void inscribirJugadorModoCondicionalNoCumpleCondicion() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method setCondicion is undefined for the type TstInscripcion"
      + "\nThe method or field Assert is undefined for the type TstInscripcion"
      + "\nThe method or field Assert is undefined for the type TstInscripcion"
      + "\nNo exception of type PartidoNoCumpleCondicionesExcepcion can be thrown; an exception type must be a subclass of Throwable"
      + "\nassertFalse cannot be resolved"
      + "\nassertFalse cannot be resolved");
  }
  
  /* @Test
   */public void jugadorEstandarTienePrioridadSobreSolidario() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Assert is undefined for the type TstInscripcion"
      + "\nThe field maximoLista is not visible"
      + "\nassertTrue cannot be resolved");
  }
}
