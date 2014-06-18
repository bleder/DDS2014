package partido.ordenamiento

import partido.ordenamiento.Ordenamiento
import partido.core.Partido
import java.util.List
import partido.core.Jugador

class MixOrdenamiento extends Ordenamiento {

@Property
List <Ordenamiento> criterios	
	
	new(Partido partido, List <Ordenamiento> criterios) {
		super(partido)
		this.criterios=criterios
		
	}
	
override ordenar(Jugador jugador) {
	
		val sum = criterios.map[criterio | criterio.ordenar(jugador)].reduce[n1, n2|n1 + n2]
		val cant =criterios.size
		val resultado=sum/cant
		resultado.intValue

	}
	
}