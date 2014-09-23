package utn.edu.dds.TP_OPF5_VIEW.ui

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.model.CompoundPropertyModel
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import org.uqbar.wicket.xtend.XButton
import utn.edu.dds.TP_OPF5_VIEW.ui.GenerarEquiposPage

class OFHomePage extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	new(){
		var Object objeto
		val Form <Object> generalForm = new Form<Object>("generalForm",new CompoundPropertyModel<Object>(objeto))
		agregarAcciones(generalForm)
		this.addChild(generalForm)
	}
	
	def agregarAcciones(Form <Object> form){
		
		form.addChild(new XButton("GenerarEquipos")
			.onClick=[|generarEquipos()]
		)
		form.addChild(new XButton("BuscarJ")
			.onClick=[|buscarJugadores()]
		)
		
	}
	
	def generarEquipos() {
		responsePage = new BuscarEquipoPage()
	}
	
	
	def buscarJugadores() {
		responsePage = new BuscarJugadorPage()
	}
	

}