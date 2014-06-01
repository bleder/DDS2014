package partido.core

import partido.core.tiposDeInscripcion.TipoInscripcion

class Inscripcion {
	
	@Property
	TipoInscripcion tipoInscripcion
	@Property
	Jugador jugador
	
	@Property
	boolean estaConfirmada
	
	new(Jugador jug, TipoInscripcion tipoIncrip) {
		tipoInscripcion=tipoIncrip
		jugador=jug
		estaConfirmada=false
	}
	
	def sosInscripcionDe(Jugador otroJugador) {
		otroJugador == getJugador
	}
	
	def confirmar() {
		estaConfirmada  = true
	}
	
}
	
