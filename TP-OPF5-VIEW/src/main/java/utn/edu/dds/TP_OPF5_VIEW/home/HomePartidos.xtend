package utn.edu.dds.TP_OPF5_VIEW.home

import org.uqbar.commons.model.CollectionBasedHome
import partido.core.Partido
import java.util.List
import partido.nuevosJugadores.Administrador
import org.uqbar.commons.utils.ApplicationContext
import partido.core.Jugador

class HomePartidos extends CollectionBasedHome<Partido> {
	
	new(){
		val Partido part = new Partido("Hola", new Administrador("martin@aol.com"))
		part.jugadoresHome = getJugadores()
		this.create(part)
		
		val Partido part2 = new Partido("partido2", new Administrador("martin@aol.com"))
		part2.jugadoresHome = getJugadores()
		this.create(part2)
	}
	
	def getJugadores() {
		(ApplicationContext::instance.getSingleton(typeof(Jugador)) as HomeJugadores).getJugadores()
	}
	
	
	def iniciar() {
		allInstances.toList
	}
	
	override protected getCriterio(Partido example) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override createExample() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getEntityType() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}