package utn.edu.dds.TP_OPF5_VIEW

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.model.CompoundPropertyModel
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import org.uqbar.wicket.xtend.XButton

class OFHomePage extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	new(){
		var Object objeto
		val Form <Object> generalForm = new Form<Object>("generalForm",new CompoundPropertyModel<Object>(objeto))
		agregarAcciones(generalForm)
		this.addChild(generalForm)
	}
	
	def agregarAcciones(Form <Object> form){
		
		form.addChild(new XButton("GenerarEquipos"))
		form.addChild(new XButton("BuscarJ"))
		
	}
	
	
	
}