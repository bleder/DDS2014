package partido.core

import exception.PartidoCompletoExcepcion
import partido.core.Inscripcion
import java.util.ArrayList
import java.util.List
import partido.core.tiposDeInscripcion.TipoInscripcion
import partido.observers.PartidoObserver
import partido.nuevosJugadores.Administrador
import partido.ordenamiento.Ordenamiento
import divisionEquipo.Divisor
import exception.PartidoConfirmadoNoAceptaBaja
import java.util.Comparator

class Partido  {
	var List<Inscripcion> incripcionesOrdenadas = new ArrayList
	@Property
	private String nombrePartido
	@Property 
	List<Inscripcion> jugadoresInscriptos = new ArrayList
	@Property 
	private List<PartidoObserver> observers
	@Property 
	List<Jugador> jugadores
	@Property
	Administrador administrador
	@Property 
	int	maximoLista
	@Property
	List<Jugador> equipo1
	@Property
	List<Jugador> equipo2
	@Property
	Ordenamiento ordenamiento
	@Property
	Divisor divisorEquipo
	@Property
	boolean confirmado
	
	new(String nomPartido, Administrador adminPartido){
		nombrePartido=nomPartido
		jugadoresInscriptos = new ArrayList
		observers = new ArrayList
		maximoLista = 10
		administrador = adminPartido
		confirmado=false
	}
	
	def eliminarInscripcion(Jugador jug) {
		jugadoresInscriptos.remove(buscarInscripcionDelJugador(jug))
		observers.forEach[observer | observer.jugadorDadoDeBaja(jug, this)]
	}
	
	def buscarInscripcionDelJugador(Jugador jug) {
		jugadoresInscriptos.findFirst[inscripcion | inscripcion.jugador == jug]
	}
	
	def darBajaA(Jugador jug) {
		if (confirmado){
			throw new PartidoConfirmadoNoAceptaBaja("El partido esta confirmado no se puede dar de baja el jugador")
		}
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
	
	def cantidadConfirmados() {
		this.jugadoresInscriptos.filter[inscripto | inscripto.estaConfirmada].size()
	}
	
	def boolean estasConfirmado() {
		this.cantidadConfirmados() == maximoLista
	}
	
	def partidoOrdenaJugadores(Ordenamiento criterio){
		incripcionesOrdenadas=jugadoresInscriptos.sortBy[ordenamiento.ordenar(jugador)]
		jugadoresInscriptos=incripcionesOrdenadas
	}
	
	def partidoDividiEquipos(){
		divisorEquipo.dividir()
	}
	
	def partidoConfirmate(){
		confirmado=true
	}
	
	
}