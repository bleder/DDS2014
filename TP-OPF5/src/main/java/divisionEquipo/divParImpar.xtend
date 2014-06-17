package divisionEquipo

import partido.core.Partido

class divParImpar extends Divisor {

	new(Partido partido) {
		super(partido)
	}

	override dividir() {

		for (idx : 0 ..< partido.jugadoresInscriptos.size) {
			if (esPar(idx)) {
				partido.equipo1.add(partido.jugadoresInscriptos.get(idx).jugador)
			} else {
				partido.equipo2.add(partido.jugadoresInscriptos.get(idx).jugador)
			}
		}
	}

	def boolean esPar(int x) {
		(x % 2) == 0

	}

}
