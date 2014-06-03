package partido.nuevosJugadores

class Rechazo {
	
	@Property
	String mail
	@Property
	String razon
	@Property
	Propuesta propuesta
	
	new(String elMail, String laRazon, Propuesta propuestaRechazada) {
		mail = elMail
		razon = laRazon
		propuesta = propuestaRechazada
	}
}