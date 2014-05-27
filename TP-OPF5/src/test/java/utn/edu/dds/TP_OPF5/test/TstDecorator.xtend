package utn.edu.dds.TP_OPF5.test

import org.junit.Before
import org.junit.Test
import org.junit.Assert
import static org.mockito.Mockito.*
import partido.core.Jugador
import partido.decorators.Partido
import partido.core.tiposDeInscripcion.Estandar
import partido.mailSender.MailSender
import partido.decorators.PartidoConfirmadoDecorator
import partido.decorators.PartidoEstabaConfirmado
import partido.decorators.AmigosDecorator

class TstDecorator {
	
	var Jugador jugador
	var Partido partido
	var Estandar inscripcion
	var MailSender mockMailSender
	
	@Before
	def void init(){
		jugador = new Jugador("Rodolfo", "rodol@aol.com")
		partido = new Partido("Partido_1", new MailSender, new Jugador("Juan Administra", "admin@aol.com"))
		inscripcion = new Estandar
		mockMailSender= mock (typeof(MailSender))
	}
	
	@Test
	def void notificaAlAdministradorJugadoresNecesariosParaPartidoConfirmados(){
		partido.setMaximoLista = 1
		var partDecorado = new PartidoConfirmadoDecorator(partido, mockMailSender)
		partDecorado.agregarJugador(jugador, inscripcion)
		partDecorado.confirmarJugador(jugador)
		verify(mockMailSender,times(1)).notificar(partido.administrador.mail, "Partido completo")
	}
	
	@Test
	def void notificaAlAdministradorDejaDeTenerJugadoresNecesariosParaPartidoConfirmados(){
		partido.setMaximoLista = 1
		var partDecorado = new PartidoEstabaConfirmado(partido, mockMailSender)
		partDecorado.agregarJugador(jugador, inscripcion)
		partDecorado.confirmarJugador(jugador)
		partDecorado.darBajaA(jugador)
		verify(mockMailSender,times(1)).notificar(partido.administrador.mail, "Partido ya no completo")
	}
	
	@Test
	def void partidoNoConfirmadoCuandoEstaVacio(){
		Assert.assertFalse(partido.estasConfirmado())
	}
	
	@Test
	def void notificaAmigosDeJugadorAlInscribirse(){
		var partDecorado = new AmigosDecorator(partido, mockMailSender)
		jugador.agregarAmigo(new Jugador("Ricardo", "ricky@aol.com"))
		partDecorado.agregarJugador(jugador, inscripcion)
		verify(mockMailSender,times(1)).notificar("ricky@aol.com", "Se inscribio tu amigo Rodolfo")
	}
}