package partido.strategy.criterios

import partido.core.Jugador
import exception.DivisionPorCeroException

class PromUltPartido implements Criterio{
	
	override aplicar(Jugador jug) {
			
	var int suma
	
		for(i :0..<this.ultimasCalificaciones(jug).size)
			suma = suma + this.ultimasCalificaciones(jug).get(i).nota
	
	this.promedio(suma,ultimasCalificaciones(jug).size)
	}
	
	def ultimasCalificaciones(Jugador jug) {
		jug.calificaciones.filter[cal | cal.partido==jug.ultimoPartidoJugado]
	}
	
	def promedio(int suma, int total){
		if(total==0)
			throw new DivisionPorCeroException("No puede calcular el promedio ya que no posee calificaciones")
	
	suma/total
	}

}