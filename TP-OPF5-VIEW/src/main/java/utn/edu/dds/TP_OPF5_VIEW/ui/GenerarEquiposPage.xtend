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
import partido.core.Partido
import java.util.List
import org.uqbar.commons.utils.ApplicationContext

class GenerarEquiposPage extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	
	new(Partido partido) {
		//TODO: dado un equipo, dar las opciones de generarlo
	}
	
}