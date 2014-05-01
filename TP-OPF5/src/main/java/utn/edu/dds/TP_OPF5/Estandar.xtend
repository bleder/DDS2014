package utn.edu.dds.TP_OPF5

import utn.edu.dds.TP_OPF5.exception.PartidoCompletoExcepcion

class Estandar extends Object implements TipoInscripcion {

	override inscribirA(Jugador jugador, Partido partido) {

		if (!partido.hayLugar) {
			throw new PartidoCompletoExcepcion("Lista llena, no hay lugar para mas inscripciones")
		} 
		
		partido.agregarJugador(jugador, this)
	}

	override dejaAnotar() {
		return false
	}

}
