package divisionEquipo

import partido.core.Partido

abstract class Divisor {

	@Property
	Partido partido

	new(Partido partido) {
		this.partido = partido
	}

	def void dividir()
}
