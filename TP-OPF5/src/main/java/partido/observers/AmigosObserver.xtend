package partido.observers

import partido.core.Jugador
import partido.core.Partido
import partido.mailSender.Notificador

class AmigosObserver extends Object implements PartidoObserver {
	
	Notificador sender
	
	new(Notificador send) {
		sender = send
	}
	
	override jugadorInscripto(Jugador jugador, Partido partido){
		jugador.getAmigos().forEach[amigo | sender.notificar(amigo.mail, "Se inscribio tu amigo " + jugador.nombre)]
	}
	
	override jugadorDadoDeBaja(Jugador jugador, Partido partido){
	}
	
	override jugadorConfirmado(Jugador jugador, Partido partido){
	}
	
}