package utn.edu.dds.TP_OPF5.test
import org.junit.Before
import org.junit.Test
import org.junit.Assert
import static org.mockito.Mockito.*
import exception.PartidoCompletoExcepcion
import exception.PartidoNoCumpleCondicionesExcepcion
import partido.core.Jugador
import partido.core.Partido
import partido.core.tiposDeInscripcion.Estandar
import partido.core.tiposDeInscripcion.Condicional
import partido.core.tiposDeInscripcion.Solidaria
import partido.mailSender.MailSender
import partido.nuevosJugadores.Administrador
import exception.JugadorNoPerteneceAlPartido
import exception.NotaIncorrecta

class TstCalificacion {
	
	var Jugador jugador
	var Partido partido
	var Estandar tipoIncEstandar
	var Jugador jugadorCalificado
	@Before
	def void init() {
	jugador = new Jugador("Rodolfo", "rodol@aol.com")
	partido = new Partido("Partido_1", new MailSender, new Administrador("admin@aol.com"))
	tipoIncEstandar = new Estandar()
	jugador.inscribite(partido,tipoIncEstandar)
	jugadorCalificado = new Jugador("Ricardo", "ricky@aol.com")
	jugadorCalificado.inscribite(partido, tipoIncEstandar)
		
	}
	
@Test

def void calificarAJugadorSoloConNota(){
	val len = jugadorCalificado.calificaciones.size
	jugador.calificarA(jugadorCalificado,partido,9,null)
	
	Assert.assertTrue(jugadorCalificado.calificaciones.size==(len+1))
}	

@Test

def void calificarAJugadorConNotaYMensaje(){
	val len = jugadorCalificado.calificaciones.size
	jugador.calificarA(jugadorCalificado,partido,9,"La gambeta que tiro en el minuto 20 fue impresionante")
	
	Assert.assertTrue(jugadorCalificado.calificaciones.size==(len+1))
}	

@Test

def void calificarAJugadorConNotaIncorrectaSeProduceError(){
	val len = jugadorCalificado.calificaciones.size
	
	try{
		jugador.calificarA(jugadorCalificado,partido,25,null)
	} catch(NotaIncorrecta e){
		Assert.assertFalse(jugadorCalificado.calificaciones.size==(len+1))
		return
	}
	Assert.assertFalse(true)
}

@Test

def void calificarAJugadorQueNoExisteEnPartidoProduceError(){
	val len = jugadorCalificado.calificaciones.size
	var jugadorNoEstaEnPartido = new Jugador("Robert", "Robert22@aol.com")
	
	try{
		jugador.calificarA(jugadorNoEstaEnPartido,partido,9,null)
	} catch(JugadorNoPerteneceAlPartido e){
		Assert.assertFalse(jugadorCalificado.calificaciones.size==(len+1))
		return
	}
	Assert.assertFalse(true)
}

}