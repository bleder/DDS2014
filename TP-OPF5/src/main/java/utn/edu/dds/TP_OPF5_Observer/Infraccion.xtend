package utn.edu.dds.TP_OPF5_Observer

class Infraccion {
	@Property
	private String fecha
	@Property
	private String motivo
	
	new(String motivoInf) {
		motivo=motivoInf
	}
	 	def vencer() {
		false
	}
}