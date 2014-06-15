package partido.nuevosJugadores

import partido.core.Jugador
import java.util.List

class Propuesta {
	
	@Property
	String mail
	@Property
	Jugador amigo
	@Property
	String nombre
	@Property
	List<String> mailsAmigos
	
	
	new(String mailDado, Jugador amigoQueRecomendo, String nom, List<String> mails) {
		mail = mailDado
		amigo = amigoQueRecomendo
		nombre = nom
		mailsAmigos = mails
		
	}
}