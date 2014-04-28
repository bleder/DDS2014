package ar.edu.utn.frba.TP.OPF5

import java.util.List
import java.util.ArrayList


class Inscripcion {
	
	@Property 
	private List<Jugador> jugadoresInscriptos
	
	new() {
		jugadoresInscriptos = new ArrayList<Jugador>
	}
	@Property int maxInscriptos=10
	
	
//no se como implementar el tema de agregar a los jugadores en forma solidaria, tengo una idea pero no me termina de cerrar.

 //def void inscribirParticipante(Jugador jugador) {
	//	if(jugadoresInscriptos.size()<= this.maxInscriptos){
	//	inscribirA(jugador)	
	//	}else{
		//if(participante instanceof !Solidario)
		//participantes.remove(participantes.filter[part|part instanceof Solidario])
		//participantes.add(participante)
		}

	}

}
