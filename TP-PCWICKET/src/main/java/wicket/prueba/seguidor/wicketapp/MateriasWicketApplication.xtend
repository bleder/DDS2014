
package wicket.prueba.seguidor.wicketapp

import org.apache.wicket.protocol.http.WebApplication
import wicket.prueba.seguidor.wicket.IniciarMateriasPage
import org.uqbar.commons.utils.ApplicationContext
import wicket.prueba.seguidor.wicket.Materia
import wicket.prueba.seguidor.wicket.HomeMaterias

class MateriasWicketApplication extends WebApplication {
	
	override protected init() {
		super.init()
		ApplicationContext.instance.configureSingleton(Materia, new HomeMaterias)
	}
	
	override getHomePage() {
		return IniciarMateriasPage

	}
	
}