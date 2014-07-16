package partido.nuevosJugadores

import partido.core.Jugador
import java.util.List
import exception.NoExisteMailException

class PropuestaBuilder {
	@Property
	String mailPropuesto
	@Property
	Jugador amigo
	@Property
	String nombre
	@Property
	List<String> mailsAmigos
	
	def conAmigoDelPropuesto(Jugador amigoQuePropuso){
		this.amigo=amigoQuePropuso
	}
	
	def conMail(String mail){
		this.mailPropuesto=mail
	}

	def conAmigos(List<String> mailsAmigos){
		this.mailsAmigos=mailsAmigos
	}
	
	def conNombre(String nombre){
		this.nombre=nombre
	}
	
	def build() {
		if (!amigo.existeAmigo(mailPropuesto)) {
			throw new NoExisteMailException("El jugador no tiene a ese amigo")
		}
		var propuesta = new Propuesta(mailPropuesto, amigo, nombre, mailsAmigos)
		propuesta
	}
	
	
}