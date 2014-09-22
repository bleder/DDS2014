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

class JugadorPage extends WebPage  {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	private final Jugador jugador
	private final IRequestablePage mainPage
	
	
	new(Jugador jugadorAvisualizar, IRequestablePage mainPage) { // use IRequestablePage generico para que se pueda usar con cualquiera
		this.mainPage = mainPage
		this.jugador=jugadorAvisualizar	
		val formJugador = new Form<Jugador>("jugadorView", this.jugador.asCompoundModel)
		agregarCampos(formJugador)
//		agregarGrillaInfracciones(formJugador)
//		agregarGrillaAmigos(formJugador)
		agregarAcciones(formJugador)
		this.addChild(formJugador)
					
	}
	
	def agregarCampos(Form<Jugador> parent) {
		parent.addChild(new Label("nombre"))
		//parent.addChild(new Label("apodo")) En el dominio no tenemos Apodo
		parent.addChild(new Label("nivelJuego")) //Es el Handicap
//		parent.addChild(new Label("promedioUltimoPartido"))
//		parent.addChild(new Label("promedioTodosLosPartidos"))
		//parent.addChild(new Label("fechaNacimiento")) En el dominio no tenemos Fecha de Nacimiento
//		parent.addChild(new Label("cantidadDePartidos"))
		
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