package partido.core

//import ar.edu.utn.frba.TP.OPF5.Incripciones.TipoInscripcion

import java.util.List
import java.util.ArrayList
import partido.core.tiposDeInscripcion.TipoInscripcion

//import ar.edu.utn.frba.TP.OPF5.Incripciones.TipoInscripcion

class Jugador {
	@Property
	String nombre
	@Property
	String mail
	@Property 
	List<Infraccion> infracciones
	@Property 
	List<Jugador> amigos
	
	
	
	new(String nom, String newMail) {
		mail = newMail
		nombre=nom
		infracciones = new ArrayList
		amigos = new ArrayList
	}
	
 	def inscribite(Partido partido, TipoInscripcion tipoInscripcion) {
		tipoInscripcion.inscribirA(this, partido)
	}
	
	 def confirmarse(Partido partido) {
		partido.confirmarJugador(this)
	}
	
	def nuevaInfraccion(Infraccion infraccion){
		this.getInfracciones.add(infraccion)
	}
	
	def agregarAmigo(Jugador jugador){
		amigos.add(jugador)
	}
	
}