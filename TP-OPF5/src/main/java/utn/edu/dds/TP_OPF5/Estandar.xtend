package utn.edu.dds.TP_OPF5

import utn.edu.dds.TP_OPF5.exception.PartidoCompletoExcepcion

class Estandar extends Object implements TipoInscripcion{
	
	override inscribirA(Jugador jugador, Partido partido) {
		
		if (partido.hayLugar){
			partido.agregarJugador(jugador, this)
			}else if (partido.hayAlgunoQueDejaAnotar()){
			partido.agregarJugador(jugador, this)
			partido.sacarAlQueDejaAnotar()	
			}else{
				throw new PartidoCompletoExcepcion ("Lista llena, no hay lugar para mas inscripciones")
			}
		}
		
		
		//Creo que se puede sacar
	override boolean sePuedeInscribir(Partido partido){
		partido.hayLugar()||partido.hayAlgunoQueDejaAnotar()
	}
	
	override dejaAnotar() {
		return false
	}
	
	}
	

			

	
