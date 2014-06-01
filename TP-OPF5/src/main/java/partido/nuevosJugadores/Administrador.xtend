package partido.nuevosJugadores

import java.util.List
import partido.core.Jugador
import exception.NoExisteTalJugadorException

class Administrador {
	
	@Property
	String mail
	List<Propuesta> posiblesJugadores
	
	new(String adminMail) {
		mail = adminMail
	}
	
	def existePropuesta(String mail) {
		posiblesJugadores.exists[propuesta | propuesta.mail == mail]
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
	
	def aceptarPropuesta(String mail, String nombre) {
		if (!existePropuesta(mail)) {
			throw new NoExisteTalJugadorException("No existe propuesta para ese jugador")
		}
		
		var jugador = new Jugador(nombre, mail)
		jugador.agregarAmigo(this.getPropuesta(mail).amigo.mail)
		removerPropuesta(mail)
		jugador
	}
	
	def rechazarPropuesta(String mail, String razon) {
		if(!existePropuesta(mail)) {
			throw new NoExisteTalJugadorException("No existe propuesta para ese jugador")
		}
		removerPropuesta(mail)
		new Rechazo(mail, razon) //Usar Notificador?
	}
}