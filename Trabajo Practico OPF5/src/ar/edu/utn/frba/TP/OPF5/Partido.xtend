package ar.edu.utn.frba.TP.OPF5


import java.util.List
import java.util.ArrayList
import ar.edu.utn.frba.TP.OPF5.excepcion.PartidoCompletoExcepcion


abstract class Partido {
	
	@Property 
	private List<Jugador> jugadoresInscriptos
	
// lo agregamos aca o en la clase inscripcion ? no me queda claro ya que tengo difrencias a los jugadores
// que se agregaron en forma solidaria o en forma condicional.	
def void inscribirA(Jugador jugador){
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


