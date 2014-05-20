package utn.edu.dds.TP_OPF5

class PartidoConfirmadoObserver extends Object implements PartidoObserver {
	
	@Property
	private int confirmados
	
	new() {
		confirmados = 0
	}
	
	override notifyConfirmacion(Jugador jugador, Partido partido){
		confirmados = confirmados + 1
		if(confirmados==10){
			this.notificarAdmin(partido)
			}
	}

	override notifyBajaInscripcion(Inscripcion inscripcion, Partido partido){
		if(confirmados==10){
			this.notificarAdmin(partido)
			}
		confirmados = confirmados -1
	}
	
	
	override notifyAltaInscripcion(Inscripcion inscripcion, Partido partido){
	}
	
	def notificarAdmin(Partido partido){
		partido.notificador.notificar(partido.administrador.mail)
	}
}