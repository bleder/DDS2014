package ar.edu.utn.frba.TP.OPF5.Incripciones;

import ar.edu.utn.frba.TP.OPF5.Jugador;
import ar.edu.utn.frba.TP.OPF5.Partido;

@SuppressWarnings("all")
public abstract class TipoDeInscripcion {
  public void inscribirA(final Jugador jugador, final Partido partido) {
    partido.agregarUnJugador(jugador);
  }
}
