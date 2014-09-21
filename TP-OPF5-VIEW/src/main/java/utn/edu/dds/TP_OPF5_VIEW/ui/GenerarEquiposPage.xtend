package utn.edu.dds.TP_OPF5_VIEW.ui

import org.apache.wicket.markup.html.WebPage
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.model.CompoundPropertyModel
import org.uqbar.wicket.xtend.XButton
import org.apache.wicket.markup.html.form.DropDownChoice
import divisionEquipo.Divisor
import org.uqbar.wicket.xtend.XListView
import org.apache.wicket.markup.html.basic.Label

class GenerarEquiposPage extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	
	new(){
		var Object unForm
		val Form <Object> generarEquiposForm = new Form<Object>("generarEquiposForm",new CompoundPropertyModel<Object>(unForm))
		agregarAcciones(generarEquiposForm)
		//agregarGrillaResultados(generarEquiposForm)
		//agregarCamposEdicion(generarEquiposForm)
		this.addChild(generarEquiposForm)
	}
	
	def agregarAcciones(Form<Object> form) {
		form.addChild(new XButton("Generar")
			.onClick=[|]
		)
	}
	
	def agregarCamposEdicion(Form<Object> form){
		//parent.addChild(new DropDownChoice<Divisor>("cDivision")=> []) 
	}
	
//	def agregarGrillaResultados(Form<Object> form) {
//		val listView = new XListView("equipo1")
//		listView.populateItem = [ item |
//			item.model = item.modelObject.asCompoundModel
//			item.addChild(new Label("nombre")) 	]
//		parent.addChild(listView)
//	}
	
}