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
import partido.nuevosJugadores.Administrador;

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
    Administrador _administrador = new Administrador("admin@aol.com");
    Partido _partido = new Partido("Partido_1", _mailSender, _administrador);
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
    Administrador _administrador = this.partido.getAdministrador();
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
    Administrador _administrador = this.partido.getAdministrador();
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
    this.jugador.agregarAmigo("ricky@aol.com");
    partDecorado.agregarJugador(this.jugador, this.inscripcion);
    VerificationMode _times = Mockito.times(1);
    MailSender _verify = Mockito.<MailSender>verify(this.mockMailSender, _times);
    _verify.notificar("ricky@aol.com", "Se inscribio tu amigo Rodolfo");
  }
  
  @Test
  public void jugadorSeDaDeBajaPartidoNoCompleto() {
    PartidoEstabaConfirmado partDecorado = new PartidoEstabaConfirmado(this.partido, this.mockMailSender);
    this.partido.setMaximoLista(2);
    partDecorado.agregarJugador(this.jugador, this.inscripcion);
    partDecorado.confirmarJugador(this.jugador);
    partDecorado.darBajaA(this.jugador);
    VerificationMode _times = Mockito.times(0);
    MailSender _verify = Mockito.<MailSender>verify(this.mockMailSender, _times);
    Administrador _administrador = partDecorado.getAdministrador();
    String _mail = _administrador.getMail();
    _verify.notificar(_mail, "Partido completo");
    VerificationMode _times_1 = Mockito.times(0);
    MailSender _verify_1 = Mockito.<MailSender>verify(this.mockMailSender, _times_1);
    Administrador _administrador_1 = partDecorado.getAdministrador();
    String _mail_1 = _administrador_1.getMail();
    _verify_1.notificar(_mail_1, "Partido ya no completo");
  }
}
