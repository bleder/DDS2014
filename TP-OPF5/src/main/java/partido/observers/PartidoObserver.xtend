package utn.edu.dds.TP_OPF5

interface PartidoObserver {
	def void jugadorInscripto(Jugador jugador, Partido partido)
	def void jugadorDadoDeBaja(Jugador jugador, Partido partido)
	def void jugadorConfirmado(Jugador jugador, Partido partido)
}