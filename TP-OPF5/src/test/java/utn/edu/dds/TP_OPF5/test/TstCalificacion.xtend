package utn.edu.dds.TP_OPF5.test

import org.junit.Before
import org.junit.Test
import org.junit.Assert
import partido.core.Jugador
import partido.core.Partido
import partido.core.tiposDeInscripcion.Estandar
import partido.nuevosJugadores.Administrador
import exception.JugadorNoPerteneceAlPartido
import exception.NotaIncorrecta
import exception.YaLoCalifique
import exception.MeCalificoAMiMismo

class TstCalificacion {

	var Jugador jugador
	var Partido partido
	var Estandar tipoIncEstandar
	var Jugador jugadorCalificado

	@Before
	def void init() {
		jugador = new Jugador("Rodolfo", "rodol@aol.com")
		partido = new Partido("Partido_1", new Administrador("admin@aol.com"))
		tipoIncEstandar = new Estandar()
		jugador.inscribite(partido, tipoIncEstandar)
		jugadorCalificado = new Jugador("Ricardo", "ricky@aol.com")
		jugadorCalificado.inscribite(partido, tipoIncEstandar)

	}

	@Test
	def void sePuedeCalificarAJugadorSoloConNota() {
		val len = jugadorCalificado.calificaciones.size
		jugador.calificarA(jugadorCalificado, partido, 9, null)

		Assert.assertEquals(jugadorCalificado.calificaciones.size, len + 1)
	}

	@Test
	def void sePuedeCalificarAJugadorConNotaYMensaje() {
		val len = jugadorCalificado.calificaciones.size
		jugador.calificarA(jugadorCalificado, partido, 9, "La gambeta que tiro en el minuto 20 fue impresionante")

		Assert.assertEquals(jugadorCalificado.calificaciones.size, (len + 1))
	}

	@Test
	def void noSePuedeCalificarAJugadorConNotaIncorrecta() {

		try {
			jugador.calificarA(jugadorCalificado, partido, 25, null)
			Assert.fail("No se puede calificar a jugador con que no este entre 1 y 10")
		} catch (NotaIncorrecta e) {
			Assert.assertTrue(jugadorCalificado.calificaciones.empty)
		}

	}

	@Test
	def void noSePuedeCalificarAJugadorQueNoExisteEnPartido() {
		var jugadorNoEstaEnPartido = new Jugador("Robert", "Robert22@aol.com")

		try {
			jugador.calificarA(jugadorNoEstaEnPartido, partido, 9, null)
			Assert.fail("No se puede calificar a jugador que no existe")
		} catch (JugadorNoPerteneceAlPartido e) {
			Assert.assertTrue(jugadorCalificado.calificaciones.empty)
		}
	}

	@Test
	def void noSePuedeCalificarAlMismoJugadorDosVecesParaUnMismoPartido() {
		jugador.calificarA(jugadorCalificado, partido, 9, null)

		try {
			jugador.calificarA(jugadorCalificado, partido, 9, null)
			Assert.fail("No se puede calificar dos veces al mismo jugador")
		} catch (YaLoCalifique e) {
			Assert.assertEquals(jugadorCalificado.calificaciones.size, 1)
		}
	}

	@Test
	def void NoSePuedeCalificarAUnoMismo() {

		try {
			jugador.calificarA(jugador, partido, 9, null)
			Assert.fail("No se puede calificar a uno mismo")
		} catch (MeCalificoAMiMismo e) {
			Assert.assertTrue(jugadorCalificado.calificaciones.empty)
		}
	}

}
