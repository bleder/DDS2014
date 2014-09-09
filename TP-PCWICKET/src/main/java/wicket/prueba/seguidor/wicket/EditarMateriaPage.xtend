package wicket.prueba.seguidor.wicket

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.model.CompoundPropertyModel
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import org.apache.wicket.markup.html.form.TextField

class EditarMateriaPage extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	
	@Property Materia materiaSeleccionada
	@Property IniciarMateriasPage returnPage
	
	new(Materia materia, IniciarMateriasPage page) {
		materiaSeleccionada = materia
		returnPage = page
		
		val Form<EditarMateria> editarForm = new Form<EditarMateria>("editarMateriasForm", new CompoundPropertyModel<EditarMateria>(new EditarMateria(materia)))
		this.agregarCampos(editarForm)
		this.addChild(editarForm)
	}
	
	def agregarCampos(Form<EditarMateria> form) {
		val textField = new TextField("Materia")
		
		form.addChild(textField)
	}

	
}