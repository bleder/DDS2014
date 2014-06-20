package utn.edu.dds.TP_OPF5.test

import org.junit.Before
import org.junit.Test
import org.junit.Assert
import partido.core.Jugador
import partido.core.Partido
import partido.core.tiposDeInscripcion.Estandar
import partido.nuevosJugadores.Administrador


class TstCommand {
	
	var Jugador jugador
	var Partido partido
	var Estandar tipoIncEstandar
	var Jugador jugador1
	var Jugador jugador2
	
	@Before
	def void init() {
	jugador = new Jugador("Rodolfo", "rodol@aol.com")
	partido = new Partido("Partido_1", new Administrador("admin@aol.com"))
	tipoIncEstandar = new Estandar()
	jugador.inscribite(partido,tipoIncEstandar)
	jugador1 = new Jugador("Ricardo", "ricky@aol.com")
	jugador1.inscribite(partido, tipoIncEstandar)
	
	jugador2 = new Jugador("Ricardo2", "ricky@aol.com")
	jugador2.inscribite(partido, tipoIncEstandar)
		
	}
	
	/* 
@Test


*/
}