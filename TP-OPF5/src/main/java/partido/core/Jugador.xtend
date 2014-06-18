package partido.core


import java.util.List
import java.util.ArrayList
import partido.core.tiposDeInscripcion.TipoInscripcion
import partido.calificaciones.Calificacion
import partido.nuevosJugadores.Administrador
import partido.calificaciones.ClasificacionBuilder
import partido.nuevosJugadores.PropuestaBuilder

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
	@Property
	int nivelJuego
	@Property
	List<Partido> partidosJugados  = new ArrayList
	
	
	

	new(String nom, String newMail) {
		mail = newMail
		nombre=nom
		infracciones = new ArrayList
		amigos = new ArrayList
		nivelJuego=0
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
	
	def calificarA(Jugador jugador, Partido partido, int nota, String critica) {
		
		var calificacion = new ClasificacionBuilder()
		calificacion.conPartido(partido)
		calificacion.conNota(nota)
		calificacion.conCritica(critica)
		calificacion.conCalificador(this)
		calificacion.conCalificado(jugador)
		
		jugador.agregateCalificacion(calificacion.build())
	}

	def agregateCalificacion(Calificacion calificacion){
		this.calificaciones.add(calificacion)
	}
			
	def crearPropuesta(String amigo, Administrador admin, String nombre, List<String> mailsDeAmigos) {
		var propuesta= new PropuestaBuilder()
		propuesta.conMail(amigo)
		propuesta.conAmigoDelPropuesto(this)
		propuesta.conAmigos(mailsDeAmigos)
		propuesta.conNombre(nombre)
			
		admin.nuevaPropuesta(propuesta.build())
	}
	 
	def existeAmigo(String mail) {
		amigos.exists[amigo | amigo == mail]
	}
	
	def promedioDeCalificacionesUltimoPartido(){
		val sum= notasUltimoPartido().reduce[n1, n2|n1 + n2]
		val cant=notasUltimoPartido().size
		val resultado=sum/cant
		resultado.intValue
	 }
	def Iterable<Integer> notasUltimoPartido(){
		calificaciones.filter[calificacion |calificacion.partido == ultimoPartido()].map[calificacion|calificacion.nota]
	}
	def Partido ultimoPartido(){
		partidosJugados.last
	}
	def promedioDeCalificaciones(int n){
		val sum=calificaciones.take(n).map[calificacion|calificacion.nota].reduce[n1, n2|n1 + n2]
		val cant=calificaciones.take(n).size
		val resultado=sum/cant
		resultado.intValue
	}
	
	def tuNivelDeJuegoEs(int nv) {
		nivelJuego=nv
	}
	

	
}
