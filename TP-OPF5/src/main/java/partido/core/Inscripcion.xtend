package partido.core

import utn.edu.dds.TP_OPF5.TipoInscripcion

class Inscripcion {
	
	@Property
	TipoInscripcion tipoInscripcion
	@Property
	utn.edu.dds.TP_OPF5.Jugador jugador
	
	@Property
	boolean estaConfirmada
	
	new(utn.edu.dds.TP_OPF5.Jugador jug, TipoInscripcion tipoIncrip) {
		tipoInscripcion=tipoIncrip
		jugador=jug
		estaConfirmada=false
	}
	
	def sosInscripcionDe(utn.edu.dds.TP_OPF5.Jugador otroJugador) {
		otroJugador == getJugador
	}
	
	def confirmar() {
		estaConfirmada  = true
	}
	
}
	
