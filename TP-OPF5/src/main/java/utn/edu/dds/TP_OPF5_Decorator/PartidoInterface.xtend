package utn.edu.dds.TP_OPF5_Decorator

interface PartidoInterface {
	def Jugador getAdministrador()
	def int getMaximoLista()
	def Notificador getNotificador()
	def void darBajaA(Jugador jug)
	def void eliminarInscripcion(Jugador jug)
	def void darBajaA(Jugador jugBaja,Jugador jugReemplazo, TipoInscripcion inscripcion)
	def void confirmarJugador(Jugador jugador)
	def void agregarJugador(Jugador jugador, TipoInscripcion tipoIncripcion)
	def boolean hayLugar()
	def boolean hayAlgunoQueDejaAnotar()
	def void sacarAlQueDejaAnotar()
	def boolean estaInscripto(Jugador jugador)
	def void agregarInfraccion(Jugador jug)
	def void notificarAlta(Jugador jugador)
	def void notificarBaja(Jugador jugador)
}