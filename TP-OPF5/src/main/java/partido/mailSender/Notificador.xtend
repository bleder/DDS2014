package partido.mailSender

interface Notificador {
	def void notificar(String mail, String mensaje)
}