package utn.edu.dds.TP_OPF5.test

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import partido.core.Jugador
import repo.RepoJugadores
import java.io.Console

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
			nivelJuego = 2
			apodo = "papa"
			fechaNac = ""
		]

		jhon = new Jugador => [
			nombre = "jhons"
			mail = "jhons@jhons.com"
			nivelJuego = 2
			apodo = "papa"
			fechaNac = ""
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
