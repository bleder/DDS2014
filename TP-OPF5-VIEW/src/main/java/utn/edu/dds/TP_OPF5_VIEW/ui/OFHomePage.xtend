
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
		agregarAcciones()
	}
	
	def agregarAcciones(){
		
		this.addChild(new XButton("GenerarEquipos")
			.onClick=[|generarEquipos()]
		)
		this.addChild(new XButton("BuscarJ")
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