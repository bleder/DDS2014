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
	
	def nuevoRechazo(Rechazo nuevoRechazo) {
		jugadoresRechazados.add(nuevoRechazo)
	}
	
	def aceptarPropuesta(String mail, String nombre, List<String> mailsDeAmigos) {
		if (!existePropuesta(mail)) {
			throw new NoExisteTalJugadorException("No existe propuesta para ese jugador")
		}
		
		var jugador = new Jugador(nombre, mail)
		jugador.agregarAmigo(this.getPropuesta(mail).amigo.mail)
		removerPropuesta(mail)
		for(String mailDeAmigo : mailsDeAmigos) {
			jugador.agregarAmigo(mailDeAmigo)
		}
		jugador
	}
	
	def rechazarPropuesta(String mail, String razon) {
		if(!existePropuesta(mail)) {
			throw new NoExisteTalJugadorException("No existe propuesta para ese jugador")
		}
		removerPropuesta(mail)
		nuevoRechazo(new Rechazo(mail, razon)) //Usar Notificador?
	}
}