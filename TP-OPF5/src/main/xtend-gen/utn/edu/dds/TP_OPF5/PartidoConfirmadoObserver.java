package utn.edu.dds.TP_OPF5;

import utn.edu.dds.TP_OPF5.Partido;
import utn.edu.dds.TP_OPF5.PartidoObserver;

@SuppressWarnings("all")
public class PartidoConfirmadoObserver implements PartidoObserver {
  public PartidoConfirmadoObserver() {
  }
  
  public void jugadorConfirmado(final /* Jugador */Object jugador, final Partido partido) {
    Boolean _estasConfirmado = partido.estasConfirmado();
    if ((_estasConfirmado).booleanValue()) {
      this.notificarAdmin(partido, "Partido completo");
    }
  }
  
  public void jugadorDadoDeBaja(final /* Jugador */Object jugador, final Partido partido) {
    Boolean _estasConfirmado = partido.estasConfirmado();
    boolean _not = (!(_estasConfirmado).booleanValue());
    if (_not) {
      this.notificarAdmin(partido, "Partido ya no completo");
    }
  }
  
  public void jugadorInscripto(final /* Jugador */Object jugador, final Partido partido) {
  }
  
  public void notificarAdmin(final Partido partido, final String mensaje) {
    throw new Error("Unresolved compilation problems:"
      + "\nmail cannot be resolved");
  }
}
