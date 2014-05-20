package utn.edu.dds.TP_OPF5_Observer;

import java.util.List;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import utn.edu.dds.TP_OPF5_Observer.Inscripcion;
import utn.edu.dds.TP_OPF5_Observer.Jugador;
import utn.edu.dds.TP_OPF5_Observer.Notificador;
import utn.edu.dds.TP_OPF5_Observer.Partido;
import utn.edu.dds.TP_OPF5_Observer.PartidoObserver;

@SuppressWarnings("all")
public class AmigosObserver implements PartidoObserver {
  public void notifyAltaInscripcion(final Inscripcion inscripcion, final Partido partido) {
    Jugador _jugador = inscripcion.getJugador();
    List<Jugador> _amigosJugador = _jugador.getAmigosJugador();
    final Procedure1<Jugador> _function = new Procedure1<Jugador>() {
      public void apply(final Jugador amigo) {
        AmigosObserver.this.notificarAmigo(amigo, partido);
      }
    };
    IterableExtensions.<Jugador>forEach(_amigosJugador, _function);
  }
  
  public void notifyBajaInscripcion(final Inscripcion inscripcion, final Partido partido) {
  }
  
  public void notifyConfirmacion(final Jugador jugador, final Partido partido) {
  }
  
  public void notificarAmigo(final Jugador amigo, final Partido partido) {
    Notificador _notificador = partido.getNotificador();
    String _mail = amigo.getMail();
    _notificador.notificar(_mail);
  }
}
