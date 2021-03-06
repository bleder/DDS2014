package ar.edu.utn.frba.TP.OPF5.Incripciones;

import ar.edu.utn.frba.TP.OPF5.Incripciones.TipoInscripcion;
import ar.edu.utn.frba.TP.OPF5.Jugador;
import ar.edu.utn.frba.TP.OPF5.Partido;

@SuppressWarnings("all")
public class Estandar extends TipoInscripcion {
  public void inscribir(final Jugador jugador, final Partido partido) {
    partido.inscribirA(jugador);
  }
}
