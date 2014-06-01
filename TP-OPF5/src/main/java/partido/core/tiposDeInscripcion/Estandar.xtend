package partido.core.tiposDeInscripcion

import partido.core.Jugador
import partido.core.Partido

class Estandar extends Object implements TipoInscripcion {

	override inscribirA(Jugador jugador, Partido partido) {
		partido.agregarJugador(jugador, this)
	}
	
	override tienePrioridad () {
		return true
	}

	override dejaAnotar() {
		return false
	}

}
