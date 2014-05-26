package utn.edu.dds.TP_OPF5;

import java.util.ArrayList;
import java.util.List;
import utn.edu.dds.TP_OPF5.Notificador;
import utn.edu.dds.TP_OPF5.Partido;
import utn.edu.dds.TP_OPF5.PartidoObserver;

@SuppressWarnings("all")
public class AmigosObserver implements PartidoObserver {
  private /* List<Jugador> */Object amigos;
  
  private String mail;
  
  private Notificador sender;
  
  public AmigosObserver(final String mails, final Notificador send) {
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    this.amigos = _arrayList;
    this.mail = mails;
    this.sender = send;
  }
  
  public boolean agregarAmigo(final /* Jugador */Object jugador) {
    return this.amigos.add(jugador);
  }
  
  public void jugadorInscripto(final /* Jugador */Object jugador, final Partido partido) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method mail is undefined for the type AmigosObserver"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\namigos cannot be resolved"
      + "\nforEach cannot be resolved"
      + "\nnombre cannot be resolved");
  }
  
  public void jugadorDadoDeBaja(final /* Jugador */Object jugador, final Partido partido) {
  }
  
  public void jugadorConfirmado(final /* Jugador */Object jugador, final Partido partido) {
  }
}
