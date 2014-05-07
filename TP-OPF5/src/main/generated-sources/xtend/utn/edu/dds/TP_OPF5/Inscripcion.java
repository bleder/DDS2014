package utn.edu.dds.TP_OPF5;

import com.google.common.base.Objects;
import utn.edu.dds.TP_OPF5.Jugador;
import utn.edu.dds.TP_OPF5.TipoInscripcion;

@SuppressWarnings("all")
public class Inscripcion {
  private TipoInscripcion _tipoInscripcion;
  
  public TipoInscripcion getTipoInscripcion() {
    return this._tipoInscripcion;
  }
  
  public void setTipoInscripcion(final TipoInscripcion tipoInscripcion) {
    this._tipoInscripcion = tipoInscripcion;
  }
  
  private Jugador jugador;
  
  public Inscripcion(final Jugador jug, final TipoInscripcion tipoIncrip) {
    this.setTipoInscripcion(tipoIncrip);
    this.jugador = this.jugador;
  }
  
  public boolean sosInscripcionDe(final Jugador otroJugador) {
    return Objects.equal(otroJugador, this.jugador);
  }
}
