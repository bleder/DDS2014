package utn.edu.dds.TP_OPF5.test

import org.junit.Before
import org.junit.Test
import org.junit.Assert
import static org.mockito.Mockito.*
import partido.core.Jugador
import partido.core.Partido
import partido.core.tiposDeInscripcion.Estandar
import partido.mailSender.MailSender
import partido.observers.PartidoConfirmadoObserver
import partido.observers.AmigosObserver
import partido.nuevosJugadores.Administrador

class TstNotificacion {
	
	var Jugador jugador
	var Partido partido
	var Estandar tipoIncEstandar
	var MailSender mockMailSender
	
	@Before
	def void init() {
		jugador = new Jugador("Rodolfo", "rodol@aol.com")
		var administrador = new Administrador("admin@aol.com")
		administrador.setMail("juan.administrador@aol.com")
		partido = new Partido("Partido_1", administrador)
		tipoIncEstandar = new Estandar()
		mockMailSender= mock (typeof(MailSender))
	}
	
	@Test
	def void notificaAlAdministradorJugadoresNecesariosParaPartidoConfirmados(){
		var partObse = new PartidoConfirmadoObserver(mockMailSender)
		partido.agregarObserver(partObse)
		partido.set_maximoLista(1)
		partido.agregarJugador(jugador, tipoIncEstandar)
		partido.confirmarJugador(jugador)
		verify(mockMailSender,times(1)).notificar(partido.administrador.mail, "Partido completo")
	}
	
	@Test
	def void notificaAlAdministradorDejaDeTenerJugadoresNecesariosParaPartidoConfirmados(){
		var partObse = new PartidoConfirmadoObserver(mockMailSender)
		partido.agregarObserver(partObse)
		partido.set_maximoLista(1)
		partido.agregarJugador(jugador, tipoIncEstandar)
		partido.confirmarJugador(jugador)
		partido.darBajaA(jugador)
		verify(mockMailSender,times(1)).notificar(partido.administrador.mail, "Partido completo")
		verify(mockMailSender,times(1)).notificar(partido.administrador.mail, "Partido ya no completo")
	}
	
	@Test
	def void partidoNoConfirmadoCuandoEstaVacio(){
		Assert.assertFalse(partido.estasConfirmado())
	}
	
	@Test
	def void notificaAmigosDeJugadorAlInscribirse(){
		var amigo = new AmigosObserver(mockMailSender)
		jugador.agregarAmigo("ricky@aol.com")
		partido.agregarObserver(amigo)
		jugador.inscribite(partido, tipoIncEstandar)
		verify(mockMailSender,times(1)).notificar("ricky@aol.com", "Se inscribio tu amigo Rodolfo")
	}
	
	@Test
	def void jugadorSeDaDeBajaPartidoNoCompleto() {
		var partObse = new PartidoConfirmadoObserver(mockMailSender)
		partido.set_maximoLista(2)
		partido.agregarObserver(partObse)
		partido.agregarJugador(jugador, tipoIncEstandar)
		partido.confirmarJugador(jugador)
		partido.darBajaA(jugador)
		verify(mockMailSender,times(0)).notificar(partido.administrador.mail, "Partido completo")
		verify(mockMailSender,times(0)).notificar(partido.administrador.mail, "Partido ya no completo")
	}
}