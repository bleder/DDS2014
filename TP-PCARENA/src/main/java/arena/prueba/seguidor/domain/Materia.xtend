package arena.prueba.seguidor.domain


import org.uqbar.commons.model.Entity
import org.uqbar.commons.utils.Observable
import java.util.List

@Observable
class Materia extends Entity {
	@Property String nombre
	@Property int anio
	@Property Boolean finalAprobado = false
	@Property String profe
	@Property String ubicacion
	@Property List<Nota> notas
	@Property Nota notaSeleccionada	
	
	val ubicaciones = #["1er Cuatrimestre", "2do Cuatrimestre", "Curso de verano"]
	
	
	def getUbicaciones() {
		ubicaciones.asObjects
	}
	
	def asObjects(List<?> list) {
		list.map[it as Object]
	}
}



	