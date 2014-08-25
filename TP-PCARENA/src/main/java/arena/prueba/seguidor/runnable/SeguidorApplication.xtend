package arena.prueba.seguidor.runnable

import org.uqbar.arena.Application
import arena.prueba.seguidor.ui.CrearSeguidorWindow

class SeguidorApplication extends Application {
	
	override createMainWindow() {
		new CrearSeguidorWindow(this)
	}
	
	def static main(String[] args) {
		new SeguidorApplication().start
	}
}
