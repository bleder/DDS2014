package utn.edu.dds.TP_OPF5.test

import org.junit.Before
import partido.generacionEquipos.Ordenador
import partido.core.Jugador
import partido.core.Partido
import partido.nuevosJugadores.Administrador
import org.junit.Test
import java.util.List
import java.util.ArrayList
import org.junit.Assert
import partido.core.tiposDeInscripcion.TipoInscripcion
import partido.core.tiposDeInscripcion.Estandar

class TstOrdenador {
	
	
	Ordenador ordenador
	Partido partido
	Jugador jugador1
	Jugador jugador2
	List<Jugador> jugadores
	TipoInscripcion inscripcion
	
	@Before
	def void init() {
		jugadores = new ArrayList
		ordenador = new Ordenador
		jugador1 = new Jugador("", "")
		jugador2 = new Jugador("", "")
		partido = new Partido("", new Administrador(""))
		inscripcion = new Estandar
		
		
		jugador1.handicap = 7
		jugador2.handicap = 3
		
		jugador1.jugarPartido(partido)
		jugador2.jugarPartido(partido)
		
		jugadores.add(jugador2)
		jugadores.add(jugador1)
		jugador1.inscribite(partido, inscripcion)
		jugador2.inscribite(partido, inscripcion)
		
		jugador2.calificarA(jugador1, partido, 7, "")
		jugador1.calificarA(jugador2, partido, 3, "")
	}
	
	@Test
	def seOrdenaBienPorHandicap(){
		ordenador.agregarCriterioHandicap()
		val listaOrdenada = ordenador.buildListaOrdenada(jugadores)
		Assert.assertEquals(listaOrdenada.get(0), jugador1)
		Assert.assertEquals(listaOrdenada.get(1), jugador2)
	}
	
	@Test
	def seOrdenaBienPorUltimoPartido(){
		ordenador.agregarCriterioPromedioUltimoPartido()
		val listaOrdenada = ordenador.buildListaOrdenada(jugadores)
		Assert.assertEquals(listaOrdenada.get(0), jugador1)
		Assert.assertEquals(listaOrdenada.get(1), jugador2)
	}
	
	@Test
	def seOrdenaBienPorMix(){
		ordenador.agregarCriterioPromedioUltimoPartido()
		ordenador.agregarCriterioHandicap()
		val listaOrdenada = ordenador.buildListaOrdenada(jugadores)
		Assert.assertEquals(listaOrdenada.get(0), jugador1)
		Assert.assertEquals(listaOrdenada.get(1), jugador2)
	}
	
	@Test
	def seOrdenaBienPorUltimasCalificaciones(){
		ordenador.agregarCriterioUltimasCalificaciones(1)
		val listaOrdenada = ordenador.buildListaOrdenada(jugadores)
		Assert.assertEquals(listaOrdenada.get(0), jugador1)
		Assert.assertEquals(listaOrdenada.get(1), jugador2)
	}
}