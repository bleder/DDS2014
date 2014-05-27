package partido.decorators

import partido.core.Jugador
import partido.core.tiposDeInscripcion.TipoInscripcion

class PartidoDecorator implements PartidoInterface{
	
	PartidoInterface decorado
	
	new(PartidoInterface partido) {
		decorado = partido
	}
	
	override darBajaA(Jugador jug) {
		decorado.darBajaA(jug)
	}
	
	override eliminarInscripcion(Jugador jug) {
		decorado.eliminarInscripcion(jug)
	}
	
	override darBajaA(Jugador jugBaja, Jugador jugReemplazo, TipoInscripcion inscripcion) {
		decorado.darBajaA(jugBaja, jugReemplazo, inscripcion)
	}
	
	override confirmarJugador(Jugador jug) {
		decorado.confirmarJugador(jug)
	}
	
	override agregarJugador(Jugador jug, TipoInscripcion inscripcion) {
		decorado.agregarJugador(jug, inscripcion)
	}
	
	override hayLugar() {
		decorado.hayLugar
	}
	
	override hayAlgunoQueDejaAnotar() {
		decorado.hayAlgunoQueDejaAnotar()
	}
	
	override sacarAlQueDejaAnotar() {
		decorado.sacarAlQueDejaAnotar()
	}
	
	override estaInscripto(Jugador jugador) {
		decorado.estaInscripto(jugador)
	}
	
	override agregarInfraccion(Jugador jug) {
		decorado.agregarInfraccion(jug)
	}
	
	override estasConfirmado() {
		decorado.estasConfirmado()
	}
	
	override getAdministrador() {
		decorado.getAdministrador()
	}
	
}