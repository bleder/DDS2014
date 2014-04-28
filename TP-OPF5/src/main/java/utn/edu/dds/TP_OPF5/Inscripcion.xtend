package utn.edu.dds.TP_OPF5

import java.util.List
import java.util.ArrayList

class Inscripcion {
	
	@Property 
	private List<Jugador> jugadoresInscriptos
	@Property int maxInscriptos=10
	
	new() {
		jugadoresInscriptos = new ArrayList<Jugador>
	}
	
		
	
//no se como implementar el tema de agregar a los jugadores en forma solidaria, tengo una idea pero no me termina de cerrar.

 //def void inscribirParticipante(Jugador jugador) {
	//	if(jugadoresInscriptos.size()<= this.maxInscriptos){
	//	inscribirA(jugador)	
	//	}else{
		//if(participante instanceof !Solidario)
		//participantes.remove(participantes.filter[part|part instanceof Solidario])
		//participantes.add(participante)
		//}

	}
	
