package arena.prueba.seguidor.domain

import org.uqbar.commons.utils.Observable
import java.util.Date
import java.math.BigDecimal
import java.util.List

@Observable
class Materia {
	@Property String nombre
	@Property BigDecimal anio
	@Property Boolean finalAprobado = false
	@Property Date fecha
	@Property String profesor
	@Property Object ubicacion

	
	
}