package utn.edu.dds.TP_OPF5

import java.util.ArrayList
import java.util.List
import exception.PartidoCompletoExcepcion

class PartidoDecorator implements PartidoInterface {
		
	@Property
	private String nombrePartido
	@Property 
	private List<Inscripcion> jugadoresInscriptos
	@Property 
	private List<PartidoObserver> observers
	@Property
	Notificador notificador
	@Property
	Jugador administrador
	@Property 
	int	maximoLista
	
	new(String nomPartido, Notificador notifPartido, Jugador adminPartido){
		nombrePartido=nomPartido
		jugadoresInscriptos = new ArrayList
		observers = new ArrayList
		maximoLista = 10
		notificador = notifPartido
		administrador = adminPartido
	}
	
	override darBajaA(Jugador jug) {
		this.eliminarInscripcion(jug)
		this.agregarInfraccion(jug)
	}
	
	override eliminarInscripcion(Jugador jug) {
		jugadoresInscriptos.remove(jugadoresInscriptos.findFirst[inscripcion | inscripcion.jugador == jug])
	}
	
	override darBajaA(Jugador jugBaja,Jugador jugReemplazo, TipoInscripcion inscripcion) {
		this.eliminarInscripcion(jugBaja)
		this.agregarJugador(jugReemplazo, inscripcion)
	}
	
	override agregarJugador(Jugador jugador, TipoInscripcion tipoIncripcion){
		var Inscripcion inscripcion = new Inscripcion(jugador,tipoIncripcion)
		if (this.hayLugar) {
			jugadoresInscriptos.add(inscripcion)
		} else if (this.hayAlgunoQueDejaAnotar) {
			this.sacarAlQueDejaAnotar
			jugadoresInscriptos.add(inscripcion)
		} else {
			throw new PartidoCompletoExcepcion("No puede anotarse al partido")
		}
	}
	
	override boolean hayLugar(){
		jugadoresInscriptos.size < this.maximoLista
	}
	
	override hayAlgunoQueDejaAnotar() {
		jugadoresInscriptos.exists[inscripcion| inscripcion.tipoInscripcion.dejaAnotar()]
	}
	
	override sacarAlQueDejaAnotar() {
		var Inscripcion inscripcionABorrar
		inscripcionABorrar=jugadoresInscriptos.findFirst[inscripcion| inscripcion.tipoInscripcion.dejaAnotar()]
		jugadoresInscriptos.remove(inscripcionABorrar)
	}
	
	override estaInscripto(Jugador jugador) {
		jugadoresInscriptos.exists[inscripcion | inscripcion.sosInscripcionDe(jugador)]
	}
	
	override agregarInfraccion(Jugador jug){
		jug.infracciones.add(new Infraccion("Dado de baja"))
	}
}