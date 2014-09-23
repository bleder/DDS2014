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
import partido.core.Jugador

class GenerarEquiposPage extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	
	var Partido partidoAEditar
	
	new(Partido partido) {
		//TODO: dado un equipo, dar las opciones de generarlo
		
		partidoAEditar = partido
		val generarEquiposForm = new Form<Partido>("partidoForm", this.partidoAEditar.asCompoundModel)
		//this.agregarCampos(generarEquiposForm)
		this.agregarGrillasEquipos(generarEquiposForm)
		//this.agregarAcciones(buscarForm)
		this.addChild(generarEquiposForm)
	}
	
	
		def agregarGrillasEquipos(Form <Partido> form) {
		val listView = new XListView("jugadoresHome")
		listView.populateItem = [ item |
			item.model = item.modelObject.asCompoundModel
			item.addChild(new Label("nombre"))
			item.addChild(new Label("mail"))
			item.addChild(new XButton("verDatos").onClick = [| verJugador(item.modelObject) ])
		]
		
		form.addChild(listView)
	}
	
	def verJugador(Jugador jug) {
		responsePage = new JugadorPage(jug, this)
	}
	
}
