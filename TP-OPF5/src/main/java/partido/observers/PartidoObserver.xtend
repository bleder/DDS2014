package partido.observers

import partido.core.Jugador
import partido.core.Partido

interface PartidoObserver {
	def void jugadorInscripto(Jugador jugador, Partido partido)
	def void jugadorDadoDeBaja(Jugador jugador, Partido partido)
	def void jugadorConfirmado(Jugador jugador, Partido partido)
}