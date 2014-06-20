package partido.command.divisiones

import partido.core.Partido
import partido.core.Jugador
import java.util.List

class ParesImpares extends Division {
	
	new(Partido part) {
		super(part)
	}
	
	override dividirJugadores() {
		
		this.part.equipoA=this.generarPares()
		this.part.equipoB=this.generarImpares()
	
	}
	
	
	def generarPares(){
		
		var int i
		var List<Jugador> auxPar
		
		i=0;
		while(i<this.part.jugadoresInscriptos.size){
			auxPar.add(this.part.jugadoresInscriptos.get(i).jugador)
			i = i +2
		}
	
		auxPar
	}
	
	def generarImpares(){
		
		var int i
		var List<Jugador> auxImpar
		
		i=1;
		while(i<this.part.jugadoresInscriptos.size){
			auxImpar.add(this.part.jugadoresInscriptos.get(i).jugador)
			i = i +2
		}
	
		auxImpar
	}
	
}