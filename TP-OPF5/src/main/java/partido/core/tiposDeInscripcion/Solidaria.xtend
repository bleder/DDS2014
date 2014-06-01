package partido.core.tiposDeInscripcion

import partido.core.Jugador
import partido.core.Partido

class Solidaria extends Object implements TipoInscripcion {
	override inscribirA(Jugador jugador, Partido partido){
		partido.agregarJugador(jugador,this)
	}
	
	override tienePrioridad() {
		return true
	}
	
	override dejaAnotar() {
		return true
	}
	
}