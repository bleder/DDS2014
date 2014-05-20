package utn.edu.dds.TP_OPF5.test

import org.junit.Before
import org.junit.Test
import org.junit.Assert
import org.mockito.Mockito
import utn.edu.dds.TP_OPF5.Jugador
import utn.edu.dds.TP_OPF5.Partido
import utn.edu.dds.TP_OPF5.Estandar
import utn.edu.dds.TP_OPF5.Condicional
import utn.edu.dds.TP_OPF5.Solidaria
import exception.PartidoCompletoExcepcion
import exception.PartidoNoCumpleCondicionesExcepcion

class TstInscripcion {

	var Jugador jugador
	var Partido partido
	var Estandar tipoIncEstandar
	var Condicional tipoIncCondicional
	var Solidaria tipoIncSolidaria

	@Before
	def void init() {
		jugador = new Jugador("Rodolfo")
		partido = new Partido("Partido_1")
		tipoIncEstandar = new Estandar()
		tipoIncCondicional = new Condicional([Partido part | true])
		tipoIncSolidaria = new Solidaria()
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
		val Partido completo = new Partido("Hola" )
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
		var partido = new Partido("Cancha 2")
		partido.maximoLista = 1
		(new Jugador("Roberto")).inscribite(partido, tipoIncSolidaria)
		jugador.inscribite(partido, tipoIncEstandar)
		Assert.assertTrue(partido.estaInscripto(jugador))
	}
	

}
