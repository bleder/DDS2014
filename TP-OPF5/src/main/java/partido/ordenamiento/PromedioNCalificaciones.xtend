package partido.ordenamiento

import partido.core.Partido
import java.util.ArrayList
import partido.core.Inscripcion
import java.util.List
import partido.core.Jugador

class PromedioNCalificaciones extends Ordenamiento {
	var List<Inscripcion> incripcionesOrdenadas = new ArrayList
	@Property
	int n
	
	new(Partido partido, int n) {
		super(partido)
		this.n=n
	}
	
	override ordenar(Jugador jugador) {
		jugador.promedioDeCalificaciones(n)
//		incripcionesOrdenadas=partido.jugadoresInscriptos.sortBy[jugador.promedioDeCalificaciones(n)]
//		partido.jugadoresInscriptos=incripcionesOrdenadas
	}
	
}