package partido.core

import org.uqbar.commons.model.Entity

class Infraccion extends Entity {
	@Property
	private String fecha
	@Property
	private String motivo
	
	new(String motivoInf) {
		motivo=motivoInf
	}
	 	def vencer() {
		false
	}
}