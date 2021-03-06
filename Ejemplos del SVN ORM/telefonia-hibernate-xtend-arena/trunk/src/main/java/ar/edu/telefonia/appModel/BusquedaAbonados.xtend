package ar.edu.telefonia.appModel

import ar.edu.telefonia.domain.Abonado
import org.uqbar.commons.utils.Observable

@Observable
class BusquedaAbonados {
	@Property String nombreDesde
	@Property String nombreHasta
	@Property boolean soloMorosos
	
	new() {
		clear()	
	}
	
	def cumple(Abonado abonado) {
		(!ingresoNombreDesde || abonado.nombre >= nombreDesde) && 
		(!ingresoNombreHasta || abonado.nombre <= nombreHasta) &&
		(!soloMorosos || abonado.esMoroso)
	}
	
	def clear() {
		nombreDesde = ""
		nombreHasta = ""
		soloMorosos = false
	}

	def ingresoNombreDesde() {
		nombreDesde != null && !nombreDesde.equals("")
	}
	
	def ingresoNombreHasta() {
		nombreHasta != null && !nombreHasta.equals("")
	}
	
}