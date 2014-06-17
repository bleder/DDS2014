package partido.ordenamiento

import partido.core.Partido
import partido.core.Jugador

abstract class Ordenamiento {
	@Property
	Partido partido
	
	new(Partido partido){
		this.partido=partido
	}
	def int ordenar(Jugador jugador){
		1
	}

}