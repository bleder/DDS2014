package utn.edu.dds.TP_OPF5;

import org.eclipse.xtext.xbase.lib.Exceptions;
import utn.edu.dds.TP_OPF5.Jugador;
import utn.edu.dds.TP_OPF5.Partido;
import utn.edu.dds.TP_OPF5.TipoInscripcion;
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
      boolean _isCondicion = this.isCondicion();
      if (_isCondicion) {
        partido.inscribirA(jugador);
      } else {
        throw new PartidoNoCumpleCondicionesExcepcion("El partido no cumple la condicion impuesta por el jugador");
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
