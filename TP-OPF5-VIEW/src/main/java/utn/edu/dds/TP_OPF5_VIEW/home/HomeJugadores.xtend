package utn.edu.dds.TP_OPF5_VIEW.home

import org.uqbar.commons.utils.Observable
import org.uqbar.commons.model.CollectionBasedHome
import partido.core.Jugador
import java.util.List
import java.util.Random

@Observable
class HomeJugadores extends CollectionBasedHome<Jugador> {

	new() {
		this.init
	}

	def void init() {
		this.create("Rodolfo", "rodol@yahoo.com")
		this.create("Pepita", "pepita22@aol.com")
		this.create("Julian", "br@hotmail.com")
		this.create("Romina", "romis@aol.com")
		this.create("Franco", "romifran@aol.com")
		this.create("Lucho", "lu@hotmail.com")
		this.create("Fede", "fede@hotmail.com")
		this.create("Mica", "Mica@hotmail.com")
		this.create("Carolina", "romi@yahoo.es")
		
	}

	def void create(String nom, String mail) {
		var jugador = new Jugador(nom, mail)
		jugador.nivelJuego = new Random().nextInt(11) //le doy num aleatorios (0 a 11) para probar el color
		this.create(jugador)
	}
	
	def List<Jugador> getJugadores() {
		allInstances	
	}

	def search(String nombre, String apodo) {
		allInstances.filter[jug|(this.matchComienza(nombre, jug.nombre))&& (this.matchApodo(apodo, jug.nombre))].toList
	}
	
	//TODO: Hacer refactor de metodos Match cuando se pueda
	def matchApodo(Object expectedValue, Object realValue) {
		if (expectedValue == null) {
			return true
		}
		if (realValue == null) {
			return false
		}
		realValue.toString().toLowerCase().contains(expectedValue.toString().toLowerCase())

	}

	def matchComienza(Object expectedValue, Object realValue) { //todo: Validar que solo permita 1 letra
		if (expectedValue == null) {
			return true
		}
		if (realValue == null) {
			return false
		}
		realValue.toString().toLowerCase().charAt(0)==expectedValue.toString().toLowerCase().charAt(0)
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