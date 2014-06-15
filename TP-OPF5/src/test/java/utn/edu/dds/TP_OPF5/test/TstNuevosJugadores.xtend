package utn.edu.dds.TP_OPF5.test

import org.junit.Before
import org.junit.Test
import org.junit.Assert
import partido.core.Jugador
import partido.core.Partido
import partido.mailSender.MailSender
import partido.nuevosJugadores.Administrador
import partido.nuevosJugadores.Propuesta
import partido.nuevosJugadores.Rechazo
import exception.NoExisteMailException
import exception.NoExisteTalJugadorException
import java.util.ArrayList
import java.util.List

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
		Assert.assertTrue(partido.administrador.existePropuesta(amigo))
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
		partido.administrador.aceptarPropuesta(amigo)
		Assert.assertTrue(jugador.existeAmigo(amigo))
	}

	@Test
	def void adminNoPuedeAceptarPropuestaQueNoExiste() {
		val len = jugador.amigos.size
		var amigoQueNoEsta = "amigoNoEsta@hotmaill.com"

		try {
			administrador.aceptarPropuesta(amigoQueNoEsta)
			Assert.fail("No se puede aceptar propuesta que no existe")
		} catch (NoExisteTalJugadorException e) {
			Assert.assertNotSame(jugador.amigos.size, len + 1)
		}
	}

	@Test
	def void adminRechazaPropuestaYRegistraLaDenegacion() {
		val len = administrador.jugadoresRechazados.size
		jugador.crearPropuesta(amigo, partido.administrador, nombre, mailsAmigos)
		partido.administrador.rechazarPropuesta(amigo, "Rechazado por X motivo")
		Assert.assertTrue(administrador.jugadoresRechazados.size == (len + 1))
	}

	@Test
	def void adminRechazaPropuestaNoExisteProduceError() {
		val len = jugador.amigos.size
		var amigoQueNoEsta = "amigoNoEsta@hotmail.com"

		try {
			administrador.rechazarPropuesta(amigoQueNoEsta, "Rechazado por X motivo")
			Assert.fail("No se puede rechazar propuesta que no existe")
		} catch (NoExisteTalJugadorException e) {
			Assert.assertNotSame(jugador.amigos.size, len + 1)
		}
	}

}
