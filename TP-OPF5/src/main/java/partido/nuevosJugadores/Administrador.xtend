package partido.nuevosJugadores

import java.util.List
import partido.core.Jugador
import exception.NoExisteTalJugadorException
import java.util.ArrayList
import partido.core.Partido
import partido.command.criterios.Criterio
import partido.command.divisiones.Division

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
	
	
	def generarEquipos(Partido part) {
		part.generarEquipos(this)
	}
	
	def confirmarArmadoEquipos(Partido part) {
		part.confirmar(this)
	}
	
	def setearCriterio(Criterio crit, Partido part) {
		part.cambiarCriterio(crit, this)
	}
	
	def setearDivision(Division div, Partido part) {
		part.cambiarDivision(div, this)
	}
	
	def setearHandicap(Number nivel, Jugador jug, Partido part) {
		part.agregarHandicap(nivel, jug, this)
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
	
	def aceptarPropuesta(String mail) {
		if (!existePropuesta(mail)) {
			throw new NoExisteTalJugadorException("No existe propuesta para ese jugador")
		}
		var propuesta = this.getPropuesta(mail)
		var jugador = new Jugador(propuesta.nombre, mail)
		jugador.agregarAmigo(propuesta.amigo.mail)
		removerPropuesta(mail)
		for(String mails : propuesta.mailsAmigos) {
			jugador.agregarAmigo(mails)
		}
		jugador
	}
	
	def rechazarPropuesta(String mail, String razon) {
		if(!existePropuesta(mail)) {
			throw new NoExisteTalJugadorException("No existe propuesta para ese jugador")
		}
		val rechazoNuevo = new Rechazo(mail, razon, getPropuesta(mail))
		nuevoRechazo(rechazoNuevo)
		removerPropuesta(mail)
	}
}