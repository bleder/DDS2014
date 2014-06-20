package partido.strategy.criterios

import partido.core.Jugador
import exception.DivisionPorCeroException

class Promedio implements Criterio{
	
	@Property
	int n
	
	override aplicar(Jugador jug) {
		
		var int suma
	
		for(i :0..<this.ultimasNCalificaciones(jug).size)
			suma = suma + this.ultimasNCalificaciones(jug).get(i).nota

		
	this.promedio(suma)
	}
	
	
	def ultimasNCalificaciones(Jugador jug) {
		jug.calificaciones.take(n)
	}
	
	def promedio(int suma){
		if(n==0)
			throw new DivisionPorCeroException("No puede calcular el promedio ya que no posee calificaciones")
	suma/n
	}
	
}
