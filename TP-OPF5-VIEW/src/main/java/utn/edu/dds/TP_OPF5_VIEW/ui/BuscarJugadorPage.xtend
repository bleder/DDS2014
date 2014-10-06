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
import org.apache.wicket.markup.html.form.DropDownChoice
import java.util.ArrayList
import org.uqbar.wicket.xtend.XLink

class BuscarJugadorPage extends MenuPrincipal {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	
	var BuscadorJugadores buscador

	new() {
		this.buscador = new BuscadorJugadores()
		val Form<BuscadorJugadores> buscarForm = new Form<BuscadorJugadores>("buscarJugadoresForm", new CompoundPropertyModel<BuscadorJugadores>(this.buscador))
		this.agregarMenuPermanente(buscarForm)
		this.agregarCamposBusqueda(buscarForm)
		this.agregarAcciones(buscarForm)
		this.agregarGrillaResultados(buscarForm)
		this.agregarBotones(buscarForm)
		this.addChild(buscarForm)

		this.buscaJugadores()
	}
	
	def agregarMenuPermanente(Form<BuscadorJugadores> form) {
			

	}

	def buscaJugadores() {
		this.buscador.search()
	}

	def agregarCamposBusqueda(Form<BuscadorJugadores> parent) {
		val listaDesdeHasta=new ArrayList<String>()
		listaDesdeHasta.add("desde")
		listaDesdeHasta.add("hasta")
		
		parent.addChild(new TextField<String>("nombre"))
		parent.addChild(new TextField<String>("apodo"))
		parent.addChild(new TextField<String>("fechaTope"))

		val listaInfac=new ArrayList<String>()
		listaInfac.add("Con infracciones")
		listaInfac.add("Sin infracciones")
		parent.addChild(new DropDownChoice("conSinInfracciones",listaInfac))
		

		parent.addChild(new DropDownChoice("desdeHastaHandicap",listaDesdeHasta))
		parent.addChild(new TextField<String>("valorHandicap"))
		
		parent.addChild(new DropDownChoice("desdeHastaPromUltimo",listaDesdeHasta))
		parent.addChild(new TextField<String>("valorPromUltimo"))
		
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
			val colorAzul = new AttributeModifier("class", colorHandicap(item.modelObject))
			item.addChild(new Label("nombre").add(colorAzul))
			item.addChild(new Label("apodo").add(colorAzul))
			item.addChild(new Label("nivelJuego").add(colorAzul))
			item.addChild(new Label("promedioUltimoPartido").add(colorAzul))

			item.addChild(new XButton("verDatos").onClick = [| verJugador(item.modelObject) ])
			
		]
		parent.addChild(listView)
	}
	
	def agregarBotones(Form<BuscadorJugadores> parent){
		parent.addChild(new XButton("Volver")
		.onClick=[| responsePage = new OFHomePage]
		)
	}
	
	def verJugador(Jugador jug) {
		responsePage = new JugadorPage(jug, this)
	}
	

	def colorHandicap(Jugador jug){
		if(jug.nivelJuego>8)"azul"else""
	}
}