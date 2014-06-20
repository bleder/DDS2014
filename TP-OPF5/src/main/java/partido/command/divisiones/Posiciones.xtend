package partido.command.divisiones

import partido.core.Partido
import partido.core.Jugador
import java.util.List

class Divisiones extends Division {
	
	new(Partido part) {
		super(part)
	}
	
	override dividirJugadores() {
		
		this.part.equipoA=this.posiciones14589()
		this.part.equipoB=this.posiciones236710()
	
	}
	
	def posiciones14589(){
		
		var List<Jugador> aux
		
		aux.add(pos(1));
		aux.add(pos(4));
		aux.add(pos(5));
		aux.add(pos(8));
		aux.add(pos(9));
		aux
	}
	
	def posiciones236710(){
		
		var List<Jugador> aux
		
		aux.add(pos(2));
		aux.add(pos(3));
		aux.add(pos(6));
		aux.add(pos(7));
		aux.add(pos(10));
		aux
	}
	

	def pos(int n){
		this.part.jugadoresInscriptos.get(n).jugador
}

}
