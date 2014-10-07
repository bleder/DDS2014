package utn.edu.dds.TP_OPF5.test;

import partido.core.Jugador;
import partido.core.Partido;
import partido.core.tiposDeInscripcion.Estandar;
import partido.nuevosJugadores.Administrador;

@SuppressWarnings("all")
public class TstConfirmacionEquipo {
  private Jugador jugador1;
  
  private Jugador jugador2;
  
  private Partido partido;
  
  private Estandar tipoIncEstandar;
  
  /* @Before
   */public void init() {
    Administrador _administrador = new Administrador("admin@aol.com");
    Partido _partido = new Partido("Partido_1", _administrador);
    this.partido = _partido;
    Estandar _estandar = new Estandar();
    this.tipoIncEstandar = _estandar;
    this.initJugadores();
  }
  
  public Object initJugadores() {
    Object _xblockexpression = null;
    {
      Jugador _jugador = new Jugador("Rodolfo", "rodol@aol.com");
      this.jugador1 = _jugador;
      Jugador _jugador_1 = new Jugador("Pepe", "pepe@gmail.com");
      this.jugador2 = _jugador_1;
      this.jugador1.inscribite(this.partido, this.tipoIncEstandar);
      this.jugador2.inscribite(this.partido, this.tipoIncEstandar);
      this.partido.confirmarJugador(this.jugador1);
      _xblockexpression = this.partido.confirmarJugador(this.jugador2);
    }
    return _xblockexpression;
  }
  
  /* @Test
   */public void sePuedeConfirmarEquipoQueAlcanzaMaximoDeJugadoresYSeRealizoDivisionDeEquipos() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Assert is undefined for the type TstConfirmacionEquipo"
      + "\nThe field confirmadoAdm is not visible"
      + "\nassertTrue cannot be resolved");
  }
  
  public Object partidoParaConfirmar() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field maximoLista is not visible"
      + "\nThe field equipo1 is not visible"
      + "\nThe field equipo2 is not visible"
      + "\nadd cannot be resolved"
      + "\nadd cannot be resolved");
  }
  
  public boolean partidoYaConfirmadoConDivisionEquipos() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field maximoLista is not visible"
      + "\nThe field equipo1 is not visible"
      + "\nThe field equipo2 is not visible"
      + "\nThe field confirmadoAdm is not visible"
      + "\nadd cannot be resolved"
      + "\nadd cannot be resolved");
  }
  
  /* @Test
   */public void noSePuedeConfirmarEquipoQueNoSeRealizoDivisionDeEquipos() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Assert is undefined for the type TstConfirmacionEquipo"
      + "\nThe method or field Assert is undefined for the type TstConfirmacionEquipo"
      + "\nThe field maximoLista is not visible"
      + "\nThe field confirmadoAdm is not visible"
      + "\nNo exception of type NoSeRealizoDivisionDeEquipos can be thrown; an exception type must be a subclass of Throwable"
      + "\nfail cannot be resolved"
      + "\nassertFalse cannot be resolved");
  }
  
  /* @Test
   */public void noSePuedeConfirmarEquipoQueSeYaEstaConfirmado() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Assert is undefined for the type TstConfirmacionEquipo"
      + "\nThe method or field Assert is undefined for the type TstConfirmacionEquipo"
      + "\nThe field confirmadoAdm is not visible"
      + "\nNo exception of type PartidoYaConfirmado can be thrown; an exception type must be a subclass of Throwable"
      + "\nfail cannot be resolved"
      + "\nassertTrue cannot be resolved");
  }
  
  /* @Test
   */public void noSePuedeDarDeBajaJugadorDeUnPartidoConfirmadoPorAdm() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Assert is undefined for the type TstConfirmacionEquipo"
      + "\nThe method or field Assert is undefined for the type TstConfirmacionEquipo"
      + "\nNo exception of type PartidoConfirmadoNoAceptaBaja can be thrown; an exception type must be a subclass of Throwable"
      + "\nfail cannot be resolved"
      + "\nassertTrue cannot be resolved");
  }
  
  /* @Test
   */public void noSePuedeDarDeBajaAJugadorAunqueSePongaReemplazanteDeUnPartidoConfirmadoPorAdm() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Assert is undefined for the type TstConfirmacionEquipo"
      + "\nThe method or field Assert is undefined for the type TstConfirmacionEquipo"
      + "\nNo exception of type PartidoConfirmadoNoAceptaBaja can be thrown; an exception type must be a subclass of Throwable"
      + "\nfail cannot be resolved"
      + "\nassertTrue cannot be resolved");
  }
}
