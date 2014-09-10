package wicket.prueba.seguidor.wicket

import org.uqbar.commons.model.Entity
import org.uqbar.commons.utils.Observable
import java.util.List
import org.uqbar.commons.model.UserException

@Observable
class Materia extends Entity {
	@Property String nombre
	@Property int anio
	@Property Boolean finalAprobado = false
	@Property String profe
	@Property String ubicacion
	@Property List<Nota> notas
	@Property Nota notaSeleccionada	
	

	def asObjects(List<?> list) {
		list.map[it as Object]
	}
	
	def validar(){
		//TODO implementar
		
		if (getAnio <=1900 || getAnio>=2300) {
			throw new UserException("Debe ingresar número valido!!")
		}

		if (!this.ingresoNombre()) {
			throw new UserException("Debe ingresar un nombre de materia")
		}

	}
	
	def ingresoNombre() {
		 getNombre != null && !getNombre.trim().equals("")
	}
}



	