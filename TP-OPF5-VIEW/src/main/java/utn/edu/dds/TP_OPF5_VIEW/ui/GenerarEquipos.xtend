package utn.edu.dds.TP_OPF5_VIEW.ui

import org.uqbar.commons.model.Entity
import partido.core.Partido
import divisionEquipo.Divisor
import divisionEquipo.DivParImpar
import divisionEquipo.DivPosiciones
import org.uqbar.commons.model.UserException
import java.util.ArrayList
import partido.core.Jugador
import java.util.List

class GenerarEquipos extends Entity {
	
	@Property List<Jugador> equipo1
	@Property List<Jugador> equipo2
	@Property Partido partido
	@Property String criterio
	@Property OrdenamientosHandler handler
	
	@Property boolean confirmadoAdm
	
	new (Partido part) {
		partido = part
		confirmadoAdm = partido.confirmadoAdm
		if (partido.confirmadoAdm) {
			equipo1 = partido.equipo1
			equipo2 = partido.equipo2
		}
	}
	
	def generarEquipos() {
		partido.divisorEquipo=getDivisor()
		partido.partidoDividiEquipos()
		partido.partidoOrdenaJugadores(handler.dameCriterio(partido))
		equipo1 = partido.equipo1
		equipo2 = partido.equipo2
	}
	
	def Divisor getDivisor() {
		if (criterio == "Par/Impar") {
			return new DivParImpar(partido)
		}
		if (criterio == "Posiciones") {
			return new DivPosiciones(partido, #[1, 4, 5, 8, 9])
		}
		throw new UserException("Algo muy malo paso")
	}
	
	def confirmarEquipos() {
		partido.confirmate()
		confirmadoAdm = true
	}
	
}