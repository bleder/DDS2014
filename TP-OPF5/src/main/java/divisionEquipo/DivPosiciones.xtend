package divisionEquipo

import java.util.List
import java.util.ArrayList
import partido.core.Partido

class DivPosiciones extends Divisor {
	@Property
	List <Integer> posiciones = new ArrayList()
	
	new(Partido partido, List <Integer> posiciones) {
		super(partido)
		this.posiciones=posiciones
	}
	
	override vaAlEquipo1(int idx){
		posiciones.contains(idx)
	}
	
	
}