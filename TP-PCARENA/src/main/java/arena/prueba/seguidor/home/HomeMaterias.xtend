package arena.prueba.seguidor.home


import java.util.List
import org.uqbar.commons.model.CollectionBasedHome
import org.uqbar.commons.utils.Observable
import org.apache.commons.collections15.Predicate;
import arena.prueba.seguidor.domain.Materia
import arena.prueba.seguidor.domain.Nota
import java.util.Date
import java.util.ArrayList

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
		
		var nota = new Nota
		nota.aprobada = true
		nota.fecha = new Date(2004,4,12)
		nota.descripcion = "Parcial A"
		
		var nota2 = new Nota
		nota2.aprobada = false
		nota2.fecha = new Date(2004,8,23)
		nota2.descripcion = "Parcialito"
		materia.notas = new ArrayList(#[nota,nota2])
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