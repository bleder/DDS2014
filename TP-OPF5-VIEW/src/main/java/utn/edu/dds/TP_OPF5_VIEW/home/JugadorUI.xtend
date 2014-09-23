package utn.edu.dds.TP_OPF5_VIEW.home

import partido.core.Jugador
import org.uqbar.commons.model.Entity

class JugadorUI extends Entity {
	@Property 
	Jugador jugador
	@Property 
	int cantidadDePartidos
	@Property 
	int promedioUltimoPartido
	@Property 
	int promedioTodosLosPartidos
	
	new(Jugador jugador){
		this.jugador=jugador
		//this.cantidadDePartidos=jugador.cantidadPartidosJugados()
		//this.promedioUltimoPartido=jugador.promedioDeCalificacionesUltimoPartido()
		//this.promedioTodosLosPartidos=jugador.promedioDeCalificaciones(cantidadDePartidos)
		
	}
}