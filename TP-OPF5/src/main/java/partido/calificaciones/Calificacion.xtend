package partido.calificaciones

import partido.core.Jugador
import partido.core.Partido


class Calificacion {
	/* @Property*/
	int id_calificacion
	/* @Property*/
	private String critica
	@Property
	private Jugador jugadorQueCalifico
	@Property
	private Partido partido	
	/* @Property*/
	int nota
	
	new() {}
	new(String string, Jugador jugador, Partido partidop, int i) {
		critica=string
		jugadorQueCalifico=jugador
		partido=partidop
		nota=i
	}
	
	def setId_calificacion(int id_calificacion){
		this.id_calificacion=id_calificacion
	}
	
	def getId_calificacion(){
		this.id_calificacion
	}
	
	def setCritica(String critica){
		this.critica=critica
	}
	
	def getCritica(){
		this.critica
	}
	
	def setNota(int nota){
		this.nota=nota
	}
	
	def getNota(){
		this.nota
	}

	
	
}