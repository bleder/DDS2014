package ar.edu.futbol5.distribucion

import ar.edu.futbol5.Equipo
import java.util.List
import ar.edu.futbol5.Jugador

interface Distribuidor {
	
	def void distribuir(List<Jugador> jugadores, Equipo equipo1, Equipo equipo2)
	
}