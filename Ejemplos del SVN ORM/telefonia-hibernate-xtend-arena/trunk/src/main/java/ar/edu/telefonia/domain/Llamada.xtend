package ar.edu.telefonia.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne
import org.uqbar.commons.utils.Observable

@Entity
@Observable
class Llamada {
	Long id
	Abonado origen
	Abonado destino
	Integer duracion

	/**
	 * ***********************************************************
	 *      INICIO EXTRAS MANUALES QUE NECESITA HIBERNATE        *
	 *************************************************************
	 */
	@Id @GeneratedValue
	def Long getId() {
		id
	}
	
	@ManyToOne 
	def Abonado getOrigen() {
		origen	
	}
	
	@ManyToOne
	def Abonado getDestino() {
		destino
	}
	
	@Column 
	def Integer getDuracion() {
		duracion
	}
	
	def void setId(Long unId) {
		id = unId
	}
	
	def void setOrigen(Abonado unOrigen) {
		origen = unOrigen
	}
	
	def void setDestino(Abonado unDestino) {
		destino = unDestino
	}
	
	def void setDuracion(Integer unaDuracion) {
		duracion = unaDuracion
	}

	new() {
		origen = null
		destino = null
		duracion = new Integer(0)
	}
	
	/**
	 * ***********************************************************
	 *        FIN EXTRAS MANUALES QUE NECESITA HIBERNATE         *
	 *************************************************************
	 */
	 
	new(Abonado unOrigen, Abonado unDestino, Integer unaDuracion) {
		origen = unOrigen
		destino = unDestino
		duracion = unaDuracion
	}
	
}
