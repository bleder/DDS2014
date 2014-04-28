package utn.edu.dds.TP_OPF5.test;

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
    Condicional _condicional = new Condicional();
    this.tipoIncCondicional = _condicional;
    Solidaria _solidaria = new Solidaria();
    this.tipoIncSolidaria = _solidaria;
  }
  
  @Test
  public void inscribirJugadorModoEstandarListaMenor10() {
    boolean _inscribite = this.jugador.inscribite(this.partido, this.tipoIncEstandar);
    Assert.assertTrue(_inscribite);
  }
  
  @Test
  public void inscribirJugadorModoEstandarListaMayor10() {
    boolean _inscribite = this.jugador.inscribite(this.partido, this.tipoIncEstandar);
    Assert.assertFalse(_inscribite);
  }
  
  @Test
  public void inscribirJugadorModoSolidarioListaMenor10() {
    boolean _inscribite = this.jugador.inscribite(this.partido, this.tipoIncSolidaria);
    Assert.assertTrue(_inscribite);
  }
  
  @Test
  public void inscribirJugadorModoSolidarioListaMayor10() {
    boolean _inscribite = this.jugador.inscribite(this.partido, this.tipoIncSolidaria);
    Assert.assertFalse(_inscribite);
  }
  
  @Test
  public void inscribirJugadorModoCondicionalCumpleCondicion() {
    boolean _inscribite = this.jugador.inscribite(this.partido, this.tipoIncCondicional);
    Assert.assertTrue(_inscribite);
  }
  
  @Test
  public void inscribirJugadorModoCondicionalNoCumpleCondicion() {
    boolean _inscribite = this.jugador.inscribite(this.partido, this.tipoIncCondicional);
    Assert.assertFalse(_inscribite);
  }
  
  @Test
  public void inscribirJugadorModoEstandarListaMayor10ConUnSolidario() {
    boolean _inscribite = this.jugador.inscribite(this.partido, this.tipoIncEstandar);
    Assert.assertTrue(_inscribite);
  }
  
  @Test
  public void inscribirJugadorModoEstandarListaMayor10ConMasSolidario() {
    boolean _inscribite = this.jugador.inscribite(this.partido, this.tipoIncEstandar);
    Assert.assertTrue(_inscribite);
  }
}
