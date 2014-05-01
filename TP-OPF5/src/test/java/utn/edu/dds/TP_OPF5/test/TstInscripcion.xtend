package utn.edu.dds.TP_OPF5.test

import org.junit.Before
import org.junit.Test
import org.junit.Assert
import utn.edu.dds.TP_OPF5.Jugador
import utn.edu.dds.TP_OPF5.Partido
import utn.edu.dds.TP_OPF5.Estandar
import utn.edu.dds.TP_OPF5.Condicional
import utn.edu.dds.TP_OPF5.Solidaria

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
		tipoIncCondicional = new Condicional()
		tipoIncSolidaria = new Solidaria()

	}


	//Caso 1: Inscribir jugador con modo inscripcion estandar lista del partido <10
	@Test
	def void inscribirJugadorModoEstandarListaMenor10() {

		Assert.assertTrue(jugador.inscribite(partido, tipoIncEstandar))
	}

	//Caso 2: Inscribir jugador con modo inscripcion estandar lista del partido >10
	@Test
	def void noSePuedeInscribirUnJugadorCuandoElPartidoEstaCompleto() {
		var Partido partidoCompleto = this.crearPartidoCompleto()

		Assert.assertFalse(jugador.inscribite(partidoCompleto, tipoIncEstandar))
	}

	def crearPartidoCompleto() {
		val Partido completo = new Partido("Hola" )
		completo.maximoLista = 0
		completo
	}

	@Test
	//Caso 3: Inscribir jugador con modo inscripcion solidaria lista del partido <10	
	def void inscribirJugadorModoSolidarioListaMenor10() {

		Assert.assertTrue(jugador.inscribite(partido, tipoIncSolidaria))
	}

	@Test
	//Caso 4 : Inscribir jugador con modo inscripcion solidaria lista del partido >10	
	def void inscribirJugadorModoSolidarioListaMayor10() {

		Assert.assertFalse(jugador.inscribite(partido, tipoIncSolidaria))
	}

	@Test
	//Caso 5 : Inscribir jugador con modo inscripcion condicional cumple condicion	
	def void inscribirJugadorModoCondicionalCumpleCondicion() {

		Assert.assertTrue(jugador.inscribite(partido, tipoIncCondicional))
	}

	@Test
	//Caso 6 : Inscribir jugador con modo inscripcion condicional no cumple condicion	
	def void inscribirJugadorModoCondicionalNoCumpleCondicion() {

		Assert.assertFalse(jugador.inscribite(partido, tipoIncCondicional))
	}

	@Test
	//Caso 7: Inscribir jugador con modo inscripcion estandar lista del partido >10 con un jugador solidario
	def void inscribirJugadorModoEstandarListaMayor10ConUnSolidario() {

		Assert.assertTrue(jugador.inscribite(partido, tipoIncEstandar))
	}

	@Test
	def void testInscribirUnEstandarEnUnPartidoCompletoConDosSolidariosInscribeAlStandardYDejaAfueraAlUltimoSolidario() {

		Assert.assertTrue(jugador.inscribite(partido, tipoIncEstandar))
	}
}
