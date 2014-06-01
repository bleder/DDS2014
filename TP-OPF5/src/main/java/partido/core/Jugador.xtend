package partido.core

//import ar.edu.utn.frba.TP.OPF5.Incripciones.TipoInscripcion

import java.util.List
import java.util.ArrayList
import partido.core.tiposDeInscripcion.TipoInscripcion
import partido.calificaciones.Calificacion
import exception.JugadorNoPerteneceAlPartido
import exception.NotaIncorrecta

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
	@Property
	List<Calificacion> calificaciones
	
	
	
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
	
	def calificarA(Jugador jugador,Partido partido,int nota,String critica){
		if (partido.estaInscripto(jugador))
		{
			if (nota>=1 && nota<=10){
			this.crearCalificacion(jugador,partido,nota,critica)
			}
			else{throw new NotaIncorrecta("La nota ingresada no es correcta")}			
		}
		else
		{
			throw new JugadorNoPerteneceAlPartido("No esta ese jugador en el partido")
		}
		
	}
	
	def agregateCalificacion(Calificacion calificacion){
		this.calificaciones.add(calificacion)
	}
	
	def crearCalificacion(Jugador jugador,Partido partido,int nota,String critica){
		jugador.agregateCalificacion(new Calificacion(critica,jugador,partido,nota))
	}
	
}