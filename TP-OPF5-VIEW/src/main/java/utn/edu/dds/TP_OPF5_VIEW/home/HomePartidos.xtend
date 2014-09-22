package utn.edu.dds.TP_OPF5_VIEW.home

import org.uqbar.commons.model.CollectionBasedHome
import partido.core.Partido
import java.util.List
import partido.nuevosJugadores.Administrador

class HomePartidos extends CollectionBasedHome<Partido> {
	
	new(){
		this.create(new Partido("Hola", new Administrador("martin@aol.com")))
		this.create(new Partido("partido2", new Administrador("martin@aol.com")))
	}
	
	override protected getCriterio(Partido arg0) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override createExample() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getEntityType() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	def iniciar() {
		allInstances.toList
	}
	
}