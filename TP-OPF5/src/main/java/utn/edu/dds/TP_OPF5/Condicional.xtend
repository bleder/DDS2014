package utn.edu.dds.TP_OPF5

import org.eclipse.xtext.xbase.lib.Functions.Function1
import utn.edu.dds.TP_OPF5.exception.PartidoNoCumpleCondicionesExcepcion

class Condicional extends Object implements TipoInscripcion{ 
	
	@Property
	Function1<Partido, Boolean> condicion = [partido | true ]
	
	override inscribirA(Jugador jugador, Partido partido){
		if (condicion.apply(partido)){ //FIXME evaluar la condicion del bloque
	 		throw new PartidoNoCumpleCondicionesExcepcion ("El partido no cumple la condicion impuesta por el jugador")
 		}
 		
 		partido.agregarJugador(jugador,this)
	}
	
	override tienePrioridad () {
		return false
	}
	
	override dejaAnotar() {
		return true
	}

	
}