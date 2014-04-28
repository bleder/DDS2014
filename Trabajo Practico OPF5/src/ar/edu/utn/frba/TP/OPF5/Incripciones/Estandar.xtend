package ar.edu.utn.frba.TP.OPF5.Incripciones

import ar.edu.utn.frba.TP.OPF5.Jugador
import ar.edu.utn.frba.TP.OPF5.Partido

class Estandar extends TipoInscripcion {
	override inscribir(Jugador jugador, Partido partido) {
		partido.inscribirA(jugador)
	}
}