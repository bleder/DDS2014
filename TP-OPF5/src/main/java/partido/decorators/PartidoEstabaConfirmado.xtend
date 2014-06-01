package partido.decorators

import partido.decorators.PartidoDecorator
import partido.mailSender.Notificador
import partido.core.Jugador

class PartidoEstabaConfirmado extends PartidoDecorator {
	
	Notificador sender
	
	new(PartidoInterface decorado, Notificador send){
		super(decorado)
		sender = send
	}
	
	override darBajaA(Jugador jugador){
		val debeNotificar = super.estasConfirmado()
		super.darBajaA(jugador)
		if(debeNotificar){
			sender.notificar(super.getAdministrador.mail, "Partido ya no completo")
		}
	}
}