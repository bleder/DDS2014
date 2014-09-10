package arena.prueba.seguidor.applicationModel

import arena.prueba.seguidor.domain.Materia
import arena.prueba.seguidor.domain.Nota
import arena.prueba.seguidor.home.HomeMaterias
import java.io.Serializable
import java.util.ArrayList
import java.util.List
import org.uqbar.commons.utils.ApplicationContext

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
	
	def agregarNota(Nota nota) {
		this.materiaSeleccionada.notas.add(nota)
	}
	
	def notaParaEdicion() {
		if(this.notaSeleccionada != null){
			notaSeleccionada
		}else{
			var nota =new Nota
			this.agregarNota(nota)
			nota   
		}
	}

}
