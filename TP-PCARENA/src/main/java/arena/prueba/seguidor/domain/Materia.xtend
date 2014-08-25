package arena.prueba.seguidor.domain


import org.uqbar.commons.model.Entity
import org.uqbar.commons.utils.Observable


@Observable
class Materia extends Entity {
	@Property String nombre
	@Property int anio
	@Property Boolean finalAprobado = false
	@Property String profe
	@Property Object ubicacion

	
	
}