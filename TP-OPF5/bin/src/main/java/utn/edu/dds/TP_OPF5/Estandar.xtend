package utn.edu.dds.TP_OPF5

class Estandar extends Object implements TipoInscripcion {

	override inscribirA(Jugador jugador, Partido partido) {
		partido.agregarJugador(jugador, this)
	}
	
	override tienePrioridad () {
		return true
	}

	override dejaAnotar() {
		return false
	}

}