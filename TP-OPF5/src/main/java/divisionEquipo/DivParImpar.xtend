package divisionEquipo

import partido.core.Partido

class DivParImpar extends Divisor {

	new(Partido partido) {
		super(partido)
	}


	override vaAlEquipo1(int x) {
		(x % 2) == 0

	}
	
}
