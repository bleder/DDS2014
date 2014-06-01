package partido.decorators;

import java.util.List;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import partido.core.Jugador;
import partido.core.tiposDeInscripcion.TipoInscripcion;
import partido.decorators.PartidoDecorator;
import partido.decorators.PartidoInterface;
import partido.mailSender.Notificador;

@SuppressWarnings("all")
public class AmigosDecorator extends PartidoDecorator {
  private Notificador sender;
  
  public AmigosDecorator(final PartidoInterface decorado, final Notificador send) {
    super(decorado);
    this.sender = send;
  }
  
  public void agregarJugador(final Jugador jugador, final TipoInscripcion inscripcion) {
    super.agregarJugador(jugador, inscripcion);
    List<String> _amigos = jugador.getAmigos();
    final Procedure1<String> _function = new Procedure1<String>() {
      public void apply(final String amigo) {
        String _nombre = jugador.getNombre();
        String _plus = ("Se inscribio tu amigo " + _nombre);
        AmigosDecorator.this.sender.notificar(amigo, _plus);
      }
    };
    IterableExtensions.<String>forEach(_amigos, _function);
  }
}
