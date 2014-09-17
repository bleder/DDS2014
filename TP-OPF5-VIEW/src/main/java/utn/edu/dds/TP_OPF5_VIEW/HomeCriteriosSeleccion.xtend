package utn.edu.dds.TP_OPF5_VIEW

import org.uqbar.commons.model.CollectionBasedHome
import divisionEquipo.Divisor
import org.uqbar.commons.utils.Observable

@Observable
class HomeCriteriosSeleccion  extends CollectionBasedHome<Divisor> {
	
	new() {
		this.init()
	}
	
	def init() {
		
	}
	
	override protected getCriterio(Divisor arg0) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override createExample() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getEntityType() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}