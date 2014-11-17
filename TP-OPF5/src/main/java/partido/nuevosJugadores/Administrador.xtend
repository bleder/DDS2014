package partido.nuevosJugadores

import java.util.List
import partido.core.Jugador
import exception.NoExisteTalJugadorException
import java.util.ArrayList

class Administrador {
	
	/*@Property */
	int id_administador
	
	/*@Property */
	String mail
	@Property
	List<Propuesta> posiblesJugadores
	@Property
	List<Rechazo> jugadoresRechazados
	
	new() {}
	
	new(String adminMail) {
		mail = adminMail
		posiblesJugadores = new ArrayList
		jugadoresRechazados = new ArrayList
	}
	
	def setId_administrador(int id_administrador){
		this.id_administador=id_administrador
	}
	
	def getId_administrador(){
		this.id_administador
	}
	
	def setMail(String mail){
		this.mail=mail
	}
	
	def getMail(){
		this.mail
	}
	def existePropuesta(Propuesta propuesta) {
		posiblesJugadores.exists[p | p == propuesta]
	}
	
	def getPropuesta(String mail) {
		posiblesJugadores.findFirst[propuesta | propuesta.mail == mail]
	}
	
	def removerPropuesta(Propuesta propuesta) {
		posiblesJugadores.remove(propuesta)
	}
	
	def nuevaPropuesta(Propuesta nuevaPropuesta) {
		posiblesJugadores.add(nuevaPropuesta)
	}
	
	def ultimaPropuestaAgregada(){
		val ultimo = this.posiblesJugadores.size
		posiblesJugadores.get(ultimo-1)
	}
	
	def nuevoRechazo(Rechazo nuevoRechazo) {
		jugadoresRechazados.add(nuevoRechazo)
	}
	
	def aceptarPropuesta(Propuesta propuesta) {
		var nuevoJugador=new jugadorBuilder()
		nuevoJugador.conPropuesta(propuesta)
		nuevoJugador.suAdministrador(this)
		nuevoJugador.build()
		this.removerPropuesta(propuesta)
		
	}
	
	def rechazarPropuesta(Propuesta propuesta, String razon) {
		
		if(!existePropuesta(propuesta)) {
			throw new NoExisteTalJugadorException("No existe propuesta para ese jugador")
		}
		
		val rechazoNuevo = new Rechazo(razon, propuesta)
		nuevoRechazo(rechazoNuevo)
		removerPropuesta(propuesta)
	}
	
	def otogarNivelJuego(Jugador jugador, int nivelJuego){
		jugador.tuNivelDeJuegoEs(nivelJuego)
	}
}