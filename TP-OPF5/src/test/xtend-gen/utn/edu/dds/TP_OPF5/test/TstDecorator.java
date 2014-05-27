package utn.edu.dds.TP_OPF5.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;
import partido.core.Jugador;
import partido.core.tiposDeInscripcion.Estandar;
import partido.decorators.AmigosDecorator;
import partido.decorators.Partido;
import partido.decorators.PartidoConfirmadoDecorator;
import partido.decorators.PartidoEstabaConfirmado;
import partido.mailSender.MailSender;

@SuppressWarnings("all")
public class TstDecorator {
  private Jugador jugador;
  
  private Partido partido;
  
  private Estandar inscripcion;
  
  private MailSender mockMailSender;
  
  @Before
  public void init() {
    Jugador _jugador = new Jugador("Rodolfo", "rodol@aol.com");
    this.jugador = _jugador;
    MailSender _mailSender = new MailSender();
    Jugador _jugador_1 = new Jugador("Juan Administra", "admin@aol.com");
    Partido _partido = new Partido("Partido_1", _mailSender, _jugador_1);
    this.partido = _partido;
    Estandar _estandar = new Estandar();
    this.inscripcion = _estandar;
    MailSender _mock = Mockito.<MailSender>mock(MailSender.class);
    this.mockMailSender = _mock;
  }
  
  @Test
  public void notificaAlAdministradorJugadoresNecesariosParaPartidoConfirmados() {
    this.partido.setMaximoLista(1);
    PartidoConfirmadoDecorator partDecorado = new PartidoConfirmadoDecorator(this.partido, this.mockMailSender);
    partDecorado.agregarJugador(this.jugador, this.inscripcion);
    partDecorado.confirmarJugador(this.jugador);
    VerificationMode _times = Mockito.times(1);
    MailSender _verify = Mockito.<MailSender>verify(this.mockMailSender, _times);
    Jugador _administrador = this.partido.getAdministrador();
    String _mail = _administrador.getMail();
    _verify.notificar(_mail, "Partido completo");
  }
  
  @Test
  public void notificaAlAdministradorDejaDeTenerJugadoresNecesariosParaPartidoConfirmados() {
    this.partido.setMaximoLista(1);
    PartidoEstabaConfirmado partDecorado = new PartidoEstabaConfirmado(this.partido, this.mockMailSender);
    partDecorado.agregarJugador(this.jugador, this.inscripcion);
    partDecorado.confirmarJugador(this.jugador);
    partDecorado.darBajaA(this.jugador);
    VerificationMode _times = Mockito.times(1);
    MailSender _verify = Mockito.<MailSender>verify(this.mockMailSender, _times);
    Jugador _administrador = this.partido.getAdministrador();
    String _mail = _administrador.getMail();
    _verify.notificar(_mail, "Partido ya no completo");
  }
  
  @Test
  public void partidoNoConfirmadoCuandoEstaVacio() {
    boolean _estasConfirmado = this.partido.estasConfirmado();
    Assert.assertFalse(_estasConfirmado);
  }
  
  @Test
  public void notificaAmigosDeJugadorAlInscribirse() {
    AmigosDecorator partDecorado = new AmigosDecorator(this.partido, this.mockMailSender);
    Jugador _jugador = new Jugador("Ricardo", "ricky@aol.com");
    this.jugador.agregarAmigo(_jugador);
    partDecorado.agregarJugador(this.jugador, this.inscripcion);
    VerificationMode _times = Mockito.times(1);
    MailSender _verify = Mockito.<MailSender>verify(this.mockMailSender, _times);
    _verify.notificar("ricky@aol.com", "Se inscribio tu amigo Rodolfo");
  }
}
