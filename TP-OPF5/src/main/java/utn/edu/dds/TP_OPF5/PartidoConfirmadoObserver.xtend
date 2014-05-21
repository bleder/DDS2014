package utn.edu.dds.TP_OPF5

import java.util.List
import java.util.ArrayList

class PartidoConfirmadoObserver extends Object implements PartidoObserver {
	
	@Property
	private List<Jugador> confirmados
	
	new() {
		confirmados = new ArrayList
	}
	
	override notifyConfirmacion(Jugador jugador, Partido partido){
		confirmados.add(jugador)
		if(confirmados.size==partido.maximoLista){
			this.notificarAdmin(partido, "Partido completo")
		}
	}

	override notifyBajaInscripcion(Jugador jugador, Partido partido){
		if(confirmados.size==partido.maximoLista && confirmados.exists[jug | jug == jugador]){
			this.notificarAdmin(partido, "Partido ya no completo")
			confirmados.remove(jugador)
		}
	}
	
	
	override notifyAltaInscripcion(Jugador jugador, Partido partido){
	}
	
	def notificarAdmin(Partido partido, String mensaje){
		partido.notificador.notificar(partido.administrador.mail, mensaje)
	}
}