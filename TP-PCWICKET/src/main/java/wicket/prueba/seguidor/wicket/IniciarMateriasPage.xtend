
package wicket.prueba.seguidor.wicket

import org.apache.wicket.markup.html.WebPage

import org.apache.wicket.markup.html.basic.Label
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods

class IniciarMateriasPage extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods

	new() {
		val label = new Label("version", application.frameworkSettings.version)
		
		this.addChild(label);

		// TODO Add your page's components here
    }

}