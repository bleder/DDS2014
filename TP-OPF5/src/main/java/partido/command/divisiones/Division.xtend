package partido.command.divisiones

import partido.core.Partido

abstract class Division {
	var Partido part
	
	new (Partido part){
		this.part = part
	}
	
	def getPart(){
		part
	}
	
	def abstract void dividirJugadores()

}
