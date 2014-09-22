package utn.edu.dds.TP_OPF5_VIEW.home

import org.uqbar.commons.utils.Observable
import org.uqbar.commons.model.CollectionBasedHome
import partido.core.Jugador
import java.util.List

@Observable
class HomeJugadores extends CollectionBasedHome<Jugador> {

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
		var jugador = new Jugador(nom, mail)
		this.create(jugador)
	}
	
	def List<Jugador> getJugadores() {
		allInstances	
	}

	def search() {
		//todo: hacer
	}

	
	override protected getCriterio(Jugador example) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override createExample() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getEntityType() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}



}