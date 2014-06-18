package partido.ordenamiento.builder

import partido.core.Partido

class OrdenadorPorHandicap extends OrdenadorLista {
	override ordenar(Partido partido)
	{
		partido.jugadoresInscriptos.sortBy(inscripcion|inscripcion.jugador.handicap)
	}	
}