package utn.edu.dds.TP_OPF5.test

import org.junit.Before
import org.junit.Test
import org.junit.Assert
import static org.mockito.Mockito.*
import exception.PartidoCompletoExcepcion
import exception.PartidoNoCumpleCondicionesExcepcion
import partido.core.Jugador
import partido.core.Partido
import partido.core.tiposDeInscripcion.Estandar
import partido.core.tiposDeInscripcion.Condicional
import partido.core.tiposDeInscripcion.Solidaria
import partido.mailSender.MailSender

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
		partido = new Partido("Partido_1", new MailSender, new Jugador("Juan Administra"))
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
		val Partido completo = new Partido("Hola", new MailSender, new Jugador("Juan Administra"))
		completo.maximoLista = 0
		completo
	}
	
	@Test
	def void jugadorSeDaDeBajaYDejaReemplazante() {
		var jugador2 = new Jugador("Ricardo")
		partido.agregarJugador(jugador, tipoIncEstandar)
		partido.darBajaA(jugador, jugador2, tipoIncEstandar)
		
		Assert.assertTrue(partido.estaInscripto(jugador2) && !partido.estaInscripto(jugador))
	}
	
	@Test
	def void jugadorSeDaDeBajaSinReemplazanteRecibeInfraccion() {
		partido.agregarJugador(jugador, tipoIncEstandar)
		partido.darBajaA(jugador)
		Assert.assertTrue(jugador.infracciones.size==1)
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
		var partido = new Partido("Cancha 2", new MailSender, new Jugador("Juan Administra"))
		partido.maximoLista = 1
		(new Jugador("Roberto")).inscribite(partido, tipoIncSolidaria)
		jugador.inscribite(partido, tipoIncEstandar)
		Assert.assertTrue(partido.estaInscripto(jugador))
	}

}
