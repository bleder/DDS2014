package partido.calificaciones

import partido.core.Jugador
import partido.core.Partido


class Calificacion {
	@Property
	private String critica
	private Jugador jugadorQueCalifico
	private Partido partido	
	@Property
	private int nota
	new(String string, Jugador jugador, Partido partidop, int i) {
		critica=string
		jugadorQueCalifico=jugador
		partido=partidop
		nota=i
	}
	
	
}