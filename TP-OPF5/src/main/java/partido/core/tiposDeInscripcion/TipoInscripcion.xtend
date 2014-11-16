package partido.core.tiposDeInscripcion

import partido.core.Jugador
import partido.core.Partido

interface TipoInscripcion {
	
	
	def void inscribirA(Jugador jugador, Partido partido)
	def boolean dejaAnotar()
	def boolean tienePrioridad()
}