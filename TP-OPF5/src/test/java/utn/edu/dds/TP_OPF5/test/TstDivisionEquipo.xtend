package utn.edu.dds.TP_OPF5.test

import divisionEquipo.DivParImpar
import divisionEquipo.DivPosiciones
import exception.PartidoNoPoseeCantidadMaxima
import exception.PartidoYaConfirmado
import java.util.ArrayList
import java.util.List
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import partido.core.Jugador
import partido.core.Partido
import partido.core.tiposDeInscripcion.Estandar
import partido.nuevosJugadores.Administrador

class TstDivisionEquipo {
	var Jugador jugador1
	var Jugador jugador2
	var Jugador jugador3
	var Jugador jugador4
	var Partido partido
	var Estandar tipoIncEstandar
	var List<Jugador> equipo1 = new ArrayList(2)
	var List<Jugador> equipo2 = new ArrayList(2)
	var DivParImpar divParImpar
	var DivPosiciones divPosiciones
	List<Integer> posiciones = new ArrayList()

	@Before
	def void init() {

		partido = new Partido("Partido_1", new Administrador("admin@aol.com"))
		partido.maximoLista = 4
		tipoIncEstandar = new Estandar()
		initJugadores()
		initDivision()
	}
	
	def initDivision() {
		divParImpar = new DivParImpar(partido)
		posiciones.add(0)
		posiciones.add(3)
		divPosiciones = new DivPosiciones(partido, posiciones)
	}

	def initJugadores() {
		jugador1 = new Jugador("Rodolfo", "rodol@aol.com")
		jugador2 = new Jugador("Pepe", "pepe@gmail.com")
		jugador3 = new Jugador("Carlos", "carlos@gmail.com")
		jugador4 = new Jugador("Lucas", "lucas@gmail.com")

		jugador1.inscribite(partido, tipoIncEstandar)
		jugador2.inscribite(partido, tipoIncEstandar)
		jugador3.inscribite(partido, tipoIncEstandar)
		jugador4.inscribite(partido, tipoIncEstandar)
		partido.confirmarJugador(jugador1)
		partido.confirmarJugador(jugador2)
		partido.confirmarJugador(jugador3)
		partido.confirmarJugador(jugador4)

	}

	@Test
	def void dividirEquiposPorPosicionParImpar() {
		partido.divisorEquipo = divParImpar
		equiposDivisionParImpar()
		partido.partidoDividiEquipos()
		Assert.assertArrayEquals(partido.equipo1, equipo1)
		Assert.assertArrayEquals(partido.equipo2, equipo2)
	}

	@Test
	def void dividirEquiposPorPosiciones1y3EnUnEquipo() {
		partido.divisorEquipo = divPosiciones
		equiposDivisionPosiciones1y3()
		partido.partidoDividiEquipos()
		Assert.assertArrayEquals(partido.equipo1, equipo1)
		Assert.assertArrayEquals(partido.equipo2, equipo2)
	}
	
	@Test
	def void noSePuedeDividirEquipoSiElPartidoNoTieneLaCantidadMaxDeJugadores(){
		
		partido.maximoLista = 10
		partido.divisorEquipo = divPosiciones
		try {
			partido.partidoDividiEquipos()
			Assert.fail("No se puede dividir equipos si no tiene la cantidad maxima de jugadores para partido")
		}catch(PartidoNoPoseeCantidadMaxima e){
			Assert.assertTrue(partido.equipo1.empty)
			Assert.assertTrue(partido.equipo2.empty)
		}
	}
	
	@Test
	def void noSePuedeDividirEquipoSiElYaEstaConfirmado(){
		partido.confirmadoAdm = true
		partido.divisorEquipo = divPosiciones
		try {
			partido.partidoDividiEquipos()
			Assert.fail("No se puede dividir equipos si el partido ya esta confirmado")
		}catch(PartidoYaConfirmado e){
			Assert.assertTrue(partido.equipo1.empty)
			Assert.assertTrue(partido.equipo2.empty)
		}
	}	

	def equiposDivisionParImpar() {
		equipo1.clear
		equipo1.add(jugador1)
		equipo1.add(jugador3)
		equipo2.clear
		equipo2.add(jugador2)
		equipo2.add(jugador4)

	}

	def equiposDivisionPosiciones1y3() {
		equipo1.clear
		equipo1.add(jugador1)
		equipo1.add(jugador4)
		equipo2.clear
		equipo2.add(jugador2)
		equipo2.add(jugador3)

	}

}
