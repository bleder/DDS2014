package utn.edu.dds.TP_OPF5;

import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import utn.edu.dds.TP_OPF5.Jugador;
import utn.edu.dds.TP_OPF5.Partido;
import utn.edu.dds.TP_OPF5.TipoInscripcion;
import utn.edu.dds.TP_OPF5.exception.PartidoNoCumpleCondicionesExcepcion;

@SuppressWarnings("all")
public class Condicional implements TipoInscripcion {
  private Function1<Partido,Boolean> _condicion = new Function1<Partido,Boolean>() {
    public Boolean apply(final Partido partido) {
      return Boolean.valueOf(true);
    }
  };
  
  public Function1<Partido,Boolean> getCondicion() {
    return this._condicion;
  }
  
  public void setCondicion(final Function1<Partido,Boolean> condicion) {
    this._condicion = condicion;
  }
  
  public void inscribirA(final Jugador jugador, final Partido partido) {
    try {
      Function1<Partido,Boolean> _condicion = this.getCondicion();
      Boolean _apply = _condicion.apply(partido);
      if ((_apply).booleanValue()) {
        throw new PartidoNoCumpleCondicionesExcepcion("El partido no cumple la condicion impuesta por el jugador");
      }
      partido.agregarJugador(jugador, this);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public boolean tienePrioridad() {
    return false;
  }
  
  public boolean dejaAnotar() {
    return true;
  }
}
