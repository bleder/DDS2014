package partido.ordenamiento

import partido.core.Partido
import partido.core.Jugador

class PromedioCalificaciones extends Ordenamiento {
	

	new(Partido partido) {
		super(partido)
	}
	
	override ordenar(Jugador jugador) {
		jugador.promedioDeCalificacionesUltimoPartido()
	}
}