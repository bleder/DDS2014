package partido.observers;

import partido.core.Jugador;
import partido.core.Partido;
import partido.mailSender.Notificador;
import partido.observers.PartidoObserver;

@SuppressWarnings("all")
public class PartidoConfirmadoObserver implements /* Object */PartidoObserver {
  private Notificador sender;
  
  public PartidoConfirmadoObserver(final Notificador send) {
    this.sender = send;
  }
  
  public void jugadorConfirmado(final Jugador jugador, final Partido partido) {
    boolean _estasConfirmado = partido.estasConfirmado();
    if (_estasConfirmado) {
      this.notificarAdmin(partido, "Partido completo");
    }
  }
  
  public void jugadorDadoDeBaja(final Jugador jugador, final Partido partido) {
    throw new Error("Unresolved compilation problems:"
      + "\n- cannot be resolved."
      + "\nThe field maximoLista is not visible"
      + "\n== cannot be resolved");
  }
  
  public void jugadorInscripto(final Jugador jugador, final Partido partido) {
  }
  
  public void notificarAdmin(final Partido partido, final /* String */Object mensaje) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field administrador is not visible"
      + "\nThe field mail is not visible");
  }
}
