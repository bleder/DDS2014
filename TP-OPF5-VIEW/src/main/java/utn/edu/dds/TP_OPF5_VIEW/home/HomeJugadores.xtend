package utn.edu.dds.TP_OPF5_VIEW.home

import org.uqbar.commons.utils.Observable
import org.uqbar.commons.model.CollectionBasedHome
import partido.core.Jugador
import java.util.List
import java.util.Random
import partido.core.Infraccion

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
		this.create("Sofia", "laSofi@yahoo.es")
		
	}

	def void create(String nom, String mail) {
		var jugador = new Jugador(nom, mail)
		jugador.nivelJuego = new Random().nextInt(11) //le doy num aleatorios (0 a 11) para probar el color
		agregarAmigos(jugador)
		agregarInfracciones(jugador)
		this.create(jugador)
	}
	
	def agregarAmigos(Jugador jugador){
		jugador.agregarAmigo("lucas@gmail.com")
		jugador.agregarAmigo("pepeLocura@hotmail.com")
		jugador.agregarAmigo("Rodo@hotmail.com")
	}
	
	def agregarInfracciones(Jugador jugador){
		var infraccion1= new Infraccion("No inscribio bien a su amigo")
		var infraccion2= new Infraccion("Fallo al partido")
		var infraccion3= new Infraccion("Su amigo fallo al partido")
		infraccion1.fecha="23/09/2014"
		infraccion2.fecha="20/09/2014"
		infraccion3.fecha="20/08/2014"
		jugador.nuevaInfraccion(infraccion1)
		jugador.nuevaInfraccion(infraccion2)
		jugador.nuevaInfraccion(infraccion2)
	}
	
	def List<Jugador> getJugadores() {
		allInstances	
	}

	def search(String nombre, String apodo,String desdeHasta, String valorHandicap) {
		allInstances.filter[jug|(this.matchComienza(nombre, jug.nombre))&& (this.matchApodo(apodo, jug.nombre)) && matchDesdeHastaHandicap(valorHandicap, jug.nivelJuego, desdeHasta)].toList
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
	
	
	def matchDesdeHastaHandicap(Object expectedValue, Object realValue, String eleccion) {
		if (expectedValue == null) {
			return true
		}
		if (realValue == null) {
			return false
		}
		
		if(eleccion=="desde")
			(Integer.parseInt((expectedValue.toString())))<=(Integer.parseInt(realValue.toString()))
		else
			(Integer.parseInt((expectedValue.toString())))>=(Integer.parseInt(realValue.toString()))
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