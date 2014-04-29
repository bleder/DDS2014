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
	
	def boolean hayLugar(){
		
		(jugadoresInscriptos.size < 10)
		
	}
	
	def hayAlgunoQueDejaAnotar() {
	
		jugadoresInscriptos.exists[inscripcion| inscripcion.tipoInscripcion.dejaAnotar()]
		
	}
	
	def sacarAlQueDejaAnotar() {
		var Inscripcion inscripcionABorrar
		inscripcionABorrar=jugadoresInscriptos.findFirst[inscripcion| inscripcion.tipoInscripcion.dejaAnotar()]
	}
	
}