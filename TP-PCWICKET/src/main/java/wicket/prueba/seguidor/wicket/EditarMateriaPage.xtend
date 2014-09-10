package wicket.prueba.seguidor.wicket

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.form.Form
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import org.apache.wicket.markup.html.form.TextField
import org.apache.wicket.markup.html.basic.Label
import org.uqbar.wicket.xtend.XButton
import org.apache.wicket.markup.html.panel.FeedbackPanel
import org.apache.wicket.markup.html.form.CheckBox
import org.apache.wicket.markup.html.form.DropDownChoice
import org.uqbar.commons.model.UserException
import org.uqbar.wicket.xtend.XListView

//Se usa tanto para agregar celus nuevos o editar uno existente

class EditarMateriaPage extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	
	private final Materia materia
	private final Materia materiaReal
	private final boolean alta
	private final IniciarMateriasPage mainPage
	
	private final val ubicaciones = #["1er Cuatrimestre", "2do Cuatrimestre", "Curso de verano"]
	

	new(Materia materiaAEditar, IniciarMateriasPage mainPage) {
		
		this.mainPage = mainPage
		this.alta = materiaAEditar.isNew()
		this.materia = new Materia
		this.materiaReal = materiaAEditar
		
		materia.nombre = materiaReal.nombre
		materia.anio = materiaReal.anio
		materia.finalAprobado = materiaReal.finalAprobado
		materia.profe = materiaReal.profe
		materia.ubicacion = materiaReal.ubicacion
		materia.notas = materiaReal.notas
		
		this.addChild(new Label("titulo", if (this.alta) "Nueva Materia" else "Editar Datos de Materia"))
		
		val editarForm = new Form<Materia>("editarMateriasForm", this.materia.asCompoundModel)
		this.agregarCamposEdicion(editarForm)
		this.agregarAcciones(editarForm)
		this.addChild(editarForm)
		
	}

	
	def agregarCamposEdicion(Form<Materia> form) {
		
		val textField = new TextField("nombre")
		form.addChild(textField)
		
		form.addChild(new TextField("anio"))
		form.addChild(new TextField("profe"))
		form.addChild(new DropDownChoice("ubicacion",ubicaciones))
		form.addChild(new CheckBox("finalAprobado"))
		
		this.agregarGrillaNotas(form)
		
		form.addChild(new FeedbackPanel("feedbackPanel"))
	}
	
	def agregarGrillaNotas(Form<Materia> form) {
		
		/*  Lo de abjao es copy paste de lo que hicimos en IniciarMateriasPage.html...
		 
		 
		val listView = new XListView("notas")

		listView.populateItem = [ item |
			item.model = item.modelObject.asCompoundModel
			item.addChild(new Label("nombre"))
			item.addChild(new Label("profe"))
			
			val checkResumen = new CheckBox("finalAprobado")
			checkResumen.setEnabled(false)
			item.addChild(checkResumen)
			
			
			item.addChild(new XButton("editar").onClick = [| editar(item.modelObject) ])
			item.addChild(new XButton("eliminar")
				.onClick = [| 
					iniciador.materiaSeleccionada = item.modelObject
					iniciador.eliminarMateriaSeleccionada
				]
			)
		]

		form.addChild(listView)
	
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
						materiaReal.nombre = materia.nombre
						materiaReal.anio = materia.anio
						materiaReal.finalAprobado = materia.finalAprobado
						materiaReal.profe = materia.profe
						materiaReal.ubicacion = materia.ubicacion
						materiaReal.notas = materia.notas
					}
					volver()
				} catch (UserException e) {
					info(e.getMessage())
				} catch (RuntimeException e) {
					error("Ocurrió un error al procesar el pedido")
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