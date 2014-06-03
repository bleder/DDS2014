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

class TstNuevosJugadores {

	var Jugador jugador
	var Partido partido
	var Administrador administrador
	var String amigo
	
	@Before
	def void init() {
		jugador = new Jugador("Rodolfo", "rodol@aol.com")
		administrador = new Administrador("admin@aol.com")
		partido = new Partido("Partido_1", administrador)
		amigo = "amigo@amail.com"
		jugador.agregarAmigo(amigo)
	}

	@Test
	def void jugadorCreaPropuestaLaPoseeElAdministrador() {
		jugador.crearPropuesta(amigo,partido.administrador)
		Assert.assertTrue(partido.administrador.existePropuesta(amigo))
	}
	
	@Test
	def void JugadorCreaPropuestaNoExisteAmigoProduceError(){
		val len = partido.administrador.posiblesJugadores.size
		var amigoQueNoEsta = "amigoNoEsta@hotmail.com"
	
		try{
			jugador.crearPropuesta(amigoQueNoEsta,administrador)
		} catch(NoExisteMailException e){
			Assert.assertFalse(partido.administrador.posiblesJugadores.size==(len+1))
			return
		}
		Assert.assertFalse(true)
}

	@Test
	def void adminAceptaPropuestaYJugadorLoPoseeEntreSusAmigos(){
		jugador.crearPropuesta(amigo,partido.administrador)
		partido.administrador.aceptarPropuesta(amigo, "pepe", new ArrayList)
		Assert.assertTrue(jugador.existeAmigo(amigo))
	}
	
	@Test
	def void adminAceptaPropuestaNoExisteProduceError(){
		val len = jugador.amigos.size
		var amigoQueNoEsta = "amigoNoEsta@hotmaill.com"
	
		try{
			administrador.aceptarPropuesta(amigoQueNoEsta,"pepe", new ArrayList)
		} catch(NoExisteTalJugadorException e){
			Assert.assertFalse(jugador.amigos.size==(len+1))
			return
		}
		Assert.assertFalse(true)
}
	
	
	@Test
	def void adminRechazaPropuestaYRegistraLaDenegacion(){
		val len = administrador.jugadoresRechazados.size
		jugador.crearPropuesta(amigo,partido.administrador)
		partido.administrador.rechazarPropuesta(amigo, "Rechazado por X motivo" )
		Assert.assertTrue(administrador.jugadoresRechazados.size ==(len +1))
	}
	
	@Test
	def void adminRechazaPropuestaNoExisteProduceError(){
		val len = jugador.amigos.size
		var amigoQueNoEsta = "amigoNoEsta@hotmail.com"
	
		try{
			administrador.rechazarPropuesta(amigoQueNoEsta,"pepe")
		} catch(NoExisteTalJugadorException e){
			Assert.assertFalse(jugador.amigos.size==(len+1))
			return
		}
		Assert.assertFalse(true)
}
	
 
}
