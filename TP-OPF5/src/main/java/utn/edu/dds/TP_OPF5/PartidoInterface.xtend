package utn.edu.dds.TP_OPF5

interface PartidoInterface {
	def void darBajaA(Jugador jug)
	def void eliminarInscripcion(Jugador jug)
	def void darBajaA(Jugador jugBaja,Jugador jugReemplazo, TipoInscripcion inscripcion)
	def void agregarJugador(Jugador jugador, TipoInscripcion tipoInscripcion)
	def boolean hayLugar()
	def boolean hayAlgunoQueDejaAnotar()
	def void sacarAlQueDejaAnotar()
	def boolean estaInscripto(Jugador jugador)
	def void agregarInfraccion(Jugador jug)
}