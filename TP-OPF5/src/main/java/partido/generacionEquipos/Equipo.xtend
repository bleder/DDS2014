package partido.generacionEquipos

import partido.core.Jugador
import java.util.List
import java.util.ArrayList

class Equipo {
	@Property
	List<Jugador> equipo
	
	new() {
		equipo = new ArrayList
	}
	
	def agregarJugador(Jugador jug) {
		equipo.add(jug)
	}
}