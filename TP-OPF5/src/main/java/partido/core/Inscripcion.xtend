package partido.core

import partido.core.tiposDeInscripcion.TipoInscripcion

class Inscripcion {
	
	/* @Property */
	int id_inscripcion
	@Property
	TipoInscripcion tipoInscripcion
	@Property
	Jugador jugador
	
	/* @Property */
	boolean estaConfirmada
	
	new() {}
	
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
	
	def setId_inscripcion(int id_inscripcion){
		this.id_inscripcion=id_inscripcion
	}
	
	def getId_inscripcion(){
		this.id_inscripcion
	}
	
	def setEstaConfirmada(Boolean estaConfirmada){
		this.estaConfirmada=estaConfirmada
	}
	
	def getEstaConfirmada(){
		this.estaConfirmada
	}

	
}
	
