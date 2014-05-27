package partido.core;

import com.google.common.base.Objects;
import partido.core.Jugador;
import partido.core.tiposDeInscripcion.TipoInscripcion;

@SuppressWarnings("all")
public class Inscripcion {
  private TipoInscripcion _tipoInscripcion;
  
  public TipoInscripcion getTipoInscripcion() {
    return this._tipoInscripcion;
  }
  
  public void setTipoInscripcion(final TipoInscripcion tipoInscripcion) {
    this._tipoInscripcion = tipoInscripcion;
  }
  
  private Jugador _jugador;
  
  public Jugador getJugador() {
    return this._jugador;
  }
  
  public void setJugador(final Jugador jugador) {
    this._jugador = jugador;
  }
  
  private boolean _estaConfirmada;
  
  public boolean isEstaConfirmada() {
    return this._estaConfirmada;
  }
  
  public void setEstaConfirmada(final boolean estaConfirmada) {
    this._estaConfirmada = estaConfirmada;
  }
  
  public Inscripcion(final Jugador jug, final TipoInscripcion tipoIncrip) {
    this.setTipoInscripcion(tipoIncrip);
    this.setJugador(jug);
    this.setEstaConfirmada(false);
  }
  
  public boolean sosInscripcionDe(final Jugador otroJugador) {
    Jugador _jugador = this.getJugador();
    return Objects.equal(otroJugador, _jugador);
  }
  
  public void confirmar() {
    this.setEstaConfirmada(true);
  }
}
