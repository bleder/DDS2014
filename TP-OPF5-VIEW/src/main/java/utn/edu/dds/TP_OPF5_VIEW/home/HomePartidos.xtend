package utn.edu.dds.TP_OPF5_VIEW.home

import org.uqbar.commons.model.CollectionBasedHome
import partido.core.Partido
import java.util.List
import partido.nuevosJugadores.Administrador
import org.uqbar.commons.utils.ApplicationContext
import partido.core.Jugador

class HomePartidos extends CollectionBasedHome<Partido> {
	
	new(){
		val Partido part = new Partido("PartidoVerano", new Administrador("martin@aol.com"))
		part.jugadoresHome = getJugadores()
		part.jugadores=getJugadores()
		this.create(part)
		part.inscribiYConfirmarATodosLosJugadores()
		
		val Partido part2 = new Partido("PartidoPrimavera", new Administrador("martin@aol.com"))
		part2.jugadores=getJugadores()
		part2.jugadoresHome = getJugadores()
		this.create(part2)
		part2.inscribiYConfirmarATodosLosJugadores()
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