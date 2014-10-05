package utn.edu.dds.TP_OPF5_VIEW.ui

import partido.ordenamiento.Ordenamiento
import partido.core.Partido
import partido.ordenamiento.MixOrdenamiento

class OrdenamientosHandler {
	
	@Property Boolean handicap
	@Property Boolean promedioUltimo
	@Property Boolean checkUltimosN
	@Property String ultimosN
	
	def Ordenamiento dameCriterio(Partido partido) {
		var mixOrdenamiento= new MixOrdenamiento(partido)
		if (handicap) {
			mixOrdenamiento.agregarCriterioHandicap()		
		}
		if (promedioUltimo) {
			mixOrdenamiento.agregarCriterioPromedioUltimoPartido()
		}
		if ((checkUltimosN) && (ultimosN != null && ultimosN != "")){
			mixOrdenamiento.agregarCriterioNCalificaciones(Integer.parseInt(ultimosN))
		}
		
		mixOrdenamiento
	}
	
}