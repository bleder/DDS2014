package utn.edu.dds.TP_OPF5

interface PartidoObserver {
	def void notifyAltaInscripcion(Inscripcion inscripcion, Partido partido)
	def void notifyBajaInscripcion(Inscripcion inscripcion, Partido partido)
	def void notifyConfirmacion(Jugador jugador, Partido partido)
}