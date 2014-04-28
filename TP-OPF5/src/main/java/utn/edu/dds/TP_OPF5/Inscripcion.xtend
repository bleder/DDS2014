package utn.edu.dds.TP_OPF5

import java.util.List
import java.util.ArrayList

class Inscripcion {
	
	@Property
	TipoInscripcion tipoInscripcion
	Jugador jugador
	
	new(Jugador jug, TipoInscripcion tipoIncrip) {
		tipoInscripcion=tipoIncrip
		jugador=jugador
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
	
