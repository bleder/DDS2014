package utn.edu.dds.TP_OPF5_VIEW.ui

import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.model.CompoundPropertyModel
import org.apache.wicket.markup.html.form.TextField
import partido.core.Jugador
import org.uqbar.wicket.xtend.XListView
import org.uqbar.wicket.xtend.XButton
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.AttributeModifier

class BuscarJugadorPage extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	
	var BuscadorJugadores buscador

	new() {
		this.buscador = new BuscadorJugadores()
		val Form<BuscadorJugadores> buscarForm = new Form<BuscadorJugadores>("buscarJugadoresForm", new CompoundPropertyModel<BuscadorJugadores>(this.buscador))
		this.agregarCamposBusqueda(buscarForm)
		this.agregarAcciones(buscarForm)
		this.agregarGrillaResultados(buscarForm)
		this.addChild(buscarForm)
		
		
		this.buscarJugadores()
	}

	def buscarJugadores() {
		this.buscador.search()
	}

	def agregarCamposBusqueda(Form<BuscadorJugadores> parent) {
		parent.addChild(new TextField<String>("nombre"))
		parent.addChild(new TextField<String>("apodo"))
	}
	

	def agregarAcciones(Form<BuscadorJugadores> parent) {
		val buscarButton = new XButton("buscar")
		buscarButton.onClick = [| buscador.search ]
		parent.addChild(buscarButton)
		
		parent.addChild(new XButton("limpiar")
			.onClick = [| buscador.clear ]
		)
		
	}

	def agregarGrillaResultados(Form<BuscadorJugadores> parent) {
		val listView = new XListView("resultados")
		listView.populateItem = [ item |
			item.model = item.modelObject.asCompoundModel
			item.addChild(new Label("nombre"))
			item.addChild(new Label("nivelJuego").add(new AttributeModifier("class", this.colorHandicap(item.modelObject))))
			//item.addChild(new Label("promedioUltimoPartido")) Lo comente para que compilara (descomentar)

			item.addChild(new XButton("verDatos").onClick = [| verJugador(item.modelObject) ])
			
		]
		parent.addChild(listView)
	}
	
	def verJugador(Jugador jug) {
		responsePage = new JugadorPage(jug, this)
	}
	
	def colorHandicap(Jugador jug){
		if(jug.nivelJuego>8)"azul"else""
	}

}