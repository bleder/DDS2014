package partido.strategy.criterios

import partido.core.Jugador

interface Criterio {
	
	def int aplicar(Jugador jug)

}