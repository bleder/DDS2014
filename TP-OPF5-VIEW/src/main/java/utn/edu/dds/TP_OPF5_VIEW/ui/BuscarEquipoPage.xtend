package utn.edu.dds.TP_OPF5_VIEW.ui

import org.apache.wicket.markup.html.WebPage
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import org.apache.wicket.markup.html.form.Form
import org.uqbar.wicket.xtend.XListView
import org.apache.wicket.markup.html.basic.Label
import org.uqbar.wicket.xtend.XButton
import partido.core.Partido
import org.apache.wicket.model.CompoundPropertyModel

class BuscarEquipoPage extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	
	ListaPartidos listaPartidos
	
	new() {
		listaPartidos = new ListaPartidos
		val Form <ListaPartidos> generarEquiposForm = new Form<ListaPartidos>("generarEquiposForm",new CompoundPropertyModel<ListaPartidos>(listaPartidos))

		agregarGrillaPartidos(generarEquiposForm)
		agregarAcciones(generarEquiposForm)
		this.addChild(generarEquiposForm)
		
		listaPartidos.iniciar()
	}
	
	def agregarGrillaPartidos(Form <ListaPartidos> form) {
		val listView = new XListView("partidos")
		listView.populateItem = [ item |
			item.model = item.modelObject.asCompoundModel
			item.addChild(new Label("nombrePartido"))
			
			item.addChild(new XButton("Generar Equipos").onClick = [| generarEquipo(item.modelObject)])
		]
		
		form.addChild(listView)
	}
	
	def generarEquipo(Partido partido) {
		responsePage = new GenerarEquiposPage(partido)
		//TODO: Mandar a la pagina donde se generan realmente los equipos
	}
	
	def agregarAcciones(Form<ListaPartidos> form) {
		form.addChild(new XButton("Volver")
			.onClick=[| responsePage = new OFHomePage]
		)
	}
	
}