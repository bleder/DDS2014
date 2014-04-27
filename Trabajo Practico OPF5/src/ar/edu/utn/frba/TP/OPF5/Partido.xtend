package ar.edu.utn.frba.TP.OPF5


import java.util.List
import java.util.ArrayList
import ar.edu.utn.frba.TP.OPF5.excepcion.PartidoCompletoExcepcion



abstract class Partido {
	
	@Property 
	private List<Jugador> jugadoresInscriptos
	
	
	@Property 
	private DateTime fechaHora
	
	new (DateTime fechaHora) {
		this.fechaHora = fechaHora
		this.jugadoresInscriptos = new ArrayList
		
	}


def void agregarUnJugador (Jugador jugador){
	if (hayLugarPara(jugador)) {
		jugadoresInscriptos.add(jugador)
	} else {
	throw new PartidoCompletoExcepcion ("No hay mas lugar, la lista de jugadores esta llena, n")
}


}
	
	def boolean hayLugarPara(Jugador jugador){
		jugadoresInscriptos.size <10 
	}
	
}

class DateTime {
}
