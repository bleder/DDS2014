package utn.edu.dds.TP_OPF5

import java.util.List
import java.util.ArrayList
import utn.edu.dds.TP_OPF5.exception.PartidoCompletoExcepcion

//import ar.edu.utn.frba.TP.OPF5.excepcion.PartidoCompletoExcepcion

class Partido {
	
	@Property
	private String nombrePartido
	@Property 
	private List<Inscripcion> jugadoresInscriptos
	@Property 
	int	maximoLista=10
	
	new(String nomPartido) {
		nombrePartido=nomPartido
	}
	
	

	def agregarJugador(Jugador jugador, TipoInscripcion tipoIncripcion){
		
		var Inscripcion inscripcion
		
		inscripcion= new Inscripcion(jugador,tipoIncripcion)
		jugadoresInscriptos.add(inscripcion)
	}	
// lo agregamos aca o en la clase inscripcion ? no me queda claro ya que tengo difrencias a los jugadores
// que se agregaron en forma solidaria o en forma condicional.	
	//def void inscribirA(Jugador jugador){
		//if (hayLugarPara(jugador)) {
		//jugadoresInscriptos.add(jugador)
		//} else {
		//throw new PartidoCompletoExcepcion ("No hay mas lugar, la lista de jugadores esta llena, n")
	//	}
//	}
	
	def boolean hayLugarPara(Jugador jugador){
		jugadoresInscriptos.size <maximoLista 
	}
	
}