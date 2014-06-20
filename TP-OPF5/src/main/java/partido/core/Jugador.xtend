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
import exception.YaLoCalifique
import exception.DivisionPorCeroException

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
	List<Calificacion> calificaciones
	@Property
	int handicap
	@Property
	Partido ultimoPartidoJugado
	
	new(String nom, String newMail) {
		mail = newMail
		nombre=nom
		infracciones = new ArrayList
		amigos = new ArrayList
		calificaciones = new ArrayList
		handicap = 0
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
			if (jugador.calificaciones.exists[calificacion|(calificacion.jugadorQueCalifico==jugador) && (calificacion.partido==partido)])
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
	
	def promUltimoPartido() {
	
	var int suma
	
		for(i :0..<this.ultimasCalificaciones.size)
			suma = suma + this.ultimasCalificaciones.get(i).nota
	
	this.promedio(suma,this.ultimasCalificaciones.size)
	}
	
	def promUltimasNCalificaciones(int n) {

	var int suma
	
		for(i :0..<this.ultimasNCalificaciones(n).size)
			suma = suma + this.ultimasNCalificaciones(n).get(i).nota

		
	this.promedio(suma,n)
	}
	
	def ultimasCalificaciones() {
		calificaciones.filter[cal | cal.partido==ultimoPartidoJugado]
	}
	
	def ultimasNCalificaciones(int n) {
		calificaciones.take(n)
	}
	
	def promedio(int suma, int total){
		if(total==0)
			throw new DivisionPorCeroException("No puede calcular el promedio ya que no posee calificaciones")
	
	suma/total
	}
	

}
