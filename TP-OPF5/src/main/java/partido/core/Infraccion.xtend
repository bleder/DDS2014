package partido.core

import org.uqbar.commons.model.Entity
import java.io.Serializable

class Infraccion extends Entity implements Serializable {
	/* @Property*/
	int id_infraccion
	/* @Property*/
	private String fecha
	/* @Property*/
	private String motivo
	
	new(String motivoInf) {
		motivo=motivoInf
	}
	 	def vencer() {
		false
	}
	
	def setId_infraccion(int id_infraccion){
		this.id_infraccion=id_infraccion
	}
	
	def getId_infraccion(){
		this.id_infraccion
	}
	
	def setFecha(String fecha){
		this.fecha=fecha
	}
	
	def getFecha(){
		this.fecha
	}
	
	def setMotivo(String motivo){
		this.motivo=motivo
	}
	
	def getMotivo(){
		this.motivo
	}
}