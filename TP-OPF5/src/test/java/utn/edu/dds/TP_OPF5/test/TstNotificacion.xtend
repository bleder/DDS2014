package utn.edu.dds.TP_OPF5.test

import org.junit.Before
import org.junit.Test
import org.junit.Assert
import static org.mockito.Mockito.*
import utn.edu.dds.TP_OPF5.Jugador
import utn.edu.dds.TP_OPF5.Partido
import utn.edu.dds.TP_OPF5.Estandar
import utn.edu.dds.TP_OPF5.Condicional
import utn.edu.dds.TP_OPF5.Solidaria
import utn.edu.dds.TP_OPF5.Notificador
import utn.edu.dds.TP_OPF5.MailSender
import exception.PartidoCompletoExcepcion
import exception.PartidoNoCumpleCondicionesExcepcion
import utn.edu.dds.TP_OPF5.PartidoConfirmadoObserver
import utn.edu.dds.TP_OPF5.AmigoObserver

class TstNotificacion {
	
	var Jugador jugador
	var Partido partido
	var Estandar tipoIncEstandar
	var MailSender mockMailSender
	
	@Before
	def void init() {
		jugador = new Jugador("Rodolfo")
		var administrador = new Jugador("Juan Administrador")
		administrador.setMail("juan.administrador@aol.com")
		partido = new Partido("Partido_1", new MailSender, administrador)
		tipoIncEstandar = new Estandar()
		mockMailSender= mock (typeof(MailSender))
	}
	
	@Test
	def void notificaAlAdministradorJugadoresNecesariosParaPartidoConfirmados(){
		var partObse = new PartidoConfirmadoObserver
		partido.notificador=mockMailSender
		partido.agregarObserver(partObse)
		partido.setMaximoLista = 1
		partido.agregarJugador(jugador, tipoIncEstandar)
		partido.confirmarJugador(jugador)
		verify(mockMailSender,times(1)).notificar(partido.administrador.mail, "Partido completo")
	}
	
	@Test
	def void notificaAlAdministradorDejaDeTenerJugadoresNecesariosParaPartidoConfirmados(){
		var partObse = new PartidoConfirmadoObserver
		partido.notificador=mockMailSender
		partido.agregarObserver(partObse)
		partido.setMaximoLista = 1
		partido.agregarJugador(jugador, tipoIncEstandar)
		partido.confirmarJugador(jugador)
		partido.darBajaA(jugador)
		verify(mockMailSender,times(1)).notificar(partido.administrador.mail, "Partido ya no completo")
	}
	
	@Test
	def void notificaAmigosDeJugadorAlInscribirse(){
		partido.notificador=mockMailSender
		var amigo = new AmigoObserver("amigo@aol.com", mockMailSender)
		amigo.agregarAmigo(jugador)
		partido.agregarObserver(amigo)
		jugador.inscribite(partido, tipoIncEstandar)
		verify(mockMailSender,times(1)).notificar("amigo@aol.com", "Tu amigo se inscribio")
	}
}