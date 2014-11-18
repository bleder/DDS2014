package partido.core.tiposDeInscripcion;

import partido.core.Jugador;
import partido.core.Partido;
import partido.core.tiposDeInscripcion.TipoInscripcion;

@SuppressWarnings("all")
public class Solidaria implements TipoInscripcion {
  private int _id_tipo_incripcion;
  
  public int getId_tipo_incripcion() {
    return this._id_tipo_incripcion;
  }
  
  public void setId_tipo_incripcion(final int id_tipo_incripcion) {
    this._id_tipo_incripcion = id_tipo_incripcion;
  }
  
  public Solidaria() {
  }
  
  public void inscribirA(final Jugador jugador, final Partido partido) {
    partido.agregarJugador(jugador, this);
  }
  
  public boolean tienePrioridad() {
    return true;
  }
  
  public boolean dejaAnotar() {
    return true;
  }
  
  public void setId_tipo_inscripcion(final int id_tipo_inscripcion) {
    this.setId_tipo_incripcion(id_tipo_inscripcion);
  }
  
  public int getId_tipo_inscripcion() {
    return this.getId_tipo_incripcion();
  }
}
