package utn.edu.dds.TP_OPF5.test

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import partido.core.Jugador
import repo.RepoJugadores

class TstRepoJug {

	Jugador walter
	Jugador jhon
	RepoJugadores repoJugadores

	@Before
	def init() {
		repoJugadores = RepoJugadores.instance

		walter = new Jugador => [
			nombre = "Walter White"
			mail = "walter@walter.com"
		]

		jhon = new Jugador => [
			nombre = "jhons"
			mail = "jhons@jhons.com"
		]

		repoJugadores.actualizarJugador(walter)
		repoJugadores.actualizarJugador(jhon)

	}



	@Test
	def void mailDeWalter() {
		var walterWhiteBD = repoJugadores.getJugador(walter)
		var mailDeWalter = walterWhiteBD.mail
		Assert.assertEquals(mailDeWalter,"walter@walter.com")
	}

}
