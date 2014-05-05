package utn.edu.dds.TP_OPF5;

import org.eclipse.xtext.xbase.lib.Exceptions;
import utn.edu.dds.TP_OPF5.Jugador;
import utn.edu.dds.TP_OPF5.Partido;
import utn.edu.dds.TP_OPF5.TipoInscripcion;
import utn.edu.dds.TP_OPF5.exception.PartidoCompletoExcepcion;

@SuppressWarnings("all")
public class Estandar implements TipoInscripcion {
  public void inscribirA(final Jugador jugador, final Partido partido) {
    try {
      boolean _hayLugar = partido.hayLugar();
      boolean _not = (!_hayLugar);
      if (_not) {
        throw new PartidoCompletoExcepcion("Lista llena, no hay lugar para mas inscripciones");
      }
      partido.agregarJugador(jugador, this);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public boolean dejaAnotar() {
    return false;
  }
}
