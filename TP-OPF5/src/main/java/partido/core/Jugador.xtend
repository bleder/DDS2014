package partido.core

//import ar.edu.utn.frba.TP.OPF5.Incripciones.TipoInscripcion

import java.util.List
import java.util.ArrayList
import partido.core.tiposDeInscripcion.TipoInscripcion

//import ar.edu.utn.frba.TP.OPF5.Incripciones.TipoInscripcion

class Jugador {
	@Property
	private String nombre
	@Property
	private String mail
	@Property 
	private List<Infraccion> infracciones
	@Property 
	private List<Jugador> amigos
	
	
	
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
	
	def nuevaInfraccion(Infraccion infraccion){
		this.getInfracciones.add(infraccion)
	}
	
	def agregarAmigo(Jugador jugador){
		amigos.add(jugador)
	}
	
}