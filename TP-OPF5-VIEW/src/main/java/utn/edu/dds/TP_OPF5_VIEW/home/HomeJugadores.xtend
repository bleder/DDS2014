package utn.edu.dds.TP_OPF5_VIEW.home

import org.uqbar.commons.utils.Observable
import org.uqbar.commons.model.CollectionBasedHome
import partido.core.Jugador


@Observable
class HomeJugadores extends CollectionBasedHome<JugadorUI> {

	new() {
		this.init
	}

	def void init() {
		this.create("Rodolfo", "rodol@yahoo.com")
		this.create("Pepita", "pepita22@aol.com")
		this.create("Julian", "br@hotmail.com")
		this.create("Romina", "romi@aol.com")
		
	}

	def void create(String nom, String mail) {
		var jugador = new JugadorUI(new Jugador(nom,mail))
		this.create(jugador)
	}

	def search() {
		//todo: hacer
	}

	override def getEntityType() {
		typeof(JugadorUI)
	}
	
	override protected getCriterio(JugadorUI example) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override createExample() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}



}