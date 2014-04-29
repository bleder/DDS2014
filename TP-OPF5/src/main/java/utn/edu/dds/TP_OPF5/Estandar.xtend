package utn.edu.dds.TP_OPF5

import utn.edu.dds.TP_OPF5.exception.PartidoCompletoExcepcion

class Estandar extends Object implements TipoInscripcion{
	
	override inscribirA(Jugador jugador, Partido partido) {
		
		if (partido.haySolidario()){
			partido.agregarJugador(jugador, this)
			partido.sacarSolidario()
			}else if(partido.hayLugar){
			partido.agregarJugador(jugador, this)	
			}else{
				throw new PartidoCompletoExcepcion ("Lista llena, no hay lugar para mas inscripciones")
			}
		}
		
		
		
	override boolean sePuedeInscribir(Partido partido){
		partido.hayLugar()||partido.haySolidario()
	}
	
	}
	

			

	
