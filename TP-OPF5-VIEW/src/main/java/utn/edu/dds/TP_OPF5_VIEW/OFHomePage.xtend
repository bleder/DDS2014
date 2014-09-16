package utn.edu.dds.TP_OPF5_VIEW

import org.apache.wicket.markup.html.WebPage
import org.uqbar.wicket.xtend.XButton
import partido.core.Jugador
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.model.CompoundPropertyModel
import org.uqbar.wicket.xtend.XForm
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods

class OFHomePage extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	new(){
		var Object objeto
		val Form <Object> generalForm = new Form<Object>("generalForm",new CompoundPropertyModel<Object>(objeto))
	}
	
	def agregarAcciones(){
		val generarEquipos= new XButton("GenerarEquipos")
		//item.addChild(new XButton("eliminar")
	}
	
	
	
}