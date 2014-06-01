package partido.decorators;

import partido.core.Jugador;
import partido.decorators.PartidoDecorator;
import partido.decorators.PartidoInterface;
import partido.mailSender.Notificador;
import partido.nuevosJugadores.Administrador;

@SuppressWarnings("all")
public class PartidoConfirmadoDecorator extends PartidoDecorator {
  private Notificador sender;
  
  public PartidoConfirmadoDecorator(final PartidoInterface decorado, final Notificador send) {
    super(decorado);
    this.sender = send;
  }
  
  public void confirmarJugador(final Jugador jugador) {
    super.confirmarJugador(jugador);
    boolean _estasConfirmado = super.estasConfirmado();
    if (_estasConfirmado) {
      Administrador _administrador = super.getAdministrador();
      String _mail = _administrador.getMail();
      this.sender.notificar(_mail, "Partido completo");
    }
  }
}
