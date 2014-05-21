package utn.edu.dds.TP_OPF5

interface PartidoObserver {
	def void notifyAltaInscripcion(Jugador jugador, Partido partido)
	def void notifyBajaInscripcion(Jugador jugador, Partido partido)
	def void notifyConfirmacion(Jugador jugador, Partido partido)
}