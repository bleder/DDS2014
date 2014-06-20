package partido.core

import exception.PartidoCompletoExcepcion
import partido.core.Inscripcion
import java.util.ArrayList
import java.util.List
import partido.core.tiposDeInscripcion.TipoInscripcion
import partido.observers.PartidoObserver
import partido.nuevosJugadores.Administrador
import partido.command.divisiones.Division
import partido.command.divisiones.ParesImpares
import exception.AdministradorIncorrectoException
import exception.JugadorNoPerteneceAlPartido
import exception.PartidoConfirmadoException
import partido.strategy.criterios.Criterio
import partido.strategy.criterios.Handicap

class Partido {
	
	@Property
	private String nombrePartido
	@Property 
	private List<Inscripcion> jugadoresInscriptos
	@Property 
	private List<Jugador> equipoA
	@Property 
	private List<Jugador> equipoB
	@Property
	private Boolean partidoConfirmado
	@Property 
	private List<PartidoObserver> observers
	@Property
	Administrador administrador
	@Property 
	int	maximoLista
	@Property
	Criterio criterioOrdenamiento
	@Property
	Division criterioDivision
	
	new(String nomPartido, Administrador adminPartido){
		nombrePartido=nomPartido
		jugadoresInscriptos = new ArrayList
		equipoA = new ArrayList
		equipoB = new ArrayList
		partidoConfirmado = false
		observers = new ArrayList
		maximoLista = 10
		administrador = adminPartido
		criterioOrdenamiento = new Handicap()
		criterioDivision = new ParesImpares(this)
	}
	
	def generarEquipos(Administrador adm) {
		
		if(adm!=administrador)
			throw new AdministradorIncorrectoException("El administrador no es el del partido")
			

		jugadoresInscriptos.sortBy[insc | -criterioOrdenamiento.aplicar(insc.jugador)] // ordeno de mayor a menor (descendiente)
		criterioDivision.dividirJugadores()
	}
	
	def comparar(Jugador jug) {
		this.criterioOrdenamiento.aplicar(jug)
	}
	
	def confirmar(Administrador adm) {
		if(adm!=administrador)
			throw new AdministradorIncorrectoException("El administrador no es el del partido")
		
		partidoConfirmado=true
	}
	
	def cambiarCriterio(Criterio crit, Administrador adm) {
		if(adm!=administrador)
			throw new AdministradorIncorrectoException("El administrador no es el del partido")
		
		criterioOrdenamiento = crit
	}
	
	def cambiarDivision(Division div, Administrador adm) {
		if(adm!=administrador)
			throw new AdministradorIncorrectoException("El administrador no es el del partido")
		
		criterioDivision = div
	}
	
	
	def agregarHandicap(Number niv, Jugador jug, Administrador adm) {
		if(adm!=administrador)
			throw new AdministradorIncorrectoException("El administrador no es el del partido")
		if(!estaInscripto(jug))
			throw new JugadorNoPerteneceAlPartido("El jugador no pertenece al partido")
	
	
	}
	
	
	def eliminarInscripcion(Jugador jug) {
		jugadoresInscriptos.remove(buscarInscripcionDelJugador(jug))
		observers.forEach[observer | observer.jugadorDadoDeBaja(jug, this)]
	}
	
	def buscarInscripcionDelJugador(Jugador jug) {
		jugadoresInscriptos.findFirst[inscripcion | inscripcion.jugador == jug]
	}
	
	def darBajaA(Jugador jug) {
		if(this.partidoConfirmado)
			throw new PartidoConfirmadoException("El partido ya fue confirmado, no se puede agregar ni dar de baja jugadores")
		
		this.eliminarInscripcion(jug)
		this.agregarInfraccion(jug)
	}

	def darBajaA(Jugador jugBaja,Jugador jugReemplazo, TipoInscripcion inscripcion) {
		if(this.partidoConfirmado)
			throw new PartidoConfirmadoException("El partido ya fue confirmado, no se puede agregar ni dar de baja jugadores")
		
		
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
		} else if(this.partidoConfirmado){
			throw new PartidoConfirmadoException("El partido ya fue confirmado, no se puede agregar ni dar de baja jugadores")
		}else {
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
	
	def cantidadConfirmados() {
		this.jugadoresInscriptos.filter[inscripto | inscripto.estaConfirmada].size()
	}
	
	def boolean estasConfirmado() {
		this.cantidadConfirmados() == maximoLista
	}
	
}