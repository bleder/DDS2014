package ar.edu.futbol5.estado

import ar.edu.futbol5.excepciones.BusinessException

class Abierto implements Estado{
	
	override validar(){
		throw new BusinessException("Hubo un error")
	}
}