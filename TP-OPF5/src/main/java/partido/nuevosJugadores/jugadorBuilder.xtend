package partido.nuevosJugadores

import exception.NoExisteTalJugadorException
import partido.core.Jugador

class jugadorBuilder {
	@Property
	Propuesta propuesta
	@Property
	Administrador administrador
	
	def suAdministrador(Administrador administrador){
		this.administrador=administrador
	}
	
	def conPropuesta(Propuesta propuesta){
		this.propuesta=propuesta
	}
	
	def build() {
		if (!administrador.existePropuesta(propuesta)) {
			throw new NoExisteTalJugadorException("No existe propuesta para ese jugador")
		}
		var jugador =new Jugador(propuesta.nombre, propuesta.mail)
		jugador.agregarAmigo(propuesta.amigo.get_mail())
		
		jugador.amigos=propuesta.mailsAmigos
		
	}
}