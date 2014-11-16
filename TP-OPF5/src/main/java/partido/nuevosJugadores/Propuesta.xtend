package partido.nuevosJugadores

import partido.core.Jugador
import java.util.List

class Propuesta {
	
	/*@Property*/
	int id_propuesta
	/*@Property*/
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
	
	def setId_Propuesta(int id_propuesta){
		this.id_propuesta=id_propuesta
	}
	
	def getId_Propuesta(){
		this.id_propuesta
	}
	
	def setMail(String mail){
		this.mail=mail
	}
	
	def getMail(){
		this.mail
	}
}