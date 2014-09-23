package utn.edu.dds.TP_OPF5_VIEW.ui

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.basic.Label
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import partido.core.Jugador
import org.apache.wicket.markup.html.form.Form
import org.uqbar.wicket.xtend.XListView
import org.uqbar.wicket.xtend.XButton
import utn.edu.dds.TP_OPF5_VIEW.home.JugadorUI
import org.apache.wicket.request.component.IRequestablePage
import org.apache.wicket.AttributeModifier

class JugadorPage extends WebPage  {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	private final JugadorUI jugador
	private final IRequestablePage mainPage
	
	
	new(Jugador jugadorAvisualizar, IRequestablePage mainPage) { // use IRequestablePage generico para que se pueda usar con cualquiera
		this.mainPage = mainPage
		this.jugador = new JugadorUI(jugadorAvisualizar)
		val formJugador = new Form<JugadorUI>("jugadorView", this.jugador.asCompoundModel)
		agregarCampos(formJugador)
//		agregarGrillaInfracciones(formJugador)
//		agregarGrillaAmigos(formJugador)
		agregarAcciones(formJugador)
		this.addChild(formJugador)
					
	}
	
	
	def agregarCampos(Form<JugadorUI> parent) {
		parent.addChild(new Label("jugador.nombre"))
		//parent.addChild(new Label("apodo")) En el dominio no tenemos Apodo
		parent.addChild(new Label("jugador.nivelJuego").add(new AttributeModifier("class", this.colorHandicap(parent.modelObject.jugador)))) //Es el Handicap
//		parent.addChild(new Label("promedioUltimoPartido"))
//		parent.addChild(new Label("promedioTodosLosPartidos"))
		//parent.addChild(new Label("fechaNacimiento")) En el dominio no tenemos Fecha de Nacimiento
//		parent.addChild(new Label("cantidadDePartidos"))
		
	}
	
	def agregarGrillaInfracciones(Form<JugadorUI> parent){
		val listView = new XListView("infraciones")
		listView.populateItem = [ item |
			item.model = item.modelObject.asCompoundModel
			item.addChild(new Label("fecha")) //En nuestro dominio no tenemos hora como pide el enunciado
			item.addChild(new Label("motivo"))]
		parent.addChild(listView)
	}
	
	def agregarGrillaAmigos(Form<JugadorUI> parent){
		val listView = new XListView("amigos")
		
		parent.addChild(listView)
	}
	
	def agregarAcciones(Form<JugadorUI> parent){
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