package arena.prueba.seguidor.applicationModel


import java.io.Serializable
import java.util.List
import org.uqbar.commons.utils.ApplicationContext
import java.util.ArrayList
import arena.prueba.seguidor.domain.Materia
import arena.prueba.seguidor.home.HomeMaterias
import arena.prueba.seguidor.domain.Nota


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

}
