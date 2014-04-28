package ar.edu.utn.frba.TP.OPF5

import ar.edu.utn.frba.TP.OPF5.Incripciones.TipoInscripcion

class Jugador {

	@Property
	private String nombre
	
 	def void inscribite(Partido partido, TipoInscripcion tipoInscripcion) {
		tipoInscripcion.inscribir(this, partido)}

