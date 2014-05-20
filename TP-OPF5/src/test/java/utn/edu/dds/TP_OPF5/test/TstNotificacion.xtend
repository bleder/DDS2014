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

class TstNotificacion {
	
	var Jugador jugador
	var Partido partido
	var Estandar tipoIncEstandar
	
	@Test
	def testNotificarPartidoLleno() {
		Assert.assertTrue(true)
	}
}