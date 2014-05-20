package utn.edu.dds.TP_OPF5

class AmigosObserver extends Object implements PartidoObserver {
	
	override notifyAltaInscripcion(Inscripcion inscripcion, Partido partido){
		inscripcion.jugador.amigosJugador.forEach[amigo | this.notificarAmigo(amigo, partido)]
	}
	
	override notifyBajaInscripcion(Inscripcion inscripcion, Partido partido){
	}
	
	override notifyConfirmacion(Jugador jugador, Partido partido){
	}
	
	
	def notificarAmigo(Jugador amigo, Partido partido){
		partido.notificador.notificar(amigo.mail)
	}
}