package partido.nuevosJugadores

class Rechazo {
	
	
	@Property
	String razon
	@Property
	Propuesta propuesta
	
	new(String laRazon, Propuesta propuestaRechazada) {
		razon = laRazon
		propuesta = propuestaRechazada
	}
}