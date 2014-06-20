package partido.command.criterios

import partido.core.Partido

class Handicap extends Criterio {
	
	new(Partido part) {
		super(part)
	}
	
	override ordenarJugadores() {
		this.part.jugadoresInscriptos = this.part.jugadoresInscriptos.sortBy[insc | -insc.jugador.handicap] // ordeno la lista descendente
	}
	
}