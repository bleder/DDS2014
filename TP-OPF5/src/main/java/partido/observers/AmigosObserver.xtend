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
	
	override jugadorInscripto(Jugador jugador, Partido partido){
		jugador.amigos.forEach[amigo | sender.notificar(amigo.mail, "Se inscribio tu amigo " + jugador.nombre)]
	}
	
	override jugadorDadoDeBaja(Jugador jugador, Partido partido){
	}
	
	override jugadorConfirmado(Jugador jugador, Partido partido){
	}
	
}