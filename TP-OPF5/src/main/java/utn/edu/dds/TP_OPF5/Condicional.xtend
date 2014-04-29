package utn.edu.dds.TP_OPF5

import utn.edu.dds.TP_OPF5.exception.PartidoNoCumpleCondicionesExcepcion
import utn.edu.dds.TP_OPF5.exception.PartidoCompletoExcepcion

class Condicional extends Object implements TipoInscripcion{ 
	
	@Property
	boolean condicion =true //Esto va a ser una expresion lambda. Es decir deberia dejar que se le pase una expresion lambda por parametro
	
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
	
	//Creo q este se va a sacar
	override boolean sePuedeInscribir(Partido partido){
		partido.hayLugar()
	}
	
	override dejaAnotar() {
		return true
	}

	
}