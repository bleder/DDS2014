package utn.edu.dds.TP_OPF5_VIEW.ui

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.model.CompoundPropertyModel
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import org.uqbar.wicket.xtend.XButton
import utn.edu.dds.TP_OPF5_VIEW.ui.GenerarEquiposPage
import org.uqbar.wicket.xtend.XLink

class OFHomePage extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	new(){

		this.addChild(
			new XLink<Object>("GenerarEquipos") => [
				onClick = [|generarEquipos()]
			])
		this.addChild(
			new XLink<Object>("BuscarJ") => [
				onClick = [|buscarJugadores()]
			])
		
	}
	
	
	def generarEquipos() {
		responsePage = new BuscarEquipoPage()
	}
	
	
	def buscarJugadores() {
		responsePage = new BuscarJugadorPage()
	}
	
	

}