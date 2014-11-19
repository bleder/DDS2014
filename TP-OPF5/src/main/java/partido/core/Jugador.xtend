package partido.core


import java.util.List
import java.util.ArrayList
import partido.core.tiposDeInscripcion.TipoInscripcion
import partido.calificaciones.Calificacion
import partido.nuevosJugadores.Administrador
import partido.calificaciones.ClasificacionBuilder
import partido.nuevosJugadores.PropuestaBuilder
import java.util.Calendar
import java.util.Random
import java.text.SimpleDateFormat
import java.util.Date
import java.security.Timestamp


import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.DiscriminatorColumn
import javax.persistence.DiscriminatorType
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Inheritance
import javax.persistence.InheritanceType
import javax.persistence.OneToMany
import javax.persistence.Transient
import org.uqbar.commons.utils.Observable

@Entity
class Jugador {
	@Id	@GeneratedValue @Column(name="id_jugador")  private int id_jugador
	@Column(name="nombre") private String nombre
	@Column(name="apodo") private String apodo
	@Column(name="fecha_nacimiento") private String fechaNac
	@Column(name="mail") private String mail
	@Column(name="nivelDeJuego") private int nivelJuego
	@Transient List<String> amigos
	@Transient List<Infraccion> infracciones
	@Transient List<Calificacion> calificaciones  = new ArrayList
	@Transient List<Partido> partidosJugados  = new ArrayList
	
	//agregado para la vista wicket
	@Transient int cantidadDePartidos
	@Transient int promedioUltimoPartido
	@Transient int promedioTodosLosPartidos
	
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
	
	def getId_jugador(){id_jugador}
	def getNombre(){nombre}
	def getApodo(){apodo}
	def getFechaNac(){fechaNac}
	def getMail(){this.mail}
	def getNivelJuego(){this.nivelJuego}
	def setId_jugador(int id_jugador){this.id_jugador=id_jugador}
	def setNombre(String nombre){this.nombre=nombre}
	def setApodo(String apodo){this.apodo=apodo}
	def setMail(String mail){this.mail=mail}
	def setNivelJuego(int nivelJuego){this.nivelJuego=nivelJuego}
	def setFechaNac(String fecha){this.fechaNac=fecha}
	def setAmigos(List<String> amigos){this.amigos=amigos}
	def getAmigos(){this.amigos}
	def setInfracciones(List<Infraccion> infracciones){this.infracciones=infracciones}
	def getInfracciones(){this.infracciones}
	def setCalificaciones(List<Calificacion> calificaciones){this.calificaciones=calificaciones}
	def getCalificaciones(){this.calificaciones}
	def setPartidosJugados(List<Partido> partidos){this.partidosJugados=partidos}
	def getPartidosJugados(){this.partidosJugados}
	def setCantidadDePartidos(int cantpartidos){this.cantidadDePartidos=cantpartidos}
	def getCantidadDePartidos(){this.cantidadDePartidos}
	def setPromedioUltimoPartido(int prom){this.promedioUltimoPartido=prom}
	def getPromedioUltimoPartido(){this.promedioUltimoPartido}
	def setPromedioTodosLosPartidos(int prom){this.promedioTodosLosPartidos=prom}
	def getPromedioTodosLosPartidos(){this.promedioDeCalificaciones(cantidadDePartidos)}
	
	
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
	
}
