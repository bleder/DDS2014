package utn.edu.dds.TP_OPF5_Decorator

class AmigoDecorator implements PartidoInterface {
	
	PartidoInterface decorado
	Jugador amigo
	String mail
	
	new(PartidoInterface p, Jugador jugador, String miMail) {
		decorado = p
		amigo = jugador
		mail = miMail
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
	override confirmarJugador(Jugador jugador) {
		decorado.confirmarJugador(jugador)
	}
	
	override agregarJugador(Jugador jugador, TipoInscripcion tipoIncripcion) {
		decorado.agregarJugador(jugador, tipoIncripcion)
		if(amigo == jugador) {
			decorado.getNotificador.notificar(mail, "Tu amigo se inscribio")
		}
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