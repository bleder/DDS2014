package partido.nuevosJugadores

import java.util.List
import partido.core.Jugador
import exception.NoExisteTalJugadorException
import java.util.ArrayList

class Administrador {
	
	@Property
	String mail
	@Property
	List<Propuesta> posiblesJugadores
	@Property
	List<Rechazo> jugadoresRechazados
	
	new(String adminMail) {
		mail = adminMail
		posiblesJugadores = new ArrayList
		jugadoresRechazados = new ArrayList
	}
	
	def existePropuesta(Propuesta propuesta) {
		posiblesJugadores.exists[p | p == propuesta]
	}
	
	def getPropuesta(String mail) {
		posiblesJugadores.findFirst[propuesta | propuesta.mail == mail]
	}
	
	def removerPropuesta(String mail) {
		posiblesJugadores.remove(getPropuesta(mail))
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
		if (!existePropuesta(propuesta)) {
			throw new NoExisteTalJugadorException("No existe propuesta para ese jugador")
		}
		var jugador = new Jugador(propuesta.nombre, mail)
		jugador.agregarAmigo(propuesta.amigo.mail)
		removerPropuesta(mail)
		for(String mails : propuesta.mailsAmigos) {
			jugador.agregarAmigo(mails)
		}
		jugador
	}
	
	def rechazarPropuesta(Propuesta propuesta, String razon) {
		if(!existePropuesta(propuesta)) {
			throw new NoExisteTalJugadorException("No existe propuesta para ese jugador")
		}
		val rechazoNuevo = new Rechazo(mail, razon, getPropuesta(mail))
		nuevoRechazo(rechazoNuevo)
		removerPropuesta(mail)
	}
}