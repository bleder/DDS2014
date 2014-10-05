
package utn.edu.dds.TP_OPF5_VIEW.runnable

import org.apache.wicket.protocol.http.WebApplication
import utn.edu.dds.TP_OPF5_VIEW.home.HomeJugadores
import partido.core.Jugador
import org.uqbar.commons.utils.ApplicationContext
import utn.edu.dds.TP_OPF5_VIEW.ui.OFHomePage
import partido.core.Partido
import utn.edu.dds.TP_OPF5_VIEW.home.HomePartidos

class WicketApplication extends WebApplication {
	
	override protected init() {
		super.init()
		ApplicationContext.instance.configureSingleton(Jugador, new HomeJugadores)
		ApplicationContext.instance.configureSingleton(Partido, new HomePartidos)
	}
	
	override getHomePage() {
		return OFHomePage

	}
	
	

}