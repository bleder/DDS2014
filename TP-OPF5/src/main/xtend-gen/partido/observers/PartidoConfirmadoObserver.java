package partido.observers;

import partido.core.Jugador;
import partido.core.Partido;
import partido.mailSender.Notificador;
import partido.nuevosJugadores.Administrador;
import partido.observers.PartidoObserver;

@SuppressWarnings("all")
public class PartidoConfirmadoObserver implements PartidoObserver {
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
    int _cantidadConfirmados = partido.cantidadConfirmados();
    int __maximoLista = partido.get_maximoLista();
    int _minus = (__maximoLista - 1);
    boolean _equals = (_cantidadConfirmados == _minus);
    if (_equals) {
      this.notificarAdmin(partido, "Partido ya no completo");
    }
  }
  
  public void jugadorInscripto(final Jugador jugador, final Partido partido) {
  }
  
  public void notificarAdmin(final Partido partido, final String mensaje) {
    Administrador _administrador = partido.getAdministrador();
    String _mail = _administrador.getMail();
    this.sender.notificar(_mail, mensaje);
  }
}
