package partido.core;

import com.google.common.base.Objects;
import partido.core.Jugador;
import partido.core.tiposDeInscripcion.TipoInscripcion;

@SuppressWarnings("all")
public class Inscripcion {
  /**
   * @Property
   */
  private int id_inscripcion;
  
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
  
  /**
   * @Property
   */
  private boolean estaConfirmada;
  
  public Inscripcion() {
  }
  
  public Inscripcion(final Jugador jug, final TipoInscripcion tipoIncrip) {
    this.setTipoInscripcion(tipoIncrip);
    this.setJugador(jug);
    this.estaConfirmada = false;
  }
  
  public boolean sosInscripcionDe(final Jugador otroJugador) {
    Jugador _jugador = this.getJugador();
    return Objects.equal(otroJugador, _jugador);
  }
  
  public boolean confirmar() {
    return this.estaConfirmada = true;
  }
  
  public int setId_inscripcion(final int id_inscripcion) {
    return this.id_inscripcion = id_inscripcion;
  }
  
  public int getId_inscripcion() {
    return this.id_inscripcion;
  }
  
  public boolean setEstaConfirmada(final Boolean estaConfirmada) {
    return this.estaConfirmada = (estaConfirmada).booleanValue();
  }
  
  public boolean getEstaConfirmada() {
    return this.estaConfirmada;
  }
}
