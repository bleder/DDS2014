package partido.core

import exception.PartidoCompletoExcepcion
import partido.core.Inscripcion
import java.util.ArrayList
import java.util.List
import partido.core.tiposDeInscripcion.TipoInscripcion
import partido.observers.PartidoObserver
import partido.mailSender.Notificador

class Partido {
	
	@Property
	private String nombrePartido
	@Property 
	private List<Inscripcion> jugadoresInscriptos
	@Property 
	private List<PartidoObserver> observers
	@Property
	Jugador administrador
	@Property 
	int	maximoLista
	
	new(String nomPartido, Notificador notifPartido, Jugador adminPartido){
		nombrePartido=nomPartido
		jugadoresInscriptos = new ArrayList
		observers = new ArrayList
		maximoLista = 10
		administrador = adminPartido
	}
	
	def eliminarInscripcion(Jugador jug) {
		jugadoresInscriptos.remove(buscarInscripcionDelJugador(jug))
		observers.forEach[observer | observer.jugadorDadoDeBaja(jug, this)]
	}
	
	def buscarInscripcionDelJugador(Jugador jug) {
		jugadoresInscriptos.findFirst[inscripcion | inscripcion.jugador == jug]
	}
	
	def darBajaA(Jugador jug) {
		this.eliminarInscripcion(jug)
		this.agregarInfraccion(jug)
	}

	def darBajaA(Jugador jugBaja,Jugador jugReemplazo, TipoInscripcion inscripcion) {
		this.eliminarInscripcion(jugBaja)
		this.agregarJugador(jugReemplazo, inscripcion)
	}
	
	def confirmarJugador(Jugador jugador) {
		this.buscarInscripcionDelJugador(jugador).confirmar()
		observers.forEach[observer | observer.jugadorConfirmado(jugador, this)]
	}
	
	def agregarJugador(Jugador jugador, TipoInscripcion tipoIncripcion){
		var Inscripcion inscripcion = new Inscripcion(jugador,tipoIncripcion)
		if (this.hayLugar) {
			jugadoresInscriptos.add(inscripcion)
		} else if (this.hayAlgunoQueDejaAnotar) {
			this.sacarAlQueDejaAnotar
			jugadoresInscriptos.add(inscripcion)
		} else {
			throw new PartidoCompletoExcepcion("No puede anotarse al partido")
		}
		observers.forEach[observer | observer.jugadorInscripto(jugador, this)]
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
		jug.nuevaInfraccion(new Infraccion("Dado de baja"))
	}
	
	
	def agregarObserver(PartidoObserver obs) {
		observers.add(obs)
	}
	
	def Boolean estasConfirmado() {
		this.jugadoresInscriptos.forall[inscripto | inscripto.estaConfirmada ]
	}
	
}