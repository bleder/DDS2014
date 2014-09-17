package utn.edu.dds.TP_OPF5_VIEW

import org.apache.wicket.markup.html.WebPage
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.model.CompoundPropertyModel
import org.uqbar.wicket.xtend.XButton

class GenerarEquiposPage extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	
	new(){
		var Object unForm
		val Form <Object> generarEquiposForm = new Form<Object>("generarEquiposForm",new CompoundPropertyModel<Object>(unForm))
		agregarAcciones(generarEquiposForm)
		this.addChild(generarEquiposForm)
	}
	
	def agregarAcciones(Form<Object> form) {
		form.addChild(new XButton("Generar"))
	}
	
}