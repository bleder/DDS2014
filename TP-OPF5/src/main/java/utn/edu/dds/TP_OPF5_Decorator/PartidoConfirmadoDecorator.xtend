package utn.edu.dds.TP_OPF5_Decorator

/**
 * Este decorador notifica cuando confirmamos todos los jugadores
 */
class PartidoConfirmadoDecorator implements PartidoInterface{
	PartidoInterface decorado
	
	new(PartidoInterface p) {
		decorado = p
	}
	
	override confirmarJugador(Jugador jugador) {
		decorado.confirmarJugador(jugador)
		if(this.estasConfirmado()){
			getNotificador.notificar(getAdministrador.mail, "Partido completo")
		}		
	}
	
}