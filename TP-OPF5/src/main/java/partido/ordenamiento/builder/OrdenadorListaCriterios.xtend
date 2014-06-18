package partido.ordenamiento.builder

import partido.core.Partido
import java.util.List

class OrdenadorListaCriterios extends OrdenadorLista {
	@Property
	List<OrdenadorLista> criterios
	override ordenar(Partido partido)
	{
		//COMO LE APLICO TODOS LOS CRITERIOS????????
	}	
}