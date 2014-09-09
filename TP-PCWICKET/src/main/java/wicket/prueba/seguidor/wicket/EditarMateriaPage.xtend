package wicket.prueba.seguidor.wicket

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.model.CompoundPropertyModel
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import org.apache.wicket.markup.html.form.TextField
import org.apache.wicket.markup.html.basic.Label
import org.uqbar.wicket.xtend.XButton

//Se usa tanto para agregar celus nuevos o editar uno existente

class EditarMateriaPage extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	
	private final Materia materia
	private final boolean alta
	private final IniciarMateriasPage mainPage
	
	
	
	
	@Property Materia materiaSeleccionada
	@Property IniciarMateriasPage returnPage
	
	new(Materia materiaAEditar, IniciarMateriasPage mainPage) {
		
		this.mainPage = mainPage
		this.alta = materiaAEditar.isNew()
		this.materia = materiaAEditar
		
		this.addChild(new Label("titulo", if (this.alta) "Nueva Materia" else "Editar Datos de Materia"))
		
		val editarForm = new Form<Materia>("editarMateriasForm", this.materia.asCompoundModel)
		this.agregarCamposEdicion(editarForm)
		this.agregarAcciones(editarForm)
		this.addChild(editarForm)
		
		/*
		materiaSeleccionada = materia
		returnPage = page
		
		val Form<EditarMateria> editarForm = new Form<EditarMateria>("editarMateriasForm", new CompoundPropertyModel<EditarMateria>(new EditarMateria(materia)))
		this.agregarCampos(editarForm)
		this.addChild(editarForm)
		*/
	}

	
	def agregarCamposEdicion(Form<Materia> form) {
		val textField = new TextField("nombre")
		form.addChild(textField)
		/* 
		parent.addChild(new TextField<String>("numero"))
		parent.addChild(new TextField<String>("nombre"))
		parent.addChild(new DropDownChoice<Modelo>("modeloCelular") => [
			choices = loadableModel([| Modelo.home.allInstances ])
			choiceRenderer = choiceRenderer([Modelo m| m.descripcion ])
		]) 
		parent.addChild(new CheckBox("recibeResumenCuenta"))
		parent.addChild(new FeedbackPanel("feedbackPanel"))
	}
	*/
	}

	def void agregarAcciones(Form<Materia> parent) {
		
		parent.addChild(new XButton("aceptar") => [
			onClick = [|
				try {
					materia.validar()
					if (alta) {
						Materia.home.create(materia)
					} else {
						Materia.home.delete(materia)
						Materia.home.create(materia)
					}
					volver()
				} catch (RuntimeException e) {
					error("Ocurrió un error")
				}
			]				
		])
		
		
		parent.addChild(new XButton("cancelar") => [
			onClick = [| volver ]
		])
	}	

	def volver() {
		mainPage.iniciarMaterias()
		responsePage = mainPage
	}
}