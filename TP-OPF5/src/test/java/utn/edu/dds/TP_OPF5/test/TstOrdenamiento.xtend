package utn.edu.dds.TP_OPF5.test

import java.util.List
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import partido.core.Jugador
import partido.core.Partido
import partido.core.tiposDeInscripcion.Estandar
import partido.nuevosJugadores.Administrador
import partido.ordenamiento.Handicap
import java.util.ArrayList
import partido.ordenamiento.PromedioCalificaciones
import partido.core.Inscripcion

class TstOrdenamiento {

	var Jugador jugador1
	var Jugador jugador2
	var Jugador jugador3
	var Jugador jugador4

	var Handicap handicap
	var PromedioCalificaciones promcalif
	var Partido partido
	var Partido partido2
	var Estandar tipoIncEstandar
	var List<Jugador> jugadores = new ArrayList
	var Inscripcion i

	@Before
	def void init() {

		partido = new Partido("Partido_1", new Administrador("admin@aol.com"))
		partido2 = new Partido("Partido_2", new Administrador("admin2@aol.com"))
		tipoIncEstandar = new Estandar()
		initJugadores()
		initCalificacion()
		handicap = new Handicap(partido)
		promcalif= new PromedioCalificaciones(partido)

	}

	def initJugadores() {
		jugador1 = new Jugador("Rodolfo", "rodol@aol.com")
		jugador2 = new Jugador("Pepe", "pepe@gmail.com")
		jugador3 = new Jugador("Carlos", "carlos@gmail.com")
		jugador4 = new Jugador("Lucas", "lucas@gmail.com")

		jugador1.inscribite(partido, tipoIncEstandar)
		jugador1.inscribite(partido2, tipoIncEstandar)
		jugador2.inscribite(partido, tipoIncEstandar)
		jugador2.inscribite(partido2, tipoIncEstandar)
		jugador3.inscribite(partido, tipoIncEstandar)
		jugador3.inscribite(partido2, tipoIncEstandar)
		jugador4.inscribite(partido, tipoIncEstandar)
		jugador4.inscribite(partido2, tipoIncEstandar)

		jugador1.nivelJuego = 5
		jugador2.nivelJuego = 2
		jugador3.nivelJuego = 8
		jugador4.nivelJuego = 1
	}
	
	def initCalificacion(){
		
		jugador2.calificarA(jugador1, partido, 9, null)
		jugador3.calificarA(jugador1, partido, 9, null)
		jugador4.calificarA(jugador1, partido, 5, null)
		jugador4.calificarA(jugador1, partido2, 10, null)
		
		jugador1.calificarA(jugador2, partido, 2, null)
		jugador3.calificarA(jugador2, partido, 4, null)
		jugador4.calificarA(jugador2, partido, 7, null)
		jugador4.calificarA(jugador2, partido2, 1, null)
		
		jugador1.calificarA(jugador3, partido, 1, null)
		jugador2.calificarA(jugador3, partido, 1, null)
		jugador4.calificarA(jugador3, partido, 1, null)
		jugador4.calificarA(jugador3, partido2, 1, null)
		
		jugador1.calificarA(jugador4, partido, 5, null)
		jugador2.calificarA(jugador4, partido, 8, null)
		jugador3.calificarA(jugador4, partido, 1, null)
		jugador3.calificarA(jugador4, partido2, 9, null)
		
	}
	@Test
	def void SePuedeOrdenarJugadoresDePartidoPorHandiCap() {
		jugadoresEnOrdenPorHandicap()
		partido.ordenamiento = handicap
		partido.partidoOrdenaJugadores(handicap)
		Assert.assertArrayEquals(partido.jugadoresInscriptos.map[inscripcion|inscripcion.jugador], jugadores)
	}
	
	@Test
	def void SePuedeOrdenarJugadoresDePartidoPorPromedioDeTodasLasCalificaciones() {
		jugadoresEnOrdenPorPromedioDeTodasLasCalificaciones()
		partido.ordenamiento = promcalif
		partido.partidoOrdenaJugadores(handicap)
		Assert.assertArrayEquals(partido.jugadoresInscriptos.map[inscripcion|inscripcion.jugador], jugadores)
	}
	
	@Test
	def void sePuedeOrdenarJugadoresDePartidoPorPromedioDe3Calificaciones(){
		
	}
	
	@Test
	def void sePuedeOrdenarJugadoresDePartidoPorMixDeCriterios(){
		
		
	}

	@Test
	def void seObtieneElPromedioDeTodasLasCalificacionesDeUnJugador() {
		jugador1.partidosJugados.add(partido)
		jugador1.partidosJugados.add(partido2)
		Assert.assertEquals(jugador1.promedioDeCalificacionesUltimoPartido(), 5)
	}

	@Test
	def void seObtieneElPromedioDe3LasCalificacionesDeUnJugador() {
		Assert.assertEquals(jugador1.promedioDeCalificaciones(3), 9 + 9 + 5)
	}
	


	def jugadoresEnOrdenPorHandicap() {

		jugadores.add(jugador4)
		jugadores.add(jugador2)
		jugadores.add(jugador1)
		jugadores.add(jugador3)

	}
	
	def jugadoresEnOrdenPorPromedioDeTodasLasCalificaciones(){
		jugadores.add(jugador3)
		jugadores.add(jugador2)
		jugadores.add(jugador4)
		jugadores.add(jugador1)
	}

}
