package arena.prueba.seguidor.domain

import org.uqbar.commons.utils.Observable
import org.uqbar.commons.model.Entity
import java.util.Date

@Observable
class Nota extends Entity {
	@Property Date fecha 
	@Property String descripcion
	@Property Boolean aprobada = false
	
	
}