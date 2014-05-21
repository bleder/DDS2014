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
public class PartidoConfirmadoObserver implements PartidoObserver {
  private List<Jugador> _confirmados;
  
  public List<Jugador> getConfirmados() {
    return this._confirmados;
  }
  
  public void setConfirmados(final List<Jugador> confirmados) {
    this._confirmados = confirmados;
  }
  
  public PartidoConfirmadoObserver() {
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    this.setConfirmados(_arrayList);
  }
  
  public void notifyConfirmacion(final Jugador jugador, final Partido partido) {
    List<Jugador> _confirmados = this.getConfirmados();
    _confirmados.add(jugador);
    List<Jugador> _confirmados_1 = this.getConfirmados();
    int _size = _confirmados_1.size();
    int _maximoLista = partido.getMaximoLista();
    boolean _equals = (_size == _maximoLista);
    if (_equals) {
      this.notificarAdmin(partido, "Partido completo");
    }
  }
  
  public void notifyBajaInscripcion(final Jugador jugador, final Partido partido) {
    boolean _and = false;
    List<Jugador> _confirmados = this.getConfirmados();
    int _size = _confirmados.size();
    int _maximoLista = partido.getMaximoLista();
    boolean _equals = (_size == _maximoLista);
    if (!_equals) {
      _and = false;
    } else {
      List<Jugador> _confirmados_1 = this.getConfirmados();
      final Function1<Jugador,Boolean> _function = new Function1<Jugador,Boolean>() {
        public Boolean apply(final Jugador jug) {
          return Boolean.valueOf(Objects.equal(jug, jugador));
        }
      };
      boolean _exists = IterableExtensions.<Jugador>exists(_confirmados_1, _function);
      _and = _exists;
    }
    if (_and) {
      this.notificarAdmin(partido, "Partido ya no completo");
      List<Jugador> _confirmados_2 = this.getConfirmados();
      _confirmados_2.remove(jugador);
    }
  }
  
  public void notifyAltaInscripcion(final Jugador jugador, final Partido partido) {
  }
  
  public void notificarAdmin(final Partido partido, final String mensaje) {
    Notificador _notificador = partido.getNotificador();
    Jugador _administrador = partido.getAdministrador();
    String _mail = _administrador.getMail();
    _notificador.notificar(_mail, mensaje);
  }
}
