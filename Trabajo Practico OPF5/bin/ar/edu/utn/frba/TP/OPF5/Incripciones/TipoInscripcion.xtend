package ar.edu.utn.frba.TP.OPF5.Incripciones
 
import ar.edu.utn.frba.TP.OPF5.Partido	
import ar.edu.utn.frba.TP.OPF5.Jugador	

abstract class TipoInscripcion {
	
	def void inscribir (Jugador jugador, Partido partido) {
		partido.inscribirA(jugador)

	}
}
