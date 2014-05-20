package utn.edu.dds.TP_OPF5.test

import org.junit.Before
import org.junit.Test
import org.junit.Assert
import static org.mockito.Mockito.*
import utn.edu.dds.TP_OPF5.Jugador
import utn.edu.dds.TP_OPF5.Partido
import utn.edu.dds.TP_OPF5.Estandar
import utn.edu.dds.TP_OPF5.Condicional
import utn.edu.dds.TP_OPF5.Solidaria
import utn.edu.dds.TP_OPF5.Notificador
import utn.edu.dds.TP_OPF5.MailSender
import exception.PartidoCompletoExcepcion
import exception.PartidoNoCumpleCondicionesExcepcion

class TstInscripcion {

	var Jugador jugador
	var Partido partido
	var Estandar tipoIncEstandar
	var Condicional tipoIncCondicional
	var Solidaria tipoIncSolidaria
	var MailSender mockMailSender
	
	@Before
	def void init() {
		jugador = new Jugador("Rodolfo")
		partido = new Partido("Partido_1", new Notificador?, new Jugador("Juan Administra"))
		tipoIncEstandar = new Estandar()
		tipoIncCondicional = new Condicional([Partido part | true])
		tipoIncSolidaria = new Solidaria()
		mockMailSender= mock (typeof(MailSender))
		
		
	}
	


	@Test
	def void inscribirJugadorModoEstandarConLugar() {
		jugador.inscribite(partido, tipoIncEstandar)
		Assert.assertTrue(partido.estaInscripto(jugador))
	}

	@Test
	def void noSePuedeInscribirUnJugadorCuandoElPartidoEstaCompleto() {
		var Partido partidoCompleto = this.crearPartidoCompleto()
		try {
			jugador.inscribite(partidoCompleto, tipoIncEstandar)
		} catch(PartidoCompletoExcepcion e) {
			Assert.assertFalse(partidoCompleto.estaInscripto(jugador))
			return
		}
		Assert.assertFalse(true)
	}

	def crearPartidoCompleto() {
		val Partido completo = new Partido("Hola", new Notificador?, new Jugador("Juan Administra"))
		completo.maximoLista = 0
		completo
	}

	@Test	
	def void inscribirJugadorModoSolidarioConLugar() {
		jugador.inscribite(partido, tipoIncSolidaria)
		Assert.assertTrue(partido.estaInscripto(jugador))
	}

	@Test
	def void inscribirJugadorModoSolidarioSinLugar() {
		var Partido partidoCompleto = this.crearPartidoCompleto()
		try {
			jugador.inscribite(partidoCompleto, tipoIncSolidaria)
		} catch(PartidoCompletoExcepcion e) {
			Assert.assertFalse(partidoCompleto.estaInscripto(jugador))
			return
		}
		Assert.assertFalse(true)
	}

	@Test
	def void inscribirJugadorModoCondicionalCumpleCondicion() {
		jugador.inscribite(partido, tipoIncCondicional)
		Assert.assertTrue(partido.estaInscripto(jugador))
	}

	@Test	
	def void inscribirJugadorModoCondicionalNoCumpleCondicion() {
		tipoIncCondicional.setCondicion([Partido part | false])
		var Partido partidoCompleto = this.crearPartidoCompleto()
		try {
			jugador.inscribite(partidoCompleto, tipoIncCondicional)
		} catch(PartidoNoCumpleCondicionesExcepcion e) {
			Assert.assertFalse(partidoCompleto.estaInscripto(jugador))
			return
		}
		Assert.assertFalse(true)
	}

	@Test
	def void jugadorEstandarTienePrioridadSobreSolidario() {
		var partido = new Partido("Cancha 2", new Notificador?, new Jugador("Juan Administra"))
		partido.maximoLista = 1
		(new Jugador("Roberto")).inscribite(partido, tipoIncSolidaria)
		jugador.inscribite(partido, tipoIncEstandar)
		Assert.assertTrue(partido.estaInscripto(jugador))
	}
	
	@Test
	def void notificaAmigosDeJugadorAlInscribirse(){
		//Revisar si a este caso no le falta algo mas
		partido.notificador=mockMailSender //Le asigno al partido que el notificador va a ser el MockMailSender
		jugador.inscribite(partido, tipoIncEstandar)//Se tiene que modificar el Inscribir para que notifique sino esto unca va a funcionar
		verify(mockMailSender,times(jugador.amigosJugador.size)).notificar(any(typeof(String)))
	}
	
	@Test
		def void notificaAlAdministradorJugadoresNecesariosParaPartidoConfirmados(){
		partido.notificador=mockMailSender
		//se pone el codigo que genera la notificación al administrador
		verify(mockMailSender,times(1)).notificar(partido.administrador.mail)
	}
	
	@Test
		def void notificaAlAdministradorDejaDeTenerJugadoresNecesariosParaPartidoConfirmados(){
		partido.notificador=mockMailSender
		//se pone el codigo que genera la notificación al administrador
		verify(mockMailSender,times(1)).notificar(partido.administrador.mail)
	}
	

}
