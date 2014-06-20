package partido.command.criterios

import partido.core.Partido

class Promedio extends Criterio {
	
	@Property
	int n
	
	new(Partido part) {
		super(part)
		n = 3
	}
	
	override ordenarJugadores() {
	
	this.part.jugadoresInscriptos = this.part.jugadoresInscriptos.sortBy[insc | -insc.jugador.promUltimasNCalificaciones(n)]
	
	}
	
}