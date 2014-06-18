package divisionEquipo

import partido.core.Partido

abstract class Divisor {

	@Property
	Partido partido

	new(Partido partido) {
		this.partido = partido
	}

	def dividir() {
		for (idx : 0 ..< partido.jugadoresInscriptos.size) {
			if (vaAlEquipo1(idx)) {
				partido.equipo1.add(partido.jugadoresInscriptos.get(idx).jugador)
			} else {
				partido.equipo2.add(partido.jugadoresInscriptos.get(idx).jugador)
			}
		}
	}
	
	def abstract boolean vaAlEquipo1(int idx)
	
}
