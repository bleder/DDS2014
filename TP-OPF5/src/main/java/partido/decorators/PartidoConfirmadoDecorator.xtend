package partido.decorators

import partido.decorators.PartidoDecorator
import partido.mailSender.Notificador
import partido.core.Jugador

class PartidoConfirmadoDecorator extends PartidoDecorator {
	
	Notificador sender
	
	new(PartidoInterface decorado, Notificador send){
		super(decorado)
		sender = send
	}
	
	override confirmarJugador(Jugador jugador){
		super.confirmarJugador(jugador)
		if(super.estasConfirmado()){
			sender.notificar(super.getAdministrador.mail, "El partido esta lleno")
		}
	}
}