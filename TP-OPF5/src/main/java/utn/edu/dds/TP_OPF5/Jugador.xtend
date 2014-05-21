package utn.edu.dds.TP_OPF5

//import ar.edu.utn.frba.TP.OPF5.Incripciones.TipoInscripcion

import java.util.List
import java.util.ArrayList
//import ar.edu.utn.frba.TP.OPF5.Incripciones.TipoInscripcion

class Jugador {
	@Property
	private String nombre
	@Property
	private String mail
	@Property 
	private List<Infraccion> infracciones
	
	new(String nom) {
		nombre=nom
		infracciones = new ArrayList
	}
	
 	def inscribite(Partido partido, TipoInscripcion tipoInscripcion) {
		tipoInscripcion.inscribirA(this, partido)
	}
	
	 def confirmarse(Partido partido) {
		partido.confirmarJugador(this)
	}
	
	
}