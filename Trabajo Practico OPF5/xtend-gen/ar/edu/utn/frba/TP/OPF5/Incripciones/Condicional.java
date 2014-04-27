package ar.edu.utn.frba.TP.OPF5.Incripciones;

import ar.edu.utn.frba.TP.OPF5.Incripciones.Condicion;
import ar.edu.utn.frba.TP.OPF5.Incripciones.TipoDeInscripcion;
import ar.edu.utn.frba.TP.OPF5.Jugador;
import ar.edu.utn.frba.TP.OPF5.Partido;
import ar.edu.utn.frba.TP.OPF5.excepcion.PartidoNoCumpleCondicionesExcepcion;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class Condicional extends TipoDeInscripcion {
  private Condicion _condicion;
  
  public Condicion getCondicion() {
    return this._condicion;
  }
  
  public void setCondicion(final Condicion condicion) {
    this._condicion = condicion;
  }
  
  public void inscribirA(final Jugador jugador, final Partido partido) {
    try {
      Condicion _condicion = this.getCondicion();
      boolean _puedeInscribirseA = _condicion.puedeInscribirseA(partido);
      if (_puedeInscribirseA) {
        partido.agregarUnJugador(jugador);
      } else {
        throw new PartidoNoCumpleCondicionesExcepcion("El partido no cumple la condicion impuesta por el jugador");
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
