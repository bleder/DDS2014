package partido.ordenamiento.builder

import partido.core.Partido

class OrdenadorPromedioCalifiUltPartido extends OrdenadorLista {
	override ordenar(Partido partido)
	{
		partido.jugadoresInscriptos.sortBy(inscripcion|inscripcion.jugador.promedioUltimoPartido)
	}
}