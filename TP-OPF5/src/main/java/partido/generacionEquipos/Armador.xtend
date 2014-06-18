package partido.generacionEquipos

import java.util.List
import partido.core.Jugador
import java.util.HashMap
import java.util.ArrayList

class Armador {
	
	HashMap<Integer, Integer> armadorParImpar
	HashMap<Integer, Integer> armadorRandom
	
	new(){
		armadorParImpar = newHashMap(1 -> 0 , 2 -> 1,
			                         3 -> 0, 4 -> 1,
			                         5 -> 0, 6 -> 1,
			                         7 -> 0, 8 -> 1,
			                         9 -> 0, 10 -> 1
		)
		armadorRandom = newHashMap(1 -> 0 , 2 -> 1,
			                       3 -> 1, 4 -> 0,
			                       5 -> 0, 6 -> 1,
			                       7 -> 1, 8 -> 0,
			                       9 -> 0, 10 -> 1
		)
	}
	
	def armarEquipos(List<Jugador> jugadores, HashMap<Integer, Integer> armador) {
		val equipos = new ArrayList()
		equipos.add(new Equipo)
		equipos.add(new Equipo)
		var i = 0
		while(i<jugadores.size()){
			equipos
				.get(armador.get(i+1))
				.agregarJugador(jugadores.get(i))
				
			i = i + 1
		}
		equipos
	}
	
	def armarParImpar(List<Jugador> jugadores) {
		armarEquipos(jugadores, armadorParImpar)
	}
	
	def armarRandom(List<Jugador> jugadores) {
		armarEquipos(jugadores, armadorRandom)
	}
}