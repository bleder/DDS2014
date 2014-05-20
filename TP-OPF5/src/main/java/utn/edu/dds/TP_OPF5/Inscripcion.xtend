package utn.edu.dds.TP_OPF5


class Inscripcion {
	
	@Property
	TipoInscripcion tipoInscripcion
	@Property
	Jugador jugador
	
	new(Jugador jug, TipoInscripcion tipoIncrip) {
		tipoInscripcion=tipoIncrip
		jugador=jug
	}
	
	def sosInscripcionDe(Jugador otroJugador) {
		otroJugador == jugador
	}
}
	
