package utn.edu.dds.TP_OPF5

class Solidaria extends Object implements TipoInscripcion {
	override inscribirA(Jugador jugador, Partido partido){
		if (partido.hayLugar()){
			partido.agregarJugador(jugador,this)
		}
	}
	
	override boolean sePuedeInscribir(Partido partido){
	partido.hayLugar()
	}
}