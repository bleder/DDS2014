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
	int	maximoLista
	
	new(String nomPartido) {
		nombrePartido=nomPartido
		jugadoresInscriptos = new ArrayList
		maximoLista = 10
	}
	
	def agregarJugador(Jugador jugador, TipoInscripcion tipoIncripcion){
		var Inscripcion inscripcion = new Inscripcion(jugador,tipoIncripcion)
		jugadoresInscriptos.add(inscripcion)
		(if llegue a mi limite:) this.sacarAlQueDejaAnotar
	}	
	
	def boolean hayLugar(){
		
		jugadoresInscriptos.size < this.maximoLista
		
	}
	
	def hayAlgunoQueDejaAnotar() {
	
		jugadoresInscriptos.exists[inscripcion| inscripcion.tipoInscripcion.dejaAnotar()]
		
	}
	
	def sacarAlQueDejaAnotar() {
		var Inscripcion inscripcionABorrar
		inscripcionABorrar=jugadoresInscriptos.findFirst[inscripcion| inscripcion.tipoInscripcion.dejaAnotar()]
		
	}
	
}