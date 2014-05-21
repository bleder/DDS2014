package utn.edu.dds.TP_OPF5;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import utn.edu.dds.TP_OPF5.Jugador;
import utn.edu.dds.TP_OPF5.Notificador;
import utn.edu.dds.TP_OPF5.Partido;
import utn.edu.dds.TP_OPF5.PartidoObserver;

@SuppressWarnings("all")
public class AmigosObserver implements PartidoObserver {
  private List<Jugador> amigos;
  
  private String mail;
  
  private Notificador sender;
  
  public AmigosObserver(final String mails, final Notificador send) {
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    this.amigos = _arrayList;
    this.mail = mails;
    this.sender = send;
  }
  
  public boolean agregarAmigo(final Jugador jugador) {
    return this.amigos.add(jugador);
  }
  
  public void notifyAltaInscripcion(final Jugador jugador, final Partido partido) {
    final Function1<Jugador,Boolean> _function = new Function1<Jugador,Boolean>() {
      public Boolean apply(final Jugador jug) {
        return Boolean.valueOf(Objects.equal(jug, jugador));
      }
    };
    boolean _exists = IterableExtensions.<Jugador>exists(this.amigos, _function);
    if (_exists) {
      this.notificarAmigo(jugador, partido);
    }
  }
  
  public void notifyBajaInscripcion(final Jugador jugador, final Partido partido) {
  }
  
  public void notifyConfirmacion(final Jugador jugador, final Partido partido) {
  }
  
  public void notificarAmigo(final Jugador amigo, final Partido partido) {
    this.sender.notificar(this.mail, "Tu amigo se inscribio");
  }
}
