package partido.decorators;

import partido.core.Jugador;
import partido.decorators.PartidoDecorator;
import partido.decorators.PartidoInterface;
import partido.mailSender.Notificador;
import partido.nuevosJugadores.Administrador;

@SuppressWarnings("all")
public class PartidoEstabaConfirmado extends PartidoDecorator {
  private Notificador sender;
  
  public PartidoEstabaConfirmado(final PartidoInterface decorado, final Notificador send) {
    super(decorado);
    this.sender = send;
  }
  
  public void darBajaA(final Jugador jugador) {
    final boolean debeNotificar = super.estasConfirmado();
    super.darBajaA(jugador);
    if (debeNotificar) {
      Administrador _administrador = super.getAdministrador();
      String _mail = _administrador.getMail();
      this.sender.notificar(_mail, "Partido ya no completo");
    }
  }
}
