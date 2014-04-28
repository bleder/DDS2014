package utn.edu.dds.TP_OPF5

import utn.edu.dds.TP_OPF5.exception.PartidoNoCumpleCondicionesExcepcion

class Condicional extends Object implements TipoInscripcion{ 
	
	@Property
	boolean condicion =true //Esto va a ser mas adelante una expresion Lambda por ahora dejemoslo asi
	
	override inscribirA(Jugador jugador, Partido partido){
		if (condicion) {
	 	//	partido.inscribirA(jugador)
	 	} else { throw new PartidoNoCumpleCondicionesExcepcion ("El partido no cumple la condicion impuesta por el jugador")
	 	}
	}	

	
}