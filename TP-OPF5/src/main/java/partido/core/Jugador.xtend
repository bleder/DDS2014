package partido.core

//import ar.edu.utn.frba.TP.OPF5.Incripciones.TipoInscripcion

import java.util.List
import java.util.ArrayList
import partido.core.tiposDeInscripcion.TipoInscripcion
import partido.calificaciones.Calificacion
import exception.JugadorNoPerteneceAlPartido
import exception.NotaIncorrecta
import exception.NoExisteMailException
import partido.nuevosJugadores.Propuesta
import partido.nuevosJugadores.Administrador
import exception.MeCalificoAMiMismo
import exception.MeCalificoAMiMismo
import exception.YaLoCalifique

//import ar.edu.utn.frba.TP.OPF5.Incripciones.TipoInscripcion


class Jugador {
	@Property
	String nombre
	@Property
	String mail
	@Property 
	List<Infraccion> infracciones
	@Property 
	List<String> amigos
	@Property
	List<Calificacion> calificaciones  = new ArrayList
	
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
	
	def agregarAmigo(String mailAmigo){
		amigos.add(mailAmigo)
	}
	
	def calificarA(Jugador jugador,Partido partido,int nota,String critica){
		if (partido.estaInscripto(jugador))
		{
			if (jugador.calificaciones.exists[calificacion|calificacion.jugadorQueCalifico==this])
			{
				throw new YaLoCalifique("Ya califique a este jugador")
			}
			else
			{
			if (nota>=1 && nota<=10){
			if (jugador!=this)
			{
			this.crearCalificacion(jugador,partido,nota,critica)
			}
			else{throw new MeCalificoAMiMismo("No puedo calificarme a mi mismo")}
			}
			else{throw new NotaIncorrecta("La nota ingresada no es correcta")}			
			}		
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
	
	def crearPropuesta(String amigo, Administrador admin, String nombre, List<String> mailsDeAmigos) {
		if(!existeAmigo(amigo)) {
			throw new NoExisteMailException("El jugador no tiene a ese amigo")
		}
		
		admin.nuevaPropuesta(new Propuesta(amigo, this, nombre, mailsDeAmigos))
	}
	
	def existeAmigo(String mail) {
		amigos.exists[amigo | amigo == mail]
	}
	
}