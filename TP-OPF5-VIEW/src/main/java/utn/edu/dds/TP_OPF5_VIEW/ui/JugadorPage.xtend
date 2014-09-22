package utn.edu.dds.TP_OPF5_VIEW.ui

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.basic.Label
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import partido.core.Jugador
import org.apache.wicket.markup.html.form.Form
import org.uqbar.wicket.xtend.XListView
import org.uqbar.wicket.xtend.XButton

class JugadorPage extends WebPage  {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	private final Jugador jugador
	private final OFHomePage mainPage
	
	
	new(Jugador jugadorAvisualizar, OFHomePage mainPage) {
		this.mainPage = mainPage
		this.jugador=jugadorAvisualizar	
		val formJugador = new Form<Jugador>("jugadorView", this.jugador.asCompoundModel)
		agregarCampos(formJugador)
		agregarGrillaInfracciones(formJugador)
		agregarGrillaAmigos(formJugador)
		this.addChild(formJugador)
					
	}
	
	def agregarCampos(Form<Jugador> parent) {
		parent.addChild(new Label("nombre"))
		parent.addChild(new Label("apodo"))
		parent.addChild(new Label("handicap"))
		parent.addChild(new Label("promedioUltimoPartido"))
		parent.addChild(new Label("promedioTodosLosPartidos"))
		parent.addChild(new Label("fechaNacimiento"))
		parent.addChild(new Label("cantidadDePartidos"))
		
	}
	
	def agregarGrillaInfracciones(Form<Jugador> parent){
		val listView = new XListView("infraciones")
		listView.populateItem = [ item |
			item.model = item.modelObject.asCompoundModel
			item.addChild(new Label("fecha")) //En nuestro dominio no tenemos hora como pide el enunciado
			item.addChild(new Label("motivo"))]
		parent.addChild(listView)
	}
	
	def agregarGrillaAmigos(Form<Jugador> parent){
		val listView = new XListView("amigos")
		
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
}