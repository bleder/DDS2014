package utn.edu.dds.TP_OPF5_Decorator

import java.util.List
import java.util.ArrayList
import exception.PartidoCompletoExcepcion

//import ar.edu.utn.frba.TP.OPF5.excepcion.PartidoCompletoExcepcion

class Partido implements PartidoInterface {
	
	@Property
	private String nombrePartido
	@Property 
	private List<Inscripcion> jugadoresInscriptos
	@Property
	Notificador notificador
	@Property
	Jugador administrador
	@Property 
	int	maximoLista
	
	new(String nomPartido, Notificador notifPartido, Jugador adminPartido){
		nombrePartido=nomPartido
		jugadoresInscriptos = new ArrayList
		maximoLista = 10
		notificador = notifPartido
		administrador = adminPartido
	}
	
	override darBajaA(Jugador jug) {
		this.eliminarInscripcion(jug)
		this.agregarInfraccion(jug)
		this.notificarBaja(jug)
	}
	
	override eliminarInscripcion(Jugador jug) {
		getJugadoresInscriptos.remove(getJugadoresInscriptos.findFirst[inscripcion | inscripcion.getJugador == jug])
	}
	
	override darBajaA(Jugador jugBaja,Jugador jugReemplazo, TipoInscripcion inscripcion) {
		this.eliminarInscripcion(jugBaja)
		this.agregarJugador(jugReemplazo, inscripcion)
		this.notificarAlta(jugReemplazo)
		this.notificarBaja(jugBaja)
	}
	
	override confirmarJugador(Jugador jugador) {
		//getObservers.forEach[observer | observer.notifyConfirmacion(jugador, this)]
	}
	
	override agregarJugador(Jugador jugador, TipoInscripcion tipoIncripcion){
		var Inscripcion inscripcion = new Inscripcion(jugador,tipoIncripcion)
		if (this.hayLugar) {
			getJugadoresInscriptos.add(inscripcion)
		} else if (this.hayAlgunoQueDejaAnotar) {
			this.sacarAlQueDejaAnotar
			getJugadoresInscriptos.add(inscripcion)
		} else {
			throw new PartidoCompletoExcepcion("No puede anotarse al partido")
		}
		this.notificarAlta(inscripcion.getJugador)
	}
	
	override boolean hayLugar(){
		
		getJugadoresInscriptos.size < this.getMaximoLista
		
	}
	
	override hayAlgunoQueDejaAnotar() {
	
		getJugadoresInscriptos.exists[inscripcion| inscripcion.getTipoInscripcion.dejaAnotar()]
		
	}
	
	override sacarAlQueDejaAnotar() {
		var Inscripcion inscripcionABorrar
		inscripcionABorrar=getJugadoresInscriptos.findFirst[inscripcion| inscripcion.getTipoInscripcion.dejaAnotar()]
		getJugadoresInscriptos.remove(inscripcionABorrar)
	}
	
	override estaInscripto(Jugador jugador) {
		getJugadoresInscriptos.exists[inscripcion | inscripcion.sosInscripcionDe(jugador)]
	}
	
	override agregarInfraccion(Jugador jug){
		jug.getInfracciones.add(new Infraccion("Dado de baja"))
	}
	
	override notificarAlta(Jugador jugador){
		//getObservers.forEach[observer | observer.notifyAltaInscripcion(jugador, this)]
	}
	
	override notificarBaja(Jugador jugador){
		//getObservers.forEach[observer | observer.notifyBajaInscripcion(jugador, this)]
	}	
}