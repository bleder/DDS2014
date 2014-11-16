package partido.observers;

import java.util.List;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import partido.core.Jugador;
import partido.core.Partido;
import partido.mailSender.Notificador;
import partido.observers.PartidoObserver;

@SuppressWarnings("all")
public class AmigosObserver implements PartidoObserver {
  private Notificador sender;
  
  public AmigosObserver(final Notificador send) {
    this.sender = send;
  }
  
  public void jugadorInscripto(final Jugador jugador, final Partido partido) {
    List<String> _amigos = jugador.getAmigos();
    final Procedure1<String> _function = new Procedure1<String>() {
      public void apply(final String amigo) {
        String __nombre = jugador.get_nombre();
        String _plus = ("Se inscribio tu amigo " + __nombre);
        AmigosObserver.this.sender.notificar(amigo, _plus);
      }
    };
    IterableExtensions.<String>forEach(_amigos, _function);
  }
  
  public void jugadorDadoDeBaja(final Jugador jugador, final Partido partido) {
  }
  
  public void jugadorConfirmado(final Jugador jugador, final Partido partido) {
  }
}
