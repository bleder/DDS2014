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
import exception.PartidoNoPoseeCantidadMaxima
import exception.PartidoYaConfirmado
import exception.NoSeRealizoDivisionDeEquipos
import org.uqbar.commons.model.Entity
import partido.core.tiposDeInscripcion.Estandar

class Partido extends Entity {
	/*@Property*/
	int id_partido
	var List<Inscripcion> incripcionesOrdenadas = new ArrayList
	/*@Property*/
	private String nombrePartido
	@Property
	List<Inscripcion> jugadoresInscriptos = new ArrayList
	@Property
	private List<PartidoObserver> observers
	@Property
	List<Jugador> jugadores
	@Property
	Administrador administrador
	/*@Property*/
	int maximoLista
	@Property
	List<Jugador> equipo1 = new ArrayList
	@Property
	List<Jugador> equipo2 = new ArrayList
	@Property
	Divisor divisorEquipo
	/*@Property*/
	boolean confirmadoAdm
	
	@Property
	List<Jugador> jugadoresHome

	new() {}
	
	new(String nomPartido, Administrador adminPartido) {
		nombrePartido = nomPartido
		jugadoresInscriptos = new ArrayList
		observers = new ArrayList
		maximoLista = 10
		administrador = adminPartido
		confirmadoAdm = false
	}
	
	def set_id_partido(int id_partido){
		this.id_partido=id_partido
	}
	
	def get_id_partido(){
		this.id_partido
	}
	
	def get_nombrePartido(){
		this.nombrePartido
	}
	
	def set_nombrePartido(String nombrePartido){
		this.nombrePartido=nombrePartido
	}
	
	def set_maximoLista(int maximoLista){
		this.maximoLista=maximoLista
	}
	
	def get_maximoLista(){
		this.maximoLista
	}
	
	def set_confirmadoAdm(Boolean confirmadoAdm){
		this.confirmadoAdm=confirmadoAdm
	}
	
	def get_confirmadoAdm(){
		this.confirmadoAdm	
	}

	def eliminarInscripcion(Jugador jug) {
		jugadoresInscriptos.remove(buscarInscripcionDelJugador(jug))
		observers.forEach[observer|observer.jugadorDadoDeBaja(jug, this)]
	}

	def buscarInscripcionDelJugador(Jugador jug) {
		jugadoresInscriptos.findFirst[inscripcion|inscripcion.jugador == jug]
	}

	def darBajaA(Jugador jug) {
		if (confirmadoAdm) {
			throw new PartidoConfirmadoNoAceptaBaja("El partido esta confirmado no se puede dar de baja el jugador")
		}
		this.eliminarInscripcion(jug)
		this.agregarInfraccion(jug)
	}

	def darBajaA(Jugador jugBaja, Jugador jugReemplazo, TipoInscripcion inscripcion) {
		if (confirmadoAdm) {
			throw new PartidoConfirmadoNoAceptaBaja("El partido esta confirmado no se puede dar de baja el jugador")
		}
		this.eliminarInscripcion(jugBaja)
		this.agregarJugador(jugReemplazo, inscripcion)
	}

	def confirmarJugador(Jugador jugador) {
		this.buscarInscripcionDelJugador(jugador).confirmar()
		observers.forEach[observer|observer.jugadorConfirmado(jugador, this)]
	}
	
	def inscribiYConfirmarATodosLosJugadores(){
		val tipoIncEstandar = new Estandar()

		this.jugadores.forEach[jugador|jugador.inscribite(this,tipoIncEstandar) confirmarJugador(jugador) ]
	}


	def agregarJugador(Jugador jugador, TipoInscripcion tipoIncripcion) {
		var Inscripcion inscripcion = new Inscripcion(jugador, tipoIncripcion)
		if (this.hayLugar) {
			jugadoresInscriptos.add(inscripcion)
		} else if (this.hayAlgunoQueDejaAnotar) {
			this.sacarAlQueDejaAnotar
			jugadoresInscriptos.add(inscripcion)
		} else {
			throw new PartidoCompletoExcepcion("No puede anotarse al partido")
		}
		observers.forEach[observer|observer.jugadorInscripto(jugador, this)]
	}

	def boolean hayLugar() {
		jugadoresInscriptos.size < this.maximoLista
	}

	def hayAlgunoQueDejaAnotar() {
		jugadoresInscriptos.exists[inscripcion|inscripcion.tipoInscripcion.dejaAnotar()]
	}

	def sacarAlQueDejaAnotar() {
		var Inscripcion inscripcionABorrar
		inscripcionABorrar = jugadoresInscriptos.findFirst[inscripcion|inscripcion.tipoInscripcion.dejaAnotar()]
		jugadoresInscriptos.remove(inscripcionABorrar)
	}

	def estaInscripto(Jugador jugador) {
		jugadoresInscriptos.exists[inscripcion|inscripcion.sosInscripcionDe(jugador)]
	}

	def agregarInfraccion(Jugador jug) {
		jug.nuevaInfraccion(new Infraccion("Dado de baja"))
	}

	def agregarObserver(PartidoObserver obs) {
		observers.add(obs)
	}

	def cantidadConfirmados() {
		this.jugadoresInscriptos.filter[inscripto|inscripto.getEstaConfirmada()].size()
	}

	def boolean estasConfirmado() {
		this.cantidadConfirmados() == maximoLista
	}

	def partidoOrdenaJugadores(Ordenamiento criterio) {
		incripcionesOrdenadas = jugadoresInscriptos.sortBy[criterio.ordenar(jugador)]
		jugadoresInscriptos = incripcionesOrdenadas
	}

	def partidoDividiEquipos() {
		if (!estasConfirmado()) {
			throw new PartidoNoPoseeCantidadMaxima("Partido no alcanza cantidad de jugadores para dividir en 2 partidos")
		}
		if (confirmadoAdm) {
			throw new PartidoYaConfirmado("El partido ya se encuentra confirmado")
		}
		divisorEquipo.dividir()
	}

	def confirmate() {
		if (equipo1.empty && equipo2.empty) {
			throw new NoSeRealizoDivisionDeEquipos("No se Realizo la division de equipos para poder confirmar el mismo")
		}
		if (confirmadoAdm) {
			throw new PartidoYaConfirmado("El partido ya se encuentra confirmado")
		}
		confirmadoAdm = true

	}
}
