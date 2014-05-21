package utn.edu.dds.TP_OPF5_Decorator

import org.eclipse.xtext.xbase.lib.Functions.Function1
import exception.PartidoNoCumpleCondicionesExcepcion

class Condicional extends Object implements TipoInscripcion{ 
	
	@Property
	Function1<Partido, Boolean> condicion = [partido | true ]
	
	new(Function1<Partido, Boolean> miCondicion) {
		condicion = miCondicion
	}
	
	override inscribirA(Jugador jugador, Partido partido){
		if (!getCondicion.apply(partido)){
	 		throw new PartidoNoCumpleCondicionesExcepcion("El partido no cumple la condicion impuesta por el jugador")
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