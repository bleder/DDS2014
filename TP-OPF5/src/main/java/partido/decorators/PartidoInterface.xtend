package partido.decorators

import partido.core.Jugador
import partido.core.tiposDeInscripcion.TipoInscripcion

interface PartidoInterface {
	def void darBajaA(Jugador jug)
	def void eliminarInscripcion(Jugador jug)
	def void darBajaA(Jugador jugBaja,Jugador jugReemplazo, TipoInscripcion inscripcion)
	def void confirmarJugador(Jugador jug)
	def void agregarJugador(Jugador jug, TipoInscripcion inscripcion)
	def boolean hayLugar()
	def boolean hayAlgunoQueDejaAnotar()
	def void sacarAlQueDejaAnotar()
	def boolean estaInscripto(Jugador jugador)
	def void agregarInfraccion(Jugador jug)
	def boolean estasConfirmado()
	def Jugador getAdministrador()
}