package utn.edu.dds.TP_OPF5_Decorator

class AmigoDecorator implements PartidoInterface {
	
	PartidoInterface decorado
	Notificador sender
	
	new(PartidoInterface p, Jugador jugador, String miMail) {
		decorado = p
	}
	override confirmarJugador(partido.core.Jugador jugador) {
		decorado.confirmarJugador(jugador)
		jugador.amigos.forEach[amigo | sender.notificar(amigo.mail, "Se inscribio tu amigo " + jugador.nombre)]
	}
	
}