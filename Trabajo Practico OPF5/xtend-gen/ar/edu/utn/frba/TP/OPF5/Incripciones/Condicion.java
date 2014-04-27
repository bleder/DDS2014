package ar.edu.utn.frba.TP.OPF5.Incripciones;

import ar.edu.utn.frba.TP.OPF5.Partido;

@SuppressWarnings("all")
public abstract class Condicion {
  public abstract boolean puedeInscribirseA(final Partido partido);
}
