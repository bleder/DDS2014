package arena.prueba.seguidor.runnable

import org.uqbar.arena.Application

import org.uqbar.commons.utils.ApplicationContext
import arena.prueba.seguidor.domain.Materia
import arena.prueba.seguidor.home.HomeMaterias
import arena.prueba.seguidor.ui.IniciarMateriasWindow

class SeguidorApplication extends Application {
	

	def static main(String[] args) {
		new SeguidorApplication().start
	}
	
		override createMainWindow() {
		ApplicationContext.instance.configureSingleton(typeof(Materia), new HomeMaterias)
		new IniciarMateriasWindow(this)
	}
}
