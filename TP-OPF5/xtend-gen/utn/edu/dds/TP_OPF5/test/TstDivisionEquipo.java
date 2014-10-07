package utn.edu.dds.TP_OPF5.test;

import divisionEquipo.DivParImpar;
import divisionEquipo.DivPosiciones;
import partido.core.Jugador;
import partido.core.Partido;
import partido.core.tiposDeInscripcion.Estandar;

@SuppressWarnings("all")
public class TstDivisionEquipo {
  private Jugador jugador1;
  
  private Jugador jugador2;
  
  private Jugador jugador3;
  
  private Jugador jugador4;
  
  private Partido partido;
  
  private Estandar tipoIncEstandar;
  
  private /* List<Jugador> */Object equipo1 /* Skipped initializer because of errors */;
  
  private /* List<Jugador> */Object equipo2 /* Skipped initializer because of errors */;
  
  private DivParImpar divParImpar;
  
  private DivPosiciones divPosiciones;
  
  private /* List<Integer> */Object posiciones /* Skipped initializer because of errors */;
  
  /* @Before
   */public void init() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field maximoLista is not visible");
  }
  
  public DivPosiciones initDivision() {
    throw new Error("Unresolved compilation problems:"
      + "\nadd cannot be resolved"
      + "\nadd cannot be resolved");
  }
  
  public Object initJugadores() {
    Object _xblockexpression = null;
    {
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
      _xblockexpression = this.partido.confirmarJugador(this.jugador4);
    }
    return _xblockexpression;
  }
  
  /* @Test
   */public void dividirEquiposPorPosicionParImpar() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Assert is undefined for the type TstDivisionEquipo"
      + "\nThe method or field Assert is undefined for the type TstDivisionEquipo"
      + "\nThe field divisorEquipo is not visible"
      + "\nThe field equipo1 is not visible"
      + "\nThe field equipo2 is not visible"
      + "\nassertArrayEquals cannot be resolved"
      + "\nassertArrayEquals cannot be resolved");
  }
  
  /* @Test
   */public void dividirEquiposPorPosiciones1y3EnUnEquipo() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Assert is undefined for the type TstDivisionEquipo"
      + "\nThe method or field Assert is undefined for the type TstDivisionEquipo"
      + "\nThe field divisorEquipo is not visible"
      + "\nThe field equipo1 is not visible"
      + "\nThe field equipo2 is not visible"
      + "\nassertArrayEquals cannot be resolved"
      + "\nassertArrayEquals cannot be resolved");
  }
  
  /* @Test
   */public void noSePuedeDividirEquipoSiElPartidoNoTieneLaCantidadMaxDeJugadores() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Assert is undefined for the type TstDivisionEquipo"
      + "\nThe method or field Assert is undefined for the type TstDivisionEquipo"
      + "\nThe method or field Assert is undefined for the type TstDivisionEquipo"
      + "\nThe field maximoLista is not visible"
      + "\nThe field divisorEquipo is not visible"
      + "\nThe field equipo1 is not visible"
      + "\nThe field equipo2 is not visible"
      + "\nNo exception of type PartidoNoPoseeCantidadMaxima can be thrown; an exception type must be a subclass of Throwable"
      + "\nfail cannot be resolved"
      + "\nassertTrue cannot be resolved"
      + "\nempty cannot be resolved"
      + "\nassertTrue cannot be resolved"
      + "\nempty cannot be resolved");
  }
  
  /* @Test
   */public void noSePuedeDividirEquipoSiElYaEstaConfirmado() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Assert is undefined for the type TstDivisionEquipo"
      + "\nThe method or field Assert is undefined for the type TstDivisionEquipo"
      + "\nThe method or field Assert is undefined for the type TstDivisionEquipo"
      + "\nThe field confirmadoAdm is not visible"
      + "\nThe field divisorEquipo is not visible"
      + "\nThe field equipo1 is not visible"
      + "\nThe field equipo2 is not visible"
      + "\nNo exception of type PartidoYaConfirmado can be thrown; an exception type must be a subclass of Throwable"
      + "\nfail cannot be resolved"
      + "\nassertTrue cannot be resolved"
      + "\nempty cannot be resolved"
      + "\nassertTrue cannot be resolved"
      + "\nempty cannot be resolved");
  }
  
  public Object equiposDivisionParImpar() {
    throw new Error("Unresolved compilation problems:"
      + "\nclear cannot be resolved"
      + "\nadd cannot be resolved"
      + "\nadd cannot be resolved"
      + "\nclear cannot be resolved"
      + "\nadd cannot be resolved"
      + "\nadd cannot be resolved");
  }
  
  public Object equiposDivisionPosiciones1y3() {
    throw new Error("Unresolved compilation problems:"
      + "\nclear cannot be resolved"
      + "\nadd cannot be resolved"
      + "\nadd cannot be resolved"
      + "\nclear cannot be resolved"
      + "\nadd cannot be resolved"
      + "\nadd cannot be resolved");
  }
}
