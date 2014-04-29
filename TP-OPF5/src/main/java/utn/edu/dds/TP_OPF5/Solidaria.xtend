package utn.edu.dds.TP_OPF5

class Solidaria extends Object implements TipoInscripcion {
	override inscribirA(Jugador jugador, Partido partido){
		if (partido.hayLugar()){
			partido.agregarJugador(jugador,this)
		}
	}
	
	//Creo que este se va a sacar
	override boolean sePuedeInscribir(Partido partido){
	partido.hayLugar()
	}
	
	override dejaAnotar() {
		return true
	}
	
}