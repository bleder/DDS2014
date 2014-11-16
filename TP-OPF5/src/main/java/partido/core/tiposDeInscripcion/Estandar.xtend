package partido.core.tiposDeInscripcion

import partido.core.Jugador
import partido.core.Partido

class Estandar extends Object implements TipoInscripcion {
	
	@Property
	int id_tipo_incripcion

	override inscribirA(Jugador jugador, Partido partido) {
		partido.agregarJugador(jugador, this)
	}
	
	override tienePrioridad () {
		return true
	}

	override dejaAnotar() {
		return false
	}

	def setId_tipo_inscripcion(int id_tipo_inscripcion){
		this.id_tipo_incripcion=id_tipo_inscripcion
	}
	
	def getId_tipo_inscripcion(){
		this.id_tipo_incripcion
	}
}
