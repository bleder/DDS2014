package partido.ordenamiento.builder

import partido.core.Partido

class OrdenadorNUltimasCalificaciones extends OrdenadorLista {
	@Property
	int n
	override ordenar(Partido partido)
	{
		partido.jugadoresInscriptos.sortBy(inscripcion|inscripcion.jugador.promedioNCalificaciones(n))
	}	
}