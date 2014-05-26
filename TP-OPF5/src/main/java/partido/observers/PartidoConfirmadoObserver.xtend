package utn.edu.dds.TP_OPF5

class PartidoConfirmadoObserver extends Object implements PartidoObserver {
	
	new() {
	}
	
	override jugadorConfirmado(Jugador jugador, Partido partido){
		if(partido.estasConfirmado()){
			this.notificarAdmin(partido, "Partido completo")
		}
	}

	override jugadorDadoDeBaja(Jugador jugador, Partido partido){
		if(!partido.estasConfirmado){ //TODO: faltan condiciones, el partido tenia que estar completo y no lo estamos checkeando
			this.notificarAdmin(partido, "Partido ya no completo")
		}
	}
	
	override jugadorInscripto(Jugador jugador, Partido partido){
	}
	
	def notificarAdmin(Partido partido, String mensaje){
		partido.notificador.notificar(partido.administrador.mail, mensaje)
	}
}