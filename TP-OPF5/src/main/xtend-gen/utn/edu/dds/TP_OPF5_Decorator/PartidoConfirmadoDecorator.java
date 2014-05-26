package utn.edu.dds.TP_OPF5_Decorator;

import utn.edu.dds.TP_OPF5_Decorator.Jugador;
import utn.edu.dds.TP_OPF5_Decorator.Notificador;
import utn.edu.dds.TP_OPF5_Decorator.PartidoInterface;

/**
 * Este decorador notifica cuando confirmamos todos los jugadores
 */
@SuppressWarnings("all")
public class PartidoConfirmadoDecorator implements PartidoInterface {
  private PartidoInterface decorado;
  
  public PartidoConfirmadoDecorator(final PartidoInterface p) {
    this.decorado = p;
  }
  
  public void confirmarJugador(final Jugador jugador) {
    this.decorado.confirmarJugador(jugador);
    Boolean _estasConfirmado = this.estasConfirmado();
    if ((_estasConfirmado).booleanValue()) {
      Notificador _notificador = this.getNotificador();
      Jugador _administrador = this.getAdministrador();
      String _mail = _administrador.getMail();
      _notificador.notificar(_mail, "Partido completo");
    }
  }
}
