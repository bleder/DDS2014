package partido.command.criterios

import partido.core.Partido

abstract class Criterio {
	var Partido part
	
	new (Partido part){
		this.part = part
	}
	
	def getPart(){
		part
	}
	
	def abstract void ordenarJugadores()

}