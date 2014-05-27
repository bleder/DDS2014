package partido.decorators

import java.util.List
import java.util.ArrayList
import exception.PartidoCompletoExcepcion
import partido.core.Inscripcion
import partido.mailSender.Notificador
import partido.core.Jugador
import partido.core.tiposDeInscripcion.TipoInscripcion
import partido.core.Infraccion

//import ar.edu.utn.frba.TP.OPF5.excepcion.PartidoCompletoExcepcion

class Partido implements PartidoInterface{
	
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
	}
	
	def buscarInscripcionDelJugador(Jugador jug) {
		jugadoresInscriptos.findFirst[inscripcion | inscripcion.jugador == jug]
	}
	
	override eliminarInscripcion(Jugador jug) {
		getJugadoresInscriptos.remove(this.buscarInscripcionDelJugador(jug))
	}
	
	override darBajaA(Jugador jugBaja,Jugador jugReemplazo, TipoInscripcion inscripcion) {
		this.eliminarInscripcion(jugBaja)
		this.agregarJugador(jugReemplazo, inscripcion)
	}
	
	override confirmarJugador(Jugador jugador) {
		this.buscarInscripcionDelJugador(jugador).confirmar()
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
	
	override boolean estasConfirmado() {
		this.jugadoresInscriptos.forall[inscripto | inscripto.estaConfirmada ]
	}
}