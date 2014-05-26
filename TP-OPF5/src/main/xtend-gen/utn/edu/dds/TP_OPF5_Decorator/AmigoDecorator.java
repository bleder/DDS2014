package utn.edu.dds.TP_OPF5_Decorator;

import utn.edu.dds.TP_OPF5_Decorator.Jugador;
import utn.edu.dds.TP_OPF5_Decorator.Notificador;
import utn.edu.dds.TP_OPF5_Decorator.PartidoInterface;

@SuppressWarnings("all")
public class AmigoDecorator implements PartidoInterface {
  private PartidoInterface decorado;
  
  private Notificador sender;
  
  public AmigoDecorator(final PartidoInterface p, final Jugador jugador, final String miMail) {
    this.decorado = p;
  }
  
  public void confirmarJugador(final partido.core.Jugador jugador) {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from Jugador to Jugador");
  }
}
