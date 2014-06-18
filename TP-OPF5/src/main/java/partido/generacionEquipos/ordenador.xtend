package partido.generacionEquipos

import partido.core.Jugador
import java.util.List
import org.eclipse.xtext.xbase.lib.Functions.Function1
import java.util.ArrayList

class Ordenador {
	
	@Property
	List<Function1<Jugador, Integer>> criterios
	
	new(){
		criterios = new ArrayList
	}
	
	def agregarCriterioHandicap(){
		criterios.add([Jugador jugador | jugador.handicap])
	}
	
	def agregarCriterioPromedioUltimoPartido(){
		criterios.add([Jugador jugador | jugador.promedioUltimoPartido])
	}
	
	def agregarCriterioUltimasCalificaciones(Integer n){
		criterios.add([Jugador jugador |
			val ultimasCalificaciones = jugador.ultimasCalificaciones(n)
			ultimasCalificaciones.map[calif | calif.nota].reduce[a, b| a + b] / ultimasCalificaciones.size()])
	}
	
	def volverAEmpezar(){
		criterios = new ArrayList
	}
	
	def buildListaOrdenada(List<Jugador> jugadores){
		jugadores.sort([Jugador jugador1, Jugador jugador2 | 
			val notas1 = criterios.map([criterio | criterio.apply(jugador1)])
			val notas2 = criterios.map([criterio | criterio.apply(jugador2)])
			val promedio1 = (notas1.reduce[a, b | a + b] / notas1.size())
			val promedio2 = (notas2.reduce[a, b | a + b] / notas2.size())
			if (promedio1 >= promedio2) {
				return -1
			}
			return 1
		])
	}
}