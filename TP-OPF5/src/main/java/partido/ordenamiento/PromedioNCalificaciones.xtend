package partido.ordenamiento

import partido.core.Partido
import partido.core.Jugador

class PromedioNCalificaciones extends Ordenamiento {
	@Property
	int n
	
	new(Partido partido, int n) {
		super(partido)
		this.n=n
	}
	
	override ordenar(Jugador jugador) {
		jugador.promedioDeCalificaciones(n)
	}
	
}