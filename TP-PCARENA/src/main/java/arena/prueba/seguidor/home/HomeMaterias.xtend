package arena.prueba.seguidor.home


import java.util.List
import org.uqbar.commons.model.CollectionBasedHome
import org.uqbar.commons.utils.Observable
import org.apache.commons.collections15.Predicate;
import arena.prueba.seguidor.domain.Materia

@Observable
class HomeMaterias extends CollectionBasedHome<Materia> {

	new() {
		this.init
	}

	def void init() {
		this.create("Mate discreta", 2005, true, "Alejandra Isola")
		this.create("Paradigmas", 2009, true, "Spagariol")
		this.create("Algebra", 2009, true, "Monica perez")
		this.create("Sistemas operativos", 2009, true, "Scarfiello")
	}
	
	def void create(String nombre, int anio, boolean finalAprobado, String profe) {
		var materia = new Materia
		
		materia.nombre = nombre
		materia.anio = anio
		materia.finalAprobado = finalAprobado
		materia.profe = profe
		this.create(materia)
	}

	def List<Materia> getMaterias() {
		allInstances	
	}
		
	def iniciar() {
		allInstances.toList
	}
		
	
	def Materia get(String nom) {
		materias.findFirst [ materia | materia.nombre.equals(nom) ]
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
	
}