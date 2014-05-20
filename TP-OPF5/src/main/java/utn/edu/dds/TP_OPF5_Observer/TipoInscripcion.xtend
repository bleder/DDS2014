package utn.edu.dds.TP_OPF5_Observer

interface TipoInscripcion {
	def void inscribirA(Jugador jugador, Partido partido)
	def boolean dejaAnotar()
	def boolean tienePrioridad()
}