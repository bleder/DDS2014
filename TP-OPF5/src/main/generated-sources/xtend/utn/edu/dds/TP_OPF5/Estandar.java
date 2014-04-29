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
      if (_hayLugar) {
        partido.agregarJugador(jugador, this);
      } else {
        boolean _hayAlgunoQueDejaAnotar = partido.hayAlgunoQueDejaAnotar();
        if (_hayAlgunoQueDejaAnotar) {
          partido.agregarJugador(jugador, this);
          partido.sacarAlQueDejaAnotar();
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
      boolean _hayAlgunoQueDejaAnotar = partido.hayAlgunoQueDejaAnotar();
      _or = _hayAlgunoQueDejaAnotar;
    }
    return _or;
  }
  
  public boolean dejaAnotar() {
    return false;
  }
}
