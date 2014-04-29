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
      if (_hayLugar) {
        boolean _isCondicion = this.isCondicion();
        if (_isCondicion) {
          partido.agregarJugador(jugador, this);
        } else {
          throw new PartidoNoCumpleCondicionesExcepcion("El partido no cumple la condicion impuesta por el jugador");
        }
      } else {
        throw new PartidoCompletoExcepcion("Lista llena, no hay lugar para mas inscripciones");
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public boolean sePuedeInscribir(final Partido partido) {
    return partido.hayLugar();
  }
  
  public boolean dejaAnotar() {
    return true;
  }
}
