package utn.edu.dds.TP_OPF5_Decorator;

import com.google.common.base.Objects;
import utn.edu.dds.TP_OPF5_Decorator.Jugador;
import utn.edu.dds.TP_OPF5_Decorator.Notificador;
import utn.edu.dds.TP_OPF5_Decorator.PartidoInterface;
import utn.edu.dds.TP_OPF5_Decorator.TipoInscripcion;

@SuppressWarnings("all")
public class AmigoDecorator implements PartidoInterface {
  private PartidoInterface decorado;
  
  private Jugador amigo;
  
  private String mail;
  
  public AmigoDecorator(final PartidoInterface p, final Jugador jugador, final String miMail) {
    this.decorado = p;
    this.amigo = jugador;
    this.mail = miMail;
  }
  
  public void darBajaA(final Jugador jug) {
    this.decorado.darBajaA(jug);
  }
  
  public void eliminarInscripcion(final Jugador jug) {
    this.decorado.eliminarInscripcion(jug);
  }
  
  public void darBajaA(final Jugador jugBaja, final Jugador jugReemplazo, final TipoInscripcion inscripcion) {
    this.decorado.darBajaA(jugBaja, jugReemplazo, inscripcion);
  }
  
  public void confirmarJugador(final Jugador jugador) {
    this.decorado.confirmarJugador(jugador);
  }
  
  public void agregarJugador(final Jugador jugador, final TipoInscripcion tipoIncripcion) {
    this.decorado.agregarJugador(jugador, tipoIncripcion);
    boolean _equals = Objects.equal(this.amigo, jugador);
    if (_equals) {
      Notificador _notificador = this.decorado.getNotificador();
      _notificador.notificar(this.mail, "Tu amigo se inscribio");
    }
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
