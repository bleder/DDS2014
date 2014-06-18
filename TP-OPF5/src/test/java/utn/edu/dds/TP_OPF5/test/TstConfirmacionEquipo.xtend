package utn.edu.dds.TP_OPF5.test

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import partido.core.Jugador
import partido.core.Partido
import partido.core.tiposDeInscripcion.Estandar
import partido.nuevosJugadores.Administrador
import exception.PartidoYaConfirmado
import exception.PartidoConfirmadoNoAceptaBaja
import exception.NoSeRealizoDivisionDeEquipos

class TstConfirmacionEquipo {
	var Jugador jugador1
	var Jugador jugador2
	var Partido partido
	var Estandar tipoIncEstandar

	@Before
	def void init() {

		partido = new Partido("Partido_1", new Administrador("admin@aol.com"))

		tipoIncEstandar = new Estandar()
		initJugadores()

	}

	def initJugadores() {
		jugador1 = new Jugador("Rodolfo", "rodol@aol.com")
		jugador2 = new Jugador("Pepe", "pepe@gmail.com")

		jugador1.inscribite(partido, tipoIncEstandar)
		jugador2.inscribite(partido, tipoIncEstandar)
		partido.confirmarJugador(jugador1)
		partido.confirmarJugador(jugador2)

	}

	@Test
	def void sePuedeConfirmarEquipoQueAlcanzaMaximoDeJugadoresYSeRealizoDivisionDeEquipos() {
		partidoParaConfirmar()
		partido.confirmate()
		Assert.assertTrue(partido.confirmadoAdm)
	}
		def partidoParaConfirmar() {
		partido.maximoLista = 2
		partido.equipo1.add(jugador1)
		partido.equipo2.add(jugador2)
	}

		def partidoYaConfirmadoConDivisionEquipos() {
		partido.maximoLista = 2
		partido.equipo1.add(jugador1)
		partido.equipo2.add(jugador2)
		partido.confirmadoAdm = true
	}
	@Test
	def void noSePuedeConfirmarEquipoQueNoSeRealizoDivisionDeEquipos() {
		partido.maximoLista = 2
		try {
			partido.confirmate()
			Assert.fail("No se realizo division de equipos, no se puede confirmar partido")
		} catch (NoSeRealizoDivisionDeEquipos e) {
			Assert.assertFalse(partido.confirmadoAdm)
		}
	}

	@Test
	def void noSePuedeConfirmarEquipoQueSeYaEstaConfirmado() {
		partidoYaConfirmadoConDivisionEquipos()
		try {
			partido.confirmate()
			Assert.fail("El partido se encuentra confirmado no se puede realizar division de equipos")
		} catch (PartidoYaConfirmado e) {
			Assert.assertTrue(partido.confirmadoAdm)
		}
	}

	@Test
	def void noSePuedeDarDeBajaJugadorDeUnPartidoConfirmadoPorAdm() {
		partidoParaConfirmar()
		partido.confirmate()
		try {
			partido.darBajaA(jugador1)
			Assert.fail("No se puede dar de baja si el partido esta confirmado")
		} catch (PartidoConfirmadoNoAceptaBaja e) {
			Assert.assertTrue(partido.estasConfirmado())
		}

	}

	@Test
	def void noSePuedeDarDeBajaAJugadorAunqueSePongaReemplazanteDeUnPartidoConfirmadoPorAdm() {
		partidoParaConfirmar()
		partido.confirmate()
		try {
			partido.darBajaA(jugador1, jugador2, tipoIncEstandar)
			Assert.fail("No se puede dar de baja si el partido esta confirmado")
		} catch (PartidoConfirmadoNoAceptaBaja e) {
			Assert.assertTrue(partido.estasConfirmado())
		}

	}




}
