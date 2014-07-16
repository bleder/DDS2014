package ar.edu.futbol5

import ar.edu.futbol5.excepciones.BusinessException
import ar.edu.futbol5.ordenamiento.CriterioOrdenamiento
import ar.edu.futbol5.ordenamiento.OrdenamientoPorHandicap
import java.util.ArrayList
import java.util.List
import ar.edu.futbol5.distribucion.Distribuidor
import ar.edu.futbol5.distribucion.ParImpar
import ar.edu.futbol5.estado.Estado
import ar.edu.futbol5.estado.Abierto
import ar.edu.futbol5.estado.Generado
import ar.edu.futbol5.estado.Cerrado

class Partido {

	@Property List<Jugador> inscriptos
	@Property Equipo equipo1
	@Property Equipo equipo2
	Estado estado
	@Property CriterioOrdenamiento criterioOrdenamiento
	@Property Distribuidor distribucionEquipos

	new() {
		inscriptos = new ArrayList<Jugador>
		estado = new Abierto
		distribucionEquipos = new ParImpar
		criterioOrdenamiento = new OrdenamientoPorHandicap
	}

	def generarEquipos() {
		this.validarInscripcion
		this.distribuirEquipos(this.ordenarEquipos)
		estado = new Generado
	}

	def validarInscripcion() {
		if (inscriptos.size < 10) {
			throw new BusinessException("Hubo un error")
		}
		estado.validar()
	}

	def distribuirEquipos(List<Jugador> jugadores) {
		equipo1 = new Equipo
		equipo2 = new Equipo
		distribucionEquipos.distribuir(jugadores, equipo1, equipo2)
	}

	def List<Jugador> ordenarEquipos() {
		criterioOrdenamiento.ordenar(this)
	}

	def void inscribir(Jugador jugador) {
		if (inscriptos.size < 10) {
			this.inscriptos.add(jugador)
		} else {
			if (this.hayAlgunJugadorQueCedaLugar()) {
				this.inscriptos.remove(this.jugadorQueCedeLugar())
				this.inscriptos.add(jugador)
			} else {
				throw new BusinessException("No hay más lugar")
			}
		}
	}

	def boolean hayAlgunJugadorQueCedaLugar() {
		inscriptos.exists[jugador|jugador.dejaLugarAOtro]
	}

	def Jugador jugadorQueCedeLugar() {
		if (!hayAlgunJugadorQueCedaLugar()) {
			return null
		}
		return inscriptos.filter[jugador|jugador.dejaLugarAOtro].get(0)
	}

	def void cerrar() {
		estado = new Cerrado
	}
}
