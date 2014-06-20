package partido.command.criterios

import partido.core.Partido

class PromUltPartido extends Criterio {
	
	new(Partido part) {
		super(part)
	}
	
	override ordenarJugadores() {
		
	this.part.jugadoresInscriptos = this.part.jugadoresInscriptos.sortBy[insc | -insc.jugador.promUltimoPartido] // ordeno la lista descendente
		
	}
	
}