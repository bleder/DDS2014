package utn.edu.dds.TP_OPF5.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;
import partido.core.Jugador;
import partido.core.Partido;
import partido.core.tiposDeInscripcion.Estandar;
import partido.mailSender.MailSender;
import partido.observers.AmigosObserver;
import partido.observers.PartidoConfirmadoObserver;

@SuppressWarnings("all")
public class TstNotificacion {
  private Jugador jugador;
  
  private Partido partido;
  
  private Estandar tipoIncEstandar;
  
  private MailSender mockMailSender;
  
  @Before
  public void init() {
    Jugador _jugador = new Jugador("Rodolfo", "rodol@aol.com");
    this.jugador = _jugador;
    Jugador administrador = new Jugador("Juan Administrador", "admin@aol.com");
    administrador.setMail("juan.administrador@aol.com");
    MailSender _mailSender = new MailSender();
    Partido _partido = new Partido("Partido_1", _mailSender, administrador);
    this.partido = _partido;
    Estandar _estandar = new Estandar();
    this.tipoIncEstandar = _estandar;
    MailSender _mock = Mockito.<MailSender>mock(MailSender.class);
    this.mockMailSender = _mock;
  }
  
  @Test
  public void notificaAlAdministradorJugadoresNecesariosParaPartidoConfirmados() {
    PartidoConfirmadoObserver partObse = new PartidoConfirmadoObserver(this.mockMailSender);
    this.partido.agregarObserver(partObse);
    this.partido.setMaximoLista(1);
    this.partido.agregarJugador(this.jugador, this.tipoIncEstandar);
    this.partido.confirmarJugador(this.jugador);
    VerificationMode _times = Mockito.times(1);
    MailSender _verify = Mockito.<MailSender>verify(this.mockMailSender, _times);
    Jugador _administrador = this.partido.getAdministrador();
    String _mail = _administrador.getMail();
    _verify.notificar(_mail, "Partido completo");
  }
  
  @Test
  public void notificaAlAdministradorDejaDeTenerJugadoresNecesariosParaPartidoConfirmados() {
    PartidoConfirmadoObserver partObse = new PartidoConfirmadoObserver(this.mockMailSender);
    this.partido.agregarObserver(partObse);
    this.partido.setMaximoLista(1);
    this.partido.agregarJugador(this.jugador, this.tipoIncEstandar);
    this.partido.confirmarJugador(this.jugador);
    this.partido.darBajaA(this.jugador);
    VerificationMode _times = Mockito.times(1);
    MailSender _verify = Mockito.<MailSender>verify(this.mockMailSender, _times);
    Jugador _administrador = this.partido.getAdministrador();
    String _mail = _administrador.getMail();
    _verify.notificar(_mail, "Partido completo");
    VerificationMode _times_1 = Mockito.times(1);
    MailSender _verify_1 = Mockito.<MailSender>verify(this.mockMailSender, _times_1);
    Jugador _administrador_1 = this.partido.getAdministrador();
    String _mail_1 = _administrador_1.getMail();
    _verify_1.notificar(_mail_1, "Partido ya no completo");
  }
  
  @Test
  public void partidoNoConfirmadoCuandoEstaVacio() {
    boolean _estasConfirmado = this.partido.estasConfirmado();
    Assert.assertFalse(_estasConfirmado);
  }
  
  @Test
  public void notificaAmigosDeJugadorAlInscribirse() {
    AmigosObserver amigo = new AmigosObserver(this.mockMailSender);
    Jugador _jugador = new Jugador("Ricardo", "ricky@aol.com");
    this.jugador.agregarAmigo(_jugador);
    this.partido.agregarObserver(amigo);
    this.jugador.inscribite(this.partido, this.tipoIncEstandar);
    VerificationMode _times = Mockito.times(1);
    MailSender _verify = Mockito.<MailSender>verify(this.mockMailSender, _times);
    _verify.notificar("ricky@aol.com", "Se inscribio tu amigo Rodolfo");
  }
  
  @Test
  public void jugadorSeDaDeBajaPartidoNoCompleto() {
    PartidoConfirmadoObserver partObse = new PartidoConfirmadoObserver(this.mockMailSender);
    this.partido.setMaximoLista(2);
    this.partido.agregarObserver(partObse);
    this.partido.agregarJugador(this.jugador, this.tipoIncEstandar);
    this.partido.confirmarJugador(this.jugador);
    this.partido.darBajaA(this.jugador);
    VerificationMode _times = Mockito.times(0);
    MailSender _verify = Mockito.<MailSender>verify(this.mockMailSender, _times);
    Jugador _administrador = this.partido.getAdministrador();
    String _mail = _administrador.getMail();
    _verify.notificar(_mail, "Partido completo");
    VerificationMode _times_1 = Mockito.times(0);
    MailSender _verify_1 = Mockito.<MailSender>verify(this.mockMailSender, _times_1);
    Jugador _administrador_1 = this.partido.getAdministrador();
    String _mail_1 = _administrador_1.getMail();
    _verify_1.notificar(_mail_1, "Partido ya no completo");
  }
}
