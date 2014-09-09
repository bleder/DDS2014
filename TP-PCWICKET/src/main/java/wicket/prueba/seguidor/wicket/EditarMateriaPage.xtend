package wicket.prueba.seguidor.wicket

import org.apache.wicket.markup.html.WebPage

class EditarMateriaPage extends WebPage {
	
	@Property Materia materiaSeleccionada
	@Property IniciarMateriasPage returnPage
	
	new(Materia materia, IniciarMateriasPage page) {
		materiaSeleccionada = materia
		returnPage = page
		
		new EditarMateria(materia)
	}
	
}