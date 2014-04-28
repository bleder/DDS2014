package ar.edu.utn.frba.TP.OPF5.Incripciones

import ar.edu.utn.frba.TP.OPF5.excepcion.PartidoNoCumpleCondicionesExcepcion
import ar.edu.utn.frba.TP.OPF5.Jugador
import ar.edu.utn.frba.TP.OPF5.Partido

class Condicional  extends TipoInscripcion{
	 
 @Property
 private Condicion condicion
	 
	 override inscribir (Jugador jugador, Partido partido) {
	 	if (condicion.puedeInscribirseA(partido)) {
	 		partido.inscribirA(jugador)
	 	} else { throw new PartidoNoCumpleCondicionesExcepcion ("El partido no cumple la condicion impuesta por el jugador")
	 	}
	 }
}