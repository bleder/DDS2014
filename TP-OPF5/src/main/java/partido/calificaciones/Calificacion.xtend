package partido.calificaciones

import partido.core.Jugador
import partido.core.Partido


class Calificacion {
	@Property
	private String critica
	@Property
	private Jugador jugadorQueCalifico
	@Property
	private Partido partido	
	@Property
	int nota
	new(String string, Jugador jugador, Partido partidop, int i) {
		critica=string
		jugadorQueCalifico=jugador
		partido=partidop
		nota=i
	}
	

	
	
}