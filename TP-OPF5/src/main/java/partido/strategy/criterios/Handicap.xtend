package partido.strategy.criterios

import partido.core.Jugador

class Handicap implements Criterio {
	
	override aplicar(Jugador jug) {
		
		jug.handicap
	}

	
}