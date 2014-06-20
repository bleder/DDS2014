package partido.strategy.criterios

import partido.core.Jugador
import java.util.List
import exception.DivisionPorCeroException

class MixCriterios implements Criterio {
	
	@Property
	List<Criterio> criterios
	
	override aplicar(Jugador jug) {
		

		var int suma
		
		for(i :0..<criterios.size)
			suma = suma + criterios.get(i).aplicar(jug)

		
		this.promedio(suma)
	}

	def promedio(int suma){
		if(criterios.size==0)
			throw new DivisionPorCeroException("No puede calcular el promedio ya que no posee calificaciones")
	suma/criterios.size
	}
	
}