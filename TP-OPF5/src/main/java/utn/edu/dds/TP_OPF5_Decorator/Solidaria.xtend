package utn.edu.dds.TP_OPF5_Decorator

class Solidaria extends Object implements TipoInscripcion {
	override inscribirA(Jugador jugador, Partido partido){
		partido.agregarJugador(jugador,this)
	}
	
	override tienePrioridad() {
		return true
	}
	
	override dejaAnotar() {
		return true
	}
	
}