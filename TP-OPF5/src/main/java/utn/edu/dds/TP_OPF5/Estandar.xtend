package utn.edu.dds.TP_OPF5

class Estandar extends Object implements TipoInscripcion{
	
	override inscribirA(Jugador jugador, Partido partido) {
		partido.inscribirA(jugador) //Asi no se hace, hay que validar que si hay 10 en ese caso si alguno es solidario,
									//y recien ahi decirle a partido que agregue al jugador. (Cambiar nombre del metodo)
									//no olvidar en la interface
									//Seria: partido.estaLLenaLaLista, partido.haySolidario, partido.agregaJugador(Jugador jugador, TipoInscripcion estandar)
									
	}
	
}