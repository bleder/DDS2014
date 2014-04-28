package utn.edu.dds.TP_OPF5

//import ar.edu.utn.frba.TP.OPF5.Incripciones.TipoInscripcion

class Jugador {
	@Property
	private String nombre
	
	new(String nom) {
		nombre=nom
	}
	
 	def inscribite(Partido partido, TipoInscripcion tipoInscripcion) {
	//Hacer un if preguntando a la inscripcion si puede inscribir, en cas que pueda ejecuta tipoInscripcion.inscribirA
	//y devuelve True (hacelo devolver a la fuerza true osea ponele return true se que deberia devolver true pero sino no me lo toma
	//el caso de prueba	
		tipoInscripcion.inscribirA(this, partido)
		return true
	}
}