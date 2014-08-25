package arena.prueba.seguidor.domain

import org.uqbar.commons.utils.Observable
import java.util.Date

@Observable
class Materia {
	@Property Date fecha
	@Property String descripcion
	@Property Boolean aprobada = false



	
}