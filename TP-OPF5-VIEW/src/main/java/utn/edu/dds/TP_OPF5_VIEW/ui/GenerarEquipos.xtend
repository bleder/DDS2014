package utn.edu.dds.TP_OPF5_VIEW.ui

import org.uqbar.commons.model.Entity
import partido.core.Partido
import divisionEquipo.Divisor
import divisionEquipo.DivParImpar
import divisionEquipo.DivPosiciones
import org.uqbar.commons.model.UserException

class GenerarEquipos extends Entity {
	
	@Property Partido partido
	@Property String criterio
	@Property OrdenamientosHandler handler
	
	new (Partido part) {
		partido = part
	}
	
	def generarEquipos() {
		partido.partidoOrdenaJugadores(handler.dameCriterio(partido))
		getDivisor().dividir()
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
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}