package arena.prueba.seguidor.domain

import org.uqbar.commons.utils.Observable
import org.uqbar.commons.model.Entity

@Observable
class Nota extends Entity {
	@Property int fecha // pasar a Date
	@Property String descripcion
	@Property Boolean aprobada = false
	
	
}