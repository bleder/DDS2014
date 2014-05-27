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
  
  public AmigosObserver(final String mails, final Notificador send) {
    this.sender = send;
  }
  
  public void jugadorInscripto(final Jugador jugador, final Partido partido) {
    List<Jugador> _amigos = jugador.getAmigos();
    final Procedure1<Jugador> _function = new Procedure1<Jugador>() {
      public void apply(final Jugador amigo) {
        String _mail = amigo.getMail();
        String _nombre = jugador.getNombre();
        String _plus = ("Se inscribio tu amigo " + _nombre);
        AmigosObserver.this.sender.notificar(_mail, _plus);
      }
    };
    IterableExtensions.<Jugador>forEach(_amigos, _function);
  }
  
  public void jugadorDadoDeBaja(final Jugador jugador, final Partido partido) {
  }
  
  public void jugadorConfirmado(final Jugador jugador, final Partido partido) {
  }
}
