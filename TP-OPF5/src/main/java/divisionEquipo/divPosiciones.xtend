package divisionEquipo

import java.util.List
import java.util.ArrayList
import partido.core.Partido

class divPosiciones extends Divisor {
	@Property
	List <Integer> posiciones = new ArrayList(5)
	
	new(Partido partido, List <Integer> posiciones) {
		super(partido)
		this.posiciones=posiciones
	}
	
	override dividir() {
		for (idx : 0 ..< partido.jugadoresInscriptos.size) {
			if (estaEnPosiciones(idx)) {
				partido.equipo1.add(partido.jugadoresInscriptos.get(idx).jugador)
			} else {
				partido.equipo2.add(partido.jugadoresInscriptos.get(idx).jugador)
			}
		}
	}
	
	def boolean estaEnPosiciones(int idx){
		posiciones.contains(idx)
	}
	
	
}