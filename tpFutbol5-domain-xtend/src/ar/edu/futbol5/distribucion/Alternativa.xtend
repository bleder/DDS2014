package ar.edu.futbol5.distribucion

import java.util.List
import ar.edu.futbol5.Jugador
import ar.edu.futbol5.Equipo

class Alternativa implements Distribuidor {
	
	override distribuir(List<Jugador> jugadores, Equipo equipo1, Equipo equipo2) {
		equipo1.jugadores = newArrayList(jugadores.get(0), jugadores.get(3), jugadores.get(4), jugadores.get(7),
			jugadores.get(8))
		equipo2.jugadores = newArrayList(jugadores.get(1), jugadores.get(2), jugadores.get(5), jugadores.get(6),
			jugadores.get(9))
	}
	
}