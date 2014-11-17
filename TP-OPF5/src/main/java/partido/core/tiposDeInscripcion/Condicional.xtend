package partido.core.tiposDeInscripcion

import partido.core.Jugador
import partido.core.Partido

import org.eclipse.xtext.xbase.lib.Functions.Function1
import exception.PartidoNoCumpleCondicionesExcepcion

class Condicional extends Object implements TipoInscripcion{ 
	
	/*@Property */
	int id_tipo_incripcion
	
	@Property
	Function1<Partido, Boolean> condicion = [partido | true ]
	
	new() {}
	
	new(Function1<Partido, Boolean> miCondicion) {
		condicion = miCondicion
	}
	
	override inscribirA(Jugador jugador, Partido partido){
		if (!condicion.apply(partido)){
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
	
	def setId_tipo_inscripcion(int id_tipo_inscripcion){
		this.id_tipo_incripcion=id_tipo_inscripcion
	}
	
	def getId_tipo_inscripcion(){
		this.id_tipo_incripcion
	}

	
}