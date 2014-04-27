package ar.edu.utn.frba.TP.OPF5.Incripciones
 
import ar.edu.utn.frba.TP.OPF5.Partido	
import ar.edu.utn.frba.TP.OPF5.Jugador	

abstract class TipoDeInscripcion {
	
	def void inscribirA(Jugador jugador, Partido partido) {
		partido.agregarUnJugador(jugador)
	}
}
