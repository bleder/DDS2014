package utn.edu.dds.TP_OPF5.test

import partido.core.Jugador
import java.util.List
import java.util.ArrayList
import org.junit.Before
import org.junit.Test
import partido.generacionEquipos.Armador
import org.junit.Assert
import partido.generacionEquipos.Equipo

class TstArmador {
	
	var List<Jugador> jugadores
	var Armador armador
	
	@Before
	def void init(){
		armador = new Armador
		jugadores = new ArrayList
		var i = 0
		while(i<10){
			jugadores.add(new Jugador("", ""))
			i = i + 1
		}
	}
	
	@Test
	def jugadoresBienDivididosParImpar(){
		val List<Equipo> equiposSeparados = armador.armarParImpar(jugadores)
		Assert.assertTrue(equiposSeparados.get(0).equipo.exists[it == jugadores.get(0)])
		Assert.assertTrue(equiposSeparados.get(0).equipo.exists[it == jugadores.get(2)])
		Assert.assertTrue(equiposSeparados.get(0).equipo.exists[it == jugadores.get(4)])
		Assert.assertTrue(equiposSeparados.get(0).equipo.exists[it == jugadores.get(6)])
		Assert.assertTrue(equiposSeparados.get(0).equipo.exists[it == jugadores.get(8)])
		Assert.assertTrue(equiposSeparados.get(1).equipo.exists[it == jugadores.get(1)])
		Assert.assertTrue(equiposSeparados.get(1).equipo.exists[it == jugadores.get(3)])
		Assert.assertTrue(equiposSeparados.get(1).equipo.exists[it == jugadores.get(5)])
		Assert.assertTrue(equiposSeparados.get(1).equipo.exists[it == jugadores.get(7)])
		Assert.assertTrue(equiposSeparados.get(1).equipo.exists[it == jugadores.get(9)])
	}
	
	@Test
	def jugadoresBienDivididosRandom(){
		val List<Equipo> equiposSeparados = armador.armarRandom(jugadores)
		Assert.assertTrue(equiposSeparados.get(0).equipo.exists[it == jugadores.get(0)])
		Assert.assertTrue(equiposSeparados.get(0).equipo.exists[it == jugadores.get(3)])
		Assert.assertTrue(equiposSeparados.get(0).equipo.exists[it == jugadores.get(4)])
		Assert.assertTrue(equiposSeparados.get(0).equipo.exists[it == jugadores.get(7)])
		Assert.assertTrue(equiposSeparados.get(0).equipo.exists[it == jugadores.get(8)])
		Assert.assertTrue(equiposSeparados.get(1).equipo.exists[it == jugadores.get(1)])
		Assert.assertTrue(equiposSeparados.get(1).equipo.exists[it == jugadores.get(2)])
		Assert.assertTrue(equiposSeparados.get(1).equipo.exists[it == jugadores.get(5)])
		Assert.assertTrue(equiposSeparados.get(1).equipo.exists[it == jugadores.get(6)])
		Assert.assertTrue(equiposSeparados.get(1).equipo.exists[it == jugadores.get(9)])
	}
}