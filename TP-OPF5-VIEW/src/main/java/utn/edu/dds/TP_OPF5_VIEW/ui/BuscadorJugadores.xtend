
package utn.edu.dds.TP_OPF5_VIEW.ui

import partido.core.Jugador
import java.io.Serializable
import java.util.ArrayList
import java.util.List
import utn.edu.dds.TP_OPF5_VIEW.home.HomeJugadores
import org.uqbar.commons.utils.ApplicationContext
import java.util.Date

class BuscadorJugadores implements Serializable {

	@Property String nombre
	@Property String apodo
	@Property String desdeHastaHandicap
	@Property String desdeHastaPromUltimo
	@Property String conSinInfracciones
	@Property String valorHandicap
	@Property String valorPromUltimo
	@Property String fechaTope
	@Property List<Jugador> resultados


	def void search() { 
		resultados = new ArrayList<Jugador>
		
		resultados = getHomeJugadores().search(getNombre,getApodo,getDesdeHastaHandicap,getValorHandicap,getConSinInfracciones,getDesdeHastaPromUltimo, getValorPromUltimo,fechaTope)
	}

	def void clear() {
		nombre = null
		apodo = null
		desdeHastaHandicap = null
		desdeHastaPromUltimo = null
		valorHandicap = null
		valorPromUltimo = null
		conSinInfracciones = null
		fechaTope = null
	}

	def HomeJugadores getHomeJugadores() {
		ApplicationContext::instance.getSingleton(typeof(Jugador))
	}

}

