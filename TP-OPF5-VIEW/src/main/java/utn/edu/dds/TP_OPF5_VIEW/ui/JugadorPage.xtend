package utn.edu.dds.TP_OPF5_VIEW.ui

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.basic.Label
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import partido.core.Jugador
import org.apache.wicket.markup.html.form.Form
import org.uqbar.wicket.xtend.XListView
import org.uqbar.wicket.xtend.XButton
import org.apache.wicket.request.component.IRequestablePage
import org.apache.wicket.AttributeModifier


class JugadorPage extends OFHomePage  {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	private final Jugador jugador
	private final IRequestablePage mainPage
	
	
	new(Jugador jugadorAvisualizar, IRequestablePage mainPage) { // use IRequestablePage generico para que se pueda usar con cualquiera
		this.mainPage = mainPage
		this.jugador = jugadorAvisualizar
		val formJugador = new Form<Jugador>("jugadorView", this.jugador.asCompoundModel)
		agregarCampos(formJugador)
		agregarGrillaInfracciones(formJugador) 
		agregarGrillaAmigos(formJugador)
		agregarAcciones(formJugador)
		this.addChild(formJugador)		
	}
	
	
	def agregarCampos(Form<Jugador> parent) {
		val colorAzul = new AttributeModifier("class", colorHandicap(parent.modelObject))
		parent.addChild(new Label("nombre").add(colorAzul))
		parent.addChild(new Label("apodo").add(colorAzul))
		parent.addChild(new Label("nivelJuego").add(colorAzul)) //Es el Handicap
		parent.addChild(new Label("promedioUltimoPartido").add(colorAzul))
		parent.addChild(new Label("promedioTodosLosPartidos").add(colorAzul))
		parent.addChild(new Label("fechaNac").add(colorAzul))  
		parent.addChild(new Label("cantidadDePartidos").add(colorAzul))
		
	}
	
	def agregarGrillaInfracciones(Form<Jugador> parent){
		val listView = new XListView("infracciones")
		listView.populateItem = [ item |
			item.model = item.modelObject.asCompoundModel
			item.addChild(new Label("fecha")) //En nuestro dominio no tenemos hora como pide el enunciado
			item.addChild(new Label("motivo"))]
		parent.addChild(listView)
	}
	
	def agregarGrillaAmigos(Form<Jugador> parent){
		val listView = new XListView("amigos")
		listView.populateItem = [ item |
			item.model = item.modelObject.asCompoundModel
			item.addChild(new Label("intern"))
			]
		parent.addChild(listView)
	}
	
	def agregarAcciones(Form<Jugador> parent){
		parent.addChild(new XButton("volver") => [
			onClick = [| volver ]
		])
	}
	
	def volver() {
		responsePage = mainPage
	}
	
	def colorHandicap(Jugador jug){
		if(jug.nivelJuego>8)"azul"else""
	}
}