package partido.nuevosJugadores

import partido.core.Jugador

class Propuesta {
	
	@Property
	String mail
	@Property
	Jugador amigo
	
	new(String mailDado, Jugador amigoQueRecomendo) {
		mail = mailDado
		amigo = amigoQueRecomendo
	}
}