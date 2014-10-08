package utn.edu.dds.TP_OPF5_VIEW.ui

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.model.CompoundPropertyModel
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import org.uqbar.wicket.xtend.XButton
import utn.edu.dds.TP_OPF5_VIEW.ui.GenerarEquiposPage
import org.uqbar.wicket.xtend.XLink
import org.apache.wicket.markup.html.image.Image
import org.apache.wicket.request.resource.ContextRelativeResource

class OFHomePage extends MenuPrincipal {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	new(){
		
			this.add(new Image("logo", "images.jpeg"))
	}
	
}