
package wicket.prueba.seguidor.wicket

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.model.CompoundPropertyModel
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import org.uqbar.wicket.xtend.XListView
import org.apache.wicket.markup.html.basic.Label
import org.uqbar.wicket.xtend.XButton
import org.apache.wicket.markup.html.form.CheckBox

class IniciarMateriasPage extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods

	var IniciarMateria iniciador

	new() {
		this.iniciador = new IniciarMateria()
		val Form<IniciarMateria> iniciarForm = new Form<IniciarMateria>("iniciarMateriasForm", new CompoundPropertyModel<IniciarMateria>(this.iniciador))

		this.agregarGrillaMaterias(iniciarForm)
		this.agregarAcciones(iniciarForm)
		this.addChild(iniciarForm)

		this.iniciarMaterias()
	}

	def iniciarMaterias() {
		this.iniciador.iniciar()
	}

	def agregarAcciones(Form<IniciarMateria> parent){
		
		parent.addChild(new XButton("nueva").onClick = [| editar(new Materia) ])
		
	}
	def agregarGrillaMaterias(Form<IniciarMateria> parent) {
		val listView = new XListView("resultados")
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
		parent.addChild(listView)
	}
	
	def editar(Materia materia) {
		responsePage = new EditarMateriaPage(materia, this) 
	}		


}

