package utn.edu.dds.TP_OPF5_VIEW

import org.apache.wicket.protocol.http.WebApplication
import utn.edu.dds.TP_OPF5_VIEW.home.HomeJugadores
import partido.core.Jugador
import org.uqbar.commons.utils.ApplicationContext

class WicketApplication extends WebApplication {
	
	override protected init() {
		super.init()
		ApplicationContext.instance.configureSingleton(Jugador, new HomeJugadores)
	}
	
	override getHomePage() {
		return OFHomePage

	}
	
}