package partido.dividirEquipos

import partido.core.Partido
import partido.core.Inscripcion
import java.util.List

class DivisorPorPosiciones extends DivisorDeEquipos {

	List<Integer> posiciones
	
	override dividirEquiposDeUnPartido(Partido partido) {
//		for (a : 0 ..< partido.jugadoresInscriptos.size) {
//			if (a == 0 || a == 2 || a == 4 || a == 6 || a == 8) {
//				partido.equipo1.jugadoresInscriptos.add(partido.jugadoresInscriptos.get(a).jugador)
//			} else {
//				partido.equipo2.jugadoresInscriptos.add(partido.jugadoresInscriptos.get(a).jugador)
//			}
//		}
		partido.equipo1.jugadoresInscriptos = equipo1(partido) 
	}
	
	def equipo1(Partido partido){
		return partido.jugadoresInscriptos.filter[esPosicionBuscada(it, partido)]
	}
	
	
	def esPosicionBuscada(Inscripcion inscripcion, Partido partido) {
		posiciones.contains(partido.jugadoresInscriptos.indexOf(inscripcion))
	}
	
}
