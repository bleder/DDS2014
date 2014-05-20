package utn.edu.dds.TP_OPF5_Observer;

import utn.edu.dds.TP_OPF5_Observer.Inscripcion;
import utn.edu.dds.TP_OPF5_Observer.Jugador;
import utn.edu.dds.TP_OPF5_Observer.Notificador;
import utn.edu.dds.TP_OPF5_Observer.Partido;
import utn.edu.dds.TP_OPF5_Observer.PartidoObserver;

@SuppressWarnings("all")
public class PartidoConfirmadoObserver implements PartidoObserver {
  private int _confirmados;
  
  public int getConfirmados() {
    return this._confirmados;
  }
  
  public void setConfirmados(final int confirmados) {
    this._confirmados = confirmados;
  }
  
  public PartidoConfirmadoObserver() {
    this.setConfirmados(0);
  }
  
  public void notifyConfirmacion(final Jugador jugador, final Partido partido) {
    int _confirmados = this.getConfirmados();
    int _plus = (_confirmados + 1);
    this.setConfirmados(_plus);
    int _confirmados_1 = this.getConfirmados();
    boolean _equals = (_confirmados_1 == 10);
    if (_equals) {
      this.notificarAdmin(partido);
    }
  }
  
  public void notifyBajaInscripcion(final Inscripcion inscripcion, final Partido partido) {
    int _confirmados = this.getConfirmados();
    boolean _equals = (_confirmados == 10);
    if (_equals) {
      this.notificarAdmin(partido);
    }
    int _confirmados_1 = this.getConfirmados();
    int _minus = (_confirmados_1 - 1);
    this.setConfirmados(_minus);
  }
  
  public void notifyAltaInscripcion(final Inscripcion inscripcion, final Partido partido) {
  }
  
  public void notificarAdmin(final Partido partido) {
    Notificador _notificador = partido.getNotificador();
    Jugador _administrador = partido.getAdministrador();
    String _mail = _administrador.getMail();
    _notificador.notificar(_mail);
  }
}
