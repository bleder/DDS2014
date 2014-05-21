package utn.edu.dds.TP_OPF5_Decorator

import java.util.List
import java.util.ArrayList

class PartidoConfirmadoDecorator implements PartidoInterface{
	
	
	PartidoInterface decorado
	@Property
	private List<Jugador> confirmados
	
	new(PartidoInterface p) {
		decorado = p
		confirmados = new ArrayList
	}
	
	override darBajaA(Jugador jug) {
		decorado.darBajaA(jug)
		if(!hayLugar()) {
			getNotificador.notificar(getAdministrador.mail, "Partido ya no completo")
		}
		confirmados.remove(jug)
	}
	override eliminarInscripcion(Jugador jug) {
		decorado.eliminarInscripcion(jug)
	}
	override darBajaA(Jugador jugBaja, Jugador jugReemplazo, TipoInscripcion inscripcion) {
		decorado.darBajaA(jugBaja, jugReemplazo, inscripcion)
		confirmados.remove(jugBaja)
		confirmados.add(jugReemplazo)
	}
	override confirmarJugador(Jugador jugador) {
		confirmados.add(jugador)
		if(confirmados.size == decorado.getMaximoLista()) {
			getNotificador.notificar(getAdministrador.mail, "Partido completo")
		}
	}
	
	override agregarJugador(Jugador jugador, TipoInscripcion tipoIncripcion) {
		decorado.agregarJugador(jugador, tipoIncripcion)
	}
	
	override hayLugar() {
		decorado.hayLugar()
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
	
	override notificarAlta(Jugador jugador) {
		decorado.notificarAlta(jugador)
	}
	
	override notificarBaja(Jugador jugador) {
		decorado.notificarBaja(jugador)
	}
	
	override getMaximoLista() {
		decorado.getMaximoLista()
	}
	
	override getNotificador() {
		decorado.getNotificador()
	}
	
	override getAdministrador() {
		decorado.getAdministrador()
	}
	
}