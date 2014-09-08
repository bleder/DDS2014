
package wicket.prueba.seguidor.wicketapp

import org.apache.wicket.protocol.http.WebApplication
import wicket.prueba.seguidor.wicket.IniciarMateriasPage


class MateriasWicketApplication extends WebApplication {
	
	override protected init() {
		super.init()
		//ApplicationContext.instance.configureSingleton(Modelo, new HomeModelos)
		//ApplicationContext.instance.configureSingleton(Celular, new HomeCelulares)
	}
	
	override getHomePage() {
		return IniciarMateriasPage

	}
	
}