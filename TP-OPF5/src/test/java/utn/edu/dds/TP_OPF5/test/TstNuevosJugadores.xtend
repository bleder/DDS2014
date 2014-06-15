package utn.edu.dds.TP_OPF5.test

import exception.NoExisteMailException
import exception.NoExisteTalJugadorException
import java.util.ArrayList
import java.util.List
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import partido.core.Jugador
import partido.core.Partido
import partido.nuevosJugadores.Administrador
import partido.nuevosJugadores.PropuestaBuilder

class TstNuevosJugadores {

	var Jugador jugador
	var Partido partido
	var Administrador administrador
	var String amigo
	var String nombre
	var List<String> mailsAmigos

	@Before
	def void init() {
		jugador = new Jugador("Rodolfo", "rodol@aol.com")
		administrador = new Administrador("admin@aol.com")
		nombre = "julian"
		mailsAmigos = new ArrayList
		mailsAmigos.add("juan@hotmail.com")
		mailsAmigos.add("pepe@gmail.com")
		partido = new Partido("Partido_1", administrador)
		amigo = "amigo@amail.com"
		jugador.agregarAmigo(amigo)
	}

	@Test
	def void jugadorCreaPropuestaLaPoseeElAdministrador() {
		jugador.crearPropuesta(amigo, partido.administrador, nombre, mailsAmigos)
		var UltimaPropuesta = partido.administrador.ultimaPropuestaAgregada()
		Assert.assertTrue(partido.administrador.existePropuesta(UltimaPropuesta))
	}

	@Test
	def void JugadorNoPuedeCrearPropuestaQueNoExisteAmigo() {
		var amigoQueNoEsta = "amigoNoEsta@hotmail.com"

		try {
			jugador.crearPropuesta(amigoQueNoEsta, partido.administrador, nombre, mailsAmigos)
			Assert.fail("No se puede crear propuesta de un jugador que no es amigo")
		} catch (NoExisteMailException e) {
			Assert.assertTrue(partido.administrador.posiblesJugadores.empty)
		}
	}

	@Test
	def void adminAceptaPropuestaYJugadorLoPoseeEntreSusAmigos() {
		jugador.crearPropuesta(amigo, partido.administrador, nombre, mailsAmigos)
		var propuesta = partido.administrador.ultimaPropuestaAgregada()
		partido.administrador.aceptarPropuesta(propuesta)
		Assert.assertTrue(jugador.existeAmigo(amigo))
	}

	@Test
	def void adminNoPuedeAceptarPropuestaQueNoExiste() {
		val len = jugador.amigos.size
		var propuestaQNoEsta = crearPropuesta()

		try {
			administrador.aceptarPropuesta(propuestaQNoEsta)
			Assert.fail("No se puede aceptar propuesta que no existe")
		} catch (NoExisteTalJugadorException e) {
			Assert.assertNotSame(jugador.amigos.size, len + 1)
		}
	}
	
	def crearPropuesta() {
		var propuesta= new PropuestaBuilder()
		propuesta.conMail(amigo)
		propuesta.conAmigoDelPropuesto(jugador)
		propuesta.conAmigos(jugador.amigos)
		propuesta.conNombre(nombre)
		propuesta.build()
		
	}

	@Test
	def void adminRechazaPropuestaYRegistraLaDenegacion() {
		val len = administrador.jugadoresRechazados.size
		
		jugador.crearPropuesta(amigo, partido.administrador, nombre, mailsAmigos)
		var UltimaPropuesta = partido.administrador.ultimaPropuestaAgregada()
		
		partido.administrador.rechazarPropuesta(UltimaPropuesta, "Rechazado por X motivo")
		
		Assert.assertEquals(administrador.jugadoresRechazados.size, len + 1)
	}

	@Test
	def void adminRechazaPropuestaNoExisteProduceError() {
		val len = jugador.amigos.size
		var propuestaQNoEsta = crearPropuesta()
		try {
			administrador.rechazarPropuesta(propuestaQNoEsta, "Rechazado por X motivo")
			Assert.fail("No se puede rechazar propuesta que no existe")
		} catch (NoExisteTalJugadorException e) {
			Assert.assertNotSame(jugador.amigos.size, len + 1)
		}
	}

}
