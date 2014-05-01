package utn.edu.dds.TP_OPF5

import utn.edu.dds.TP_OPF5.exception.PartidoNoCumpleCondicionesExcepcion
import utn.edu.dds.TP_OPF5.exception.PartidoCompletoExcepcion

class Condicional extends Object implements TipoInscripcion{ 
	
	@Property
	boolean condicion =true //Esto va a ser una expresion lambda. Es decir deberia dejar que se le pase una expresion lambda por parametro
	
	override inscribirA(Jugador jugador, Partido partido){
		if (!partido.hayLugar) {
	 		throw new PartidoCompletoExcepcion ("No se puede inscribir porque no hay lugar")
 		}

		if (!condicion){ //FIXME evaluar la condicion del bloque
	 			throw new PartidoNoCumpleCondicionesExcepcion ("El partido no cumple la condicion impuesta por el jugador")
 		}
 		
 		partido.agregarJugador(jugador,this)
	}
	
	override dejaAnotar() {
		return true
	}

	
}