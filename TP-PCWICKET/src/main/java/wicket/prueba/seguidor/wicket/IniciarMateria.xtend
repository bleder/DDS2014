package wicket.prueba.seguidor.wicket


import java.io.Serializable
import java.util.List
import org.uqbar.commons.utils.ApplicationContext
import java.util.ArrayList
import wicket.prueba.seguidor.wicket.Materia
import wicket.prueba.seguidor.wicket.HomeMaterias
import wicket.prueba.seguidor.wicket.Nota


@org.uqbar.commons.utils.Observable
class IniciarMateria implements Serializable {


	@Property List<Materia> resultados
	@Property Materia materiaSeleccionada
	@Property Nota notaSeleccionada

	
	def void iniciar() { 
		resultados = new ArrayList<Materia>
		resultados = getHomeMaterias().iniciar()
	}


	def HomeMaterias getHomeMaterias() {
		ApplicationContext.instance.getSingleton(typeof(Materia))
	}
	
	def void eliminarMateriaSeleccionada() {
		getHomeMaterias().delete(materiaSeleccionada)
		this.iniciar()
		materiaSeleccionada = null
	}

}

