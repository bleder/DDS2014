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
      boolean _haySolidario = partido.haySolidario();
      if (_haySolidario) {
        partido.agregarJugador(jugador, this);
        partido.sacarSolidario();
      } else {
        boolean _hayLugar = partido.hayLugar();
        if (_hayLugar) {
          partido.agregarJugador(jugador, this);
        } else {
          throw new PartidoCompletoExcepcion("Lista llena, no hay lugar para mas inscripciones");
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public boolean sePuedeInscribir(final Partido partido) {
    boolean _or = false;
    boolean _hayLugar = partido.hayLugar();
    if (_hayLugar) {
      _or = true;
    } else {
      boolean _haySolidario = partido.haySolidario();
      _or = _haySolidario;
    }
    return _or;
  }
}
