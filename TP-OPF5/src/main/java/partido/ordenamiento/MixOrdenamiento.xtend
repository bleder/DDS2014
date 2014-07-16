package partido.ordenamiento

import partido.ordenamiento.Ordenamiento
import partido.core.Partido
import java.util.List
import partido.core.Jugador
import java.util.ArrayList

class MixOrdenamiento extends Ordenamiento {

@Property
List <Ordenamiento> criterios	
	
	new(Partido partido) {
		super(partido)
		this.criterios= new ArrayList
	}
	
	def agregarCriterioHandicap(){
		criterios.add(new Handicap(partido))
	}
		
	def agregarCriterioPromedioUltimoPartido(){
		criterios.add(new PromedioCalificaciones(partido))
	}
	
	def agregarCriterioNCalificaciones(Integer n){
		criterios.add(new PromedioNCalificaciones(partido, n))
	}
	
	override ordenar(Jugador jugador) {
	
		val sum = criterios.map[criterio | criterio.ordenar(jugador)].reduce[n1, n2|n1 + n2]
		val cant =criterios.size
		val resultado=sum/cant
		resultado.intValue

	}
	
}