package utn.edu.dds.TP_OPF5_Decorator;

import java.util.ArrayList;
import java.util.List;
import utn.edu.dds.TP_OPF5_Decorator.Jugador;
import utn.edu.dds.TP_OPF5_Decorator.Notificador;
import utn.edu.dds.TP_OPF5_Decorator.PartidoInterface;
import utn.edu.dds.TP_OPF5_Decorator.TipoInscripcion;

@SuppressWarnings("all")
public class PartidoConfirmadoDecorator implements PartidoInterface {
  private PartidoInterface decorado;
  
  private List<Jugador> _confirmados;
  
  public List<Jugador> getConfirmados() {
    return this._confirmados;
  }
  
  public void setConfirmados(final List<Jugador> confirmados) {
    this._confirmados = confirmados;
  }
  
  public PartidoConfirmadoDecorator(final PartidoInterface p) {
    this.decorado = p;
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    this.setConfirmados(_arrayList);
  }
  
  public void darBajaA(final Jugador jug) {
    this.decorado.darBajaA(jug);
    boolean _hayLugar = this.hayLugar();
    boolean _not = (!_hayLugar);
    if (_not) {
      Notificador _notificador = this.getNotificador();
      Jugador _administrador = this.getAdministrador();
      String _mail = _administrador.getMail();
      _notificador.notificar(_mail, "Partido ya no completo");
    }
    List<Jugador> _confirmados = this.getConfirmados();
    _confirmados.remove(jug);
  }
  
  public void eliminarInscripcion(final Jugador jug) {
    this.decorado.eliminarInscripcion(jug);
  }
  
  public void darBajaA(final Jugador jugBaja, final Jugador jugReemplazo, final TipoInscripcion inscripcion) {
    this.decorado.darBajaA(jugBaja, jugReemplazo, inscripcion);
    List<Jugador> _confirmados = this.getConfirmados();
    _confirmados.remove(jugBaja);
    List<Jugador> _confirmados_1 = this.getConfirmados();
    _confirmados_1.add(jugReemplazo);
  }
  
  public void confirmarJugador(final Jugador jugador) {
    List<Jugador> _confirmados = this.getConfirmados();
    _confirmados.add(jugador);
    List<Jugador> _confirmados_1 = this.getConfirmados();
    int _size = _confirmados_1.size();
    int _maximoLista = this.decorado.getMaximoLista();
    boolean _equals = (_size == _maximoLista);
    if (_equals) {
      Notificador _notificador = this.getNotificador();
      Jugador _administrador = this.getAdministrador();
      String _mail = _administrador.getMail();
      _notificador.notificar(_mail, "Partido completo");
    }
  }
  
  public void agregarJugador(final Jugador jugador, final TipoInscripcion tipoIncripcion) {
    this.decorado.agregarJugador(jugador, tipoIncripcion);
  }
  
  public boolean hayLugar() {
    return this.decorado.hayLugar();
  }
  
  public boolean hayAlgunoQueDejaAnotar() {
    return this.decorado.hayAlgunoQueDejaAnotar();
  }
  
  public void sacarAlQueDejaAnotar() {
    this.decorado.sacarAlQueDejaAnotar();
  }
  
  public boolean estaInscripto(final Jugador jugador) {
    return this.decorado.estaInscripto(jugador);
  }
  
  public void agregarInfraccion(final Jugador jug) {
    this.decorado.agregarInfraccion(jug);
  }
  
  public void notificarAlta(final Jugador jugador) {
    this.decorado.notificarAlta(jugador);
  }
  
  public void notificarBaja(final Jugador jugador) {
    this.decorado.notificarBaja(jugador);
  }
  
  public int getMaximoLista() {
    return this.decorado.getMaximoLista();
  }
  
  public Notificador getNotificador() {
    return this.decorado.getNotificador();
  }
  
  public Jugador getAdministrador() {
    return this.decorado.getAdministrador();
  }
}
