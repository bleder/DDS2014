package utn.edu.dds.TP_OPF5;

import org.eclipse.xtext.xbase.lib.Exceptions;
import utn.edu.dds.TP_OPF5.Jugador;
import utn.edu.dds.TP_OPF5.Partido;
import utn.edu.dds.TP_OPF5.TipoInscripcion;
import utn.edu.dds.TP_OPF5.exception.PartidoCompletoExcepcion;
import utn.edu.dds.TP_OPF5.exception.PartidoNoCumpleCondicionesExcepcion;

@SuppressWarnings("all")
public class Condicional implements TipoInscripcion {
  private boolean _condicion = true;
  
  public boolean isCondicion() {
    return this._condicion;
  }
  
  public void setCondicion(final boolean condicion) {
    this._condicion = condicion;
  }
  
  public void inscribirA(final Jugador jugador, final Partido partido) {
    try {
      boolean _hayLugar = partido.hayLugar();
      boolean _not = (!_hayLugar);
      if (_not) {
        throw new PartidoCompletoExcepcion("No se puede inscribir porque no hay lugar");
      }
      boolean _isCondicion = this.isCondicion();
      boolean _not_1 = (!_isCondicion);
      if (_not_1) {
        throw new PartidoNoCumpleCondicionesExcepcion("El partido no cumple la condicion impuesta por el jugador");
      }
      partido.agregarJugador(jugador, this);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public boolean dejaAnotar() {
    return true;
  }
}
