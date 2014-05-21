package utn.edu.dds.TP_OPF5.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;
import utn.edu.dds.TP_OPF5.AmigosObserver;
import utn.edu.dds.TP_OPF5.Estandar;
import utn.edu.dds.TP_OPF5.Jugador;
import utn.edu.dds.TP_OPF5.MailSender;
import utn.edu.dds.TP_OPF5.Partido;
import utn.edu.dds.TP_OPF5.PartidoConfirmadoObserver;

@SuppressWarnings("all")
public class TstNotificacion {
  private Jugador jugador;
  
  private Partido partido;
  
  private Estandar tipoIncEstandar;
  
  private MailSender mockMailSender;
  
  @Before
  public void init() {
    Jugador _jugador = new Jugador("Rodolfo");
    this.jugador = _jugador;
    Jugador administrador = new Jugador("Juan Administrador");
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
    PartidoConfirmadoObserver partObse = new PartidoConfirmadoObserver();
    this.partido.setNotificador(this.mockMailSender);
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
    PartidoConfirmadoObserver partObse = new PartidoConfirmadoObserver();
    this.partido.setNotificador(this.mockMailSender);
    this.partido.agregarObserver(partObse);
    this.partido.setMaximoLista(1);
    this.partido.agregarJugador(this.jugador, this.tipoIncEstandar);
    this.partido.confirmarJugador(this.jugador);
    this.partido.darBajaA(this.jugador);
    VerificationMode _times = Mockito.times(1);
    MailSender _verify = Mockito.<MailSender>verify(this.mockMailSender, _times);
    Jugador _administrador = this.partido.getAdministrador();
    String _mail = _administrador.getMail();
    _verify.notificar(_mail, "Partido ya no completo");
  }
  
  @Test
  public void notificaAmigosDeJugadorAlInscribirse() {
    this.partido.setNotificador(this.mockMailSender);
    AmigosObserver amigo = new AmigosObserver("amigo@aol.com", this.mockMailSender);
    amigo.agregarAmigo(this.jugador);
    this.partido.agregarObserver(amigo);
    this.jugador.inscribite(this.partido, this.tipoIncEstandar);
    VerificationMode _times = Mockito.times(1);
    MailSender _verify = Mockito.<MailSender>verify(this.mockMailSender, _times);
    _verify.notificar("amigo@aol.com", "Tu amigo se inscribio");
  }
}
