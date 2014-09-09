package wicket.prueba.seguidor.wicket

import org.uqbar.commons.utils.Observable

@Observable
class EditarMateria {
	
	@Property Materia materiaSeleccionada
	@Property String materiaNombre
	
	new(Materia materia) {
		materiaSeleccionada = materia
		materiaNombre = materia.nombre
	}
	
	//No se si esta bien esto, peguenme
	//Ante cualquier cosa, si esta bien, falta el resto de los atributos
	def void modificarMateria() {
		materiaSeleccionada.nombre = materiaNombre
	}
}