package partido.calificaciones

import partido.core.Partido
import partido.core.Jugador
import exception.JugadorNoPerteneceAlPartido
import exception.YaLoCalifique
import exception.NotaIncorrecta
import exception.MeCalificoAMiMismo

class ClasificacionBuilder {
	@Property
	Partido partido
	@Property
	int nota
	@Property
	String critica
	@Property
	Jugador calificador
	@Property
	Jugador calificado
	
	 def Calificacion  build() {
		if (! partido.estaInscripto(calificado)) {
			throw new JugadorNoPerteneceAlPartido("No esta ese jugador en el partido")
		}
		
		if (calificado.calificaciones.exists[calificacion|
			(calificacion.jugadorQueCalifico == calificador) && (calificacion.partido == partido)]) {
			throw new YaLoCalifique("Ya califique a este jugador")
		}
		if (nota < 1 || nota > 10) {
			throw new NotaIncorrecta("La nota ingresada no es correcta")
		}

		if (calificado == calificador) {
			throw new MeCalificoAMiMismo("No puedo calificarme a mi mismo")
		}
	
		new Calificacion(critica, calificador, partido, nota)		
	}
	
	def conPartido(Partido partido) {
		this.partido = partido
	}
	
	def conNota(int nota){
		this.nota=nota
	}
	
	def conCritica(String critica){
		this.critica=critica
	}
	
	def conCalificador(Jugador calificador){
		this.calificador=calificador
	}
	
	def conCalificado(Jugador calificado){
		this.calificado=calificado
	}
	
	
	
}

	
