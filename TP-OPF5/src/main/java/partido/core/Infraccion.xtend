package partido.core

import org.uqbar.commons.model.Entity
import java.io.Serializable

class Infraccion extends Entity implements Serializable {
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