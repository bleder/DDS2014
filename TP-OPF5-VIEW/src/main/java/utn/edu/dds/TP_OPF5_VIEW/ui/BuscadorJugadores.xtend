
package utn.edu.dds.TP_OPF5_VIEW.ui

import partido.core.Jugador
import java.io.Serializable
import java.util.ArrayList
import java.util.List
import utn.edu.dds.TP_OPF5_VIEW.home.HomeJugadores
import org.uqbar.commons.utils.ApplicationContext

class BuscadorJugadores implements Serializable {

	@Property String nombre
	@Property String apodo
	@Property String desdeHasta
	@Property String valorHandicap
	@Property List<Jugador> resultados


	def void search() { 
		resultados = new ArrayList<Jugador>
		
		resultados = getHomeJugadores().search(getNombre,getApodo,getDesdeHasta,getValorHandicap)
	}

	def void clear() {
		nombre = null
		apodo = null
		desdeHasta = null
		valorHandicap = null
	}

	def HomeJugadores getHomeJugadores() {
		ApplicationContext::instance.getSingleton(typeof(Jugador))
	}

}

