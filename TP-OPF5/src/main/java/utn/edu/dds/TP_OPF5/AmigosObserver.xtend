package utn.edu.dds.TP_OPF5

import java.util.ArrayList
import java.util.List

class AmigosObserver extends Object implements PartidoObserver {
	
	List<Jugador> amigos
	String mail
	Notificador sender
	
	new(String mails, Notificador send) {
		amigos = new ArrayList
		mail = mails
		sender = send
	}
	
	def agregarAmigo(Jugador jugador) {
		amigos.add(jugador)
	}
	
	override notifyAltaInscripcion(Jugador jugador, Partido partido){
		if(amigos.exists[jug | jug == jugador]) {
			this.notificarAmigo(jugador, partido)
		}
	}
	
	override notifyBajaInscripcion(Jugador jugador, Partido partido){
	}
	
	override notifyConfirmacion(Jugador jugador, Partido partido){
	}
	
	def notificarAmigo(Jugador amigo, Partido partido){
		sender.notificar(mail, "Tu amigo se inscribio")
	}
}