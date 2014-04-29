package utn.edu.dds.TP_OPF5

//import ar.edu.utn.frba.TP.OPF5.Incripciones.TipoInscripcion

class Jugador {
	@Property
	private String nombre
	
	new(String nom) {
		nombre=nom
	}
	
 	def inscribite(Partido partido, TipoInscripcion tipoInscripcion) {
		
		if (tipoInscripcion.sePuedeInscribir(partido)){
			tipoInscripcion.inscribirA(this, partido)
			return true
		}
		

		
		
	}
}