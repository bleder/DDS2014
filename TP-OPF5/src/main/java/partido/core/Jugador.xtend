package partido.core


import java.util.List
import java.util.ArrayList
import partido.core.tiposDeInscripcion.TipoInscripcion
import partido.calificaciones.Calificacion
import partido.nuevosJugadores.Administrador
import partido.calificaciones.ClasificacionBuilder
import partido.nuevosJugadores.PropuestaBuilder
import org.uqbar.commons.model.Entity
import java.util.Calendar
import java.util.Random
import java.text.SimpleDateFormat
import java.util.Date
import java.security.Timestamp

class Jugador extends Entity{
	/*@Property*/
	int id_jugador
	/*@Property*/
	String nombre
	/*@Property*/
	String apodo
	/*@Property*/
	String fechaNac
	/*@Property*/
	String mail
	@Property 
	List<Infraccion> infracciones
	@Property 
	List<String> amigos
	@Property
	List<Calificacion> calificaciones  = new ArrayList
	/*@Property*/
	int nivelJuego
	@Property
	List<Partido> partidosJugados  = new ArrayList
	
	//agregado para la vista wicket
	int cantidadDePartidos
	int promedioUltimoPartido
	int promedioTodosLosPartidos
	
	new() {}
	new(String nom, String newMail) {
		mail = newMail
		nombre=nom
		apodo=nombre.substring(0, nombre.length/2)//TODO:potencialmente puede fallar
		fechaNac="01/07/2013"
		infracciones = new ArrayList
		amigos = new ArrayList
		nivelJuego=0
	}
	
	def set_id_jugador(int id_jugador){
		this.id_jugador=id_jugador
	}
	
	def get_id_jugador(){
		this.id_jugador
	}
	
	def set_nombre(String nombre){
		this.nombre=nombre
	}
	
	def get_nombre(){
		this.nombre
	}
	
	def set_apodo(String apodo){
		this.apodo=apodo
	}

	def get_apodo(){
		this.apodo
	}
	
	def set_mail(String mail){
		this.mail=mail
	}
	
	def get_mail(){
		this.mail
	}
	
	def set_nivelJuego(int nivelJuego){
		this.nivelJuego=nivelJuego
	}
	
	def getNivelJuego(){
		this.nivelJuego
	}
	
	def set_fechaNac(String fecha){
		this.fechaNac=fecha
	}
	
	def get_fechaNac(){
		this.fechaNac
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
		if(cant!=0){
			val resultado=sum/cant
			return resultado.intValue
		}
		0
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
		if(cant!=0){
			val resultado=sum/cant
			resultado.intValue
		}
		0
	}
	
	def tuNivelDeJuegoEs(int nv) {
		nivelJuego=nv
	}
	
	def cantidadPartidosJugados(){
		partidosJugados.length
	}
	

	def getCantidadDePartidos(){
		this.cantidadPartidosJugados()
	}
	
	def getPromedioUltimoPartido(){
		this.promedioDeCalificacionesUltimoPartido()
	}
	
	def getPromedioTodosLosPartidos(){
		this.promedioDeCalificaciones(cantidadDePartidos)
	}

	
}
