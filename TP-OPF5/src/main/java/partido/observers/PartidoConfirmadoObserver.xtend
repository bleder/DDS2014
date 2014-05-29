package partido.observers

import partido.core.Jugador
import partido.core.Partido
import partido.mailSender.Notificador

class PartidoConfirmadoObserver extends Object implements PartidoObserver {
	
	Notificador sender
	
	new(Notificador send) {
		sender = send
	}
	
	override jugadorConfirmado(Jugador jugador, Partido partido){
		if(partido.estasConfirmado()){
			this.notificarAdmin(partido, "Partido completo")
		}
	}

	override jugadorDadoDeBaja(Jugador jugador, Partido partido){
		if(partido.cantidadConfirmados() == (partido.maximoLista - 1)){
			this.notificarAdmin(partido, "Partido ya no completo")
		}
	}
	
	override jugadorInscripto(Jugador jugador, Partido partido){
	}
	
	def notificarAdmin(Partido partido, String mensaje){
		sender.notificar(partido.administrador.mail, mensaje)
	}
}