package partido.observers;

import partido.core.Jugador;
import partido.core.Partido;
import partido.mailSender.Notificador;
import partido.observers.PartidoObserver;

@SuppressWarnings("all")
public class AmigosObserver implements /* Object */PartidoObserver {
  private Notificador sender;
  
  public AmigosObserver(final Notificador send) {
    this.sender = send;
  }
  
  public void jugadorInscripto(final Jugador jugador, final Partido partido) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getAmigos is undefined for the type AmigosObserver"
      + "\nThe field nombre is not visible"
      + "\nforEach cannot be resolved"
      + "\n+ cannot be resolved");
  }
  
  public void jugadorDadoDeBaja(final Jugador jugador, final Partido partido) {
  }
  
  public void jugadorConfirmado(final Jugador jugador, final Partido partido) {
  }
}
