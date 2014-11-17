package partido.ordenamiento

import partido.ordenamiento.Ordenamiento
import partido.core.Partido
import partido.core.Jugador

class Handicap extends Ordenamiento {
	

	new(Partido partido) {
		super(partido)
	}
	
	override ordenar(Jugador jugador) {
	
		jugador.nivelJuego

	}
	
}