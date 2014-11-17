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
import org.apache.wicket.markup.html.list.ListItem
import org.apache.wicket.Component

class BuscarJugadorPage extends MenuPrincipal implements ListaJugadoresPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	
	var BuscadorJugadores buscador

	new() {
		this.buscador = new BuscadorJugadores()
		val Form<BuscadorJugadores> buscarForm = new Form<BuscadorJugadores>("buscarJugadoresForm", new CompoundPropertyModel<BuscadorJugadores>(this.buscador))
		this.agregarMenuPermanente(buscarForm)
		this.agregarCamposBusqueda(buscarForm)
		this.agregarAcciones(buscarForm)
		this.agregarGrillaResultados(buscarForm, "resultados")
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

	def agregarGrillaResultados(Form<BuscadorJugadores> parent, String id) {
		parent.addChild(new XListaJugadores(id, this))
	}
	
	def agregarBotones(Form<BuscadorJugadores> parent){
		parent.addChild(new XButton("Volver")
		.onClick=[| responsePage = new OFHomePage]
		)
	}
	
	override verJugador(Jugador jug) {
		responsePage = new JugadorPage(jug, this)
	}
	

	override colorHandicap(Jugador jug){
		if(jug.nivelJuego>8)"azul"else""
	}
	
	override asCompoundModel(Jugador jugador) {
		 _wicketExtensionFactoryMethods.asCompoundModel(jugador)
	}
	
	override addChild(ListItem<Jugador> item, Component component) {
		 _wicketExtensionFactoryMethods.addChild(item, component)
	}
	
}