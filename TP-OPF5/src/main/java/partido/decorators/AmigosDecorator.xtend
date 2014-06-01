package partido.decorators

import partido.decorators.PartidoDecorator
import partido.mailSender.Notificador
import partido.core.Jugador
import partido.core.tiposDeInscripcion.TipoInscripcion

class AmigosDecorator extends PartidoDecorator {
	
	Notificador sender
	
	new(PartidoInterface decorado, Notificador send){
		super(decorado)
		sender = send
	}
	
	override agregarJugador(Jugador jugador, TipoInscripcion inscripcion){
		super.agregarJugador(jugador, inscripcion)
		jugador.amigos.forEach[amigo | sender.notificar(amigo, "Se inscribio tu amigo " + jugador.nombre)]
	}
}