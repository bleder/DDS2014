package utn.edu.dds.TP_OPF5

import utn.edu.dds.TP_OPF5.exception.PartidoNoCumpleCondicionesExcepcion
import utn.edu.dds.TP_OPF5.exception.PartidoCompletoExcepcion

class Condicional extends Object implements TipoInscripcion{ 
	
	@Property
	boolean condicion =true //Esto va a ser mas adelante una expresion Lambda por ahora dejemoslo asi
	
	override inscribirA(Jugador jugador, Partido partido){
		if (partido.hayLugar) {
			if (condicion){
	 		partido.agregarJugador(jugador,this)
	 		}else{
	 			throw new PartidoNoCumpleCondicionesExcepcion ("El partido no cumple la condicion impuesta por el jugador")
	 		}
	 	}else{
	 		throw new PartidoCompletoExcepcion ("Lista llena, no hay lugar para mas inscripciones")
	 	}
	}
	
	override boolean sePuedeInscribir(Partido partido){
		partido.hayLugar()
	}	

	
}