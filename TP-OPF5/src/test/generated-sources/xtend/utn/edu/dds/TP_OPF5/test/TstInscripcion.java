package utn.edu.dds.TP_OPF5.test;

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
    Condicional _condicional = new Condicional();
    this.tipoIncCondicional = _condicional;
    Solidaria _solidaria = new Solidaria();
    this.tipoIncSolidaria = _solidaria;
  }
  
  @Test
  public void inscribirJugadorModoEstandarListaMenor10() {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from void to boolean");
  }
  
  @Test
  public void noSePuedeInscribirUnJugadorCuandoElPartidoEstaCompleto() {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from void to boolean");
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
  public void inscribirJugadorModoSolidarioListaMenor10() {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from void to boolean");
  }
  
  @Test
  public void inscribirJugadorModoSolidarioListaMayor10() {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from void to boolean");
  }
  
  @Test
  public void inscribirJugadorModoCondicionalCumpleCondicion() {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from void to boolean");
  }
  
  @Test
  public void inscribirJugadorModoCondicionalNoCumpleCondicion() {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from void to boolean");
  }
  
  @Test
  public void inscribirJugadorModoEstandarListaMayor10ConUnSolidario() {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from void to boolean");
  }
  
  @Test
  public void testInscribirUnEstandarEnUnPartidoCompletoConDosSolidariosInscribeAlStandardYDejaAfueraAlUltimoSolidario() {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from void to boolean");
  }
}
