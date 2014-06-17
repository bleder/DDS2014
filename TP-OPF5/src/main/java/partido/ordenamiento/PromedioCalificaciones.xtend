package partido.ordenamiento

import partido.core.Inscripcion
import java.util.ArrayList
import partido.core.Partido
import java.util.List
import partido.core.Jugador

class PromedioCalificaciones extends Ordenamiento {
	
	var List<Inscripcion> incripcionesOrdenadas = new ArrayList

	new(Partido partido) {
		super(partido)
	}
	
	override ordenar(Jugador jugador) {
		jugador.promedioDeCalificacionesUltimoPartido()
//		incripcionesOrdenadas=partido.jugadoresInscriptos.sortBy[jugador.promedioDeCalificaciones]
//		partido.jugadoresInscriptos=incripcionesOrdenadas
	}
}