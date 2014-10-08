
package utn.edu.dds.TP_OPF5_VIEW.ui

import java.io.Serializable
import java.util.List
import org.uqbar.commons.utils.ApplicationContext
import partido.core.Partido
import utn.edu.dds.TP_OPF5_VIEW.home.HomePartidos

@org.uqbar.commons.utils.Observable
class ListaPartidos implements Serializable {
	 
	@Property List<Partido> partidos
	
	
	def List<Partido> iniciar() {
		partidos = getHomePartidos().iniciar()
		partidos
	}
	
	def HomePartidos getHomePartidos() {
		ApplicationContext.instance.getSingleton(typeof(Partido))
	}
	
}
