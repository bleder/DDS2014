package utn.edu.dds.TP_OPF5_Observer

import java.util.List
import java.util.ArrayList
import exception.PartidoCompletoExcepcion

//import ar.edu.utn.frba.TP.OPF5.excepcion.PartidoCompletoExcepcion

class Partido {
	
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
	
	def darBajaA(Inscripcion inscripcion) {
		this.agregarInfraccion(inscripcion.jugador)
		observers.forEach[observer | observer.notifyBajaInscripcion(inscripcion, this)]
	}
	
	def darBajaA(Inscripcion inscBaja,Inscripcion inscReemplazo) {
		agregarJugador(inscReemplazo.jugador, inscReemplazo.tipoInscripcion)
		observers.forEach[observer | observer.notifyAltaInscripcion(inscReemplazo, this)]
		observers.forEach[observer | observer.notifyBajaInscripcion(inscBaja, this)]
	}
	
	def confirmarJugador(Jugador jugador) {
		observers.forEach[observer | observer.notifyConfirmacion(jugador, this)]
	}
	
	def agregarJugador(Jugador jugador, TipoInscripcion tipoIncripcion){
		var Inscripcion inscripcion = new Inscripcion(jugador,tipoIncripcion)
		if (this.hayLugar) {
			this.agregarYNotificar(inscripcion)
				} else if (this.hayAlgunoQueDejaAnotar) {
			this.sacarAlQueDejaAnotar
			jugadoresInscriptos.add(inscripcion)
		} else {
			throw new PartidoCompletoExcepcion("No puede anotarse al partido")
		}			
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
		jugadoresInscriptos.remove(inscripcionABorrar)
	}
	
	def estaInscripto(Jugador jugador) {
		jugadoresInscriptos.exists[inscripcion | inscripcion.sosInscripcionDe(jugador)]
	}
	
	def agregarInfraccion(Jugador jug){
		jug.infraccionesJugador.add(new Infraccion("Dado de baja"))
	}
	
	def agregarYNotificar(Inscripcion inscripcion){
		jugadoresInscriptos.add(inscripcion)
		observers.forEach[observer | observer.notifyAltaInscripcion(inscripcion, this)]
	}
}