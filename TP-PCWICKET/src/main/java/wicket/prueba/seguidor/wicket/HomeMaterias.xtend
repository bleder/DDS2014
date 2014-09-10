package wicket.prueba.seguidor.wicket


import java.util.List
import org.uqbar.commons.model.CollectionBasedHome
import org.uqbar.commons.utils.Observable
import org.apache.commons.collections15.Predicate;

import java.util.Date

@Observable
class HomeMaterias extends CollectionBasedHome<Materia> {

	new() {
		this.init
	}

	def void init() {
		this.create("Mate discreta", 2005, true, "Alejandra Isola","1er cuatrimestre")
		this.create("Paradigmas", 2009, false, "Spagariol","1er cuatrimestre")
		this.create("Algebra", 2009, true, "Monica perez","2do cuatrimestre")
		this.create("Sistemas operativos", 2009, false, "Scarfiello","Curso de Verano")
	}
	
	def void create(String nombre, int anio, boolean finalAprobado, String profe, String ubicacion) {
		var materia = new Materia
		materia.nombre = nombre
		materia.anio = anio
		materia.finalAprobado = finalAprobado
		materia.profe = profe
		materia.ubicacion=ubicacion
		
		var nota = new Nota
		nota.aprobada = true
		nota.fecha = new Date(2004,4,12)
		nota.descripcion = "Parcial A"
		
		var nota2 = new Nota
		nota2.aprobada = false
		nota2.fecha = new Date(2004,8,23)
		nota2.descripcion = "Parcialito"
		materia.notas = #[nota,nota2]
		this.create(materia)
	}

	override void validateCreate(Materia materia) {
		materia.validar()
	}

	def List<Materia> getMaterias() {
		allInstances	
	}
		
	def iniciar() {
		allInstances.toList
	}
		
	
	def Materia get(String nom) {
		getMaterias.findFirst [ materia | materia.getNombre.equals(nom) ]
	}

	override def Class<Materia> getEntityType() {
		typeof(Materia)
	}

	override def createExample() {
		new Materia()
	}

	override def Predicate<Materia> getCriterio(Materia example) {
		null
	}
	
	def add(Materia materia) {
		this.create(materia)
	}
	
}