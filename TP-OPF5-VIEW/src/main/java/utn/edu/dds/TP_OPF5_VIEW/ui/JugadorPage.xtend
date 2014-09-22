package utn.edu.dds.TP_OPF5_VIEW.ui

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.basic.Label
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import partido.core.Jugador
import org.apache.wicket.markup.html.form.Form
import org.uqbar.wicket.xtend.XListView
import org.uqbar.wicket.xtend.XButton
import utn.edu.dds.TP_OPF5_VIEW.home.JugadorUI

class JugadorPage extends WebPage  {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	private final JugadorUI jugador
	private final OFHomePage mainPage
	
	
	new(JugadorUI jugadorAvisualizar, OFHomePage mainPage) {
		this.mainPage = mainPage
		this.jugador=jugadorAvisualizar	
		val formJugador = new Form<JugadorUI>("jugadorView", this.jugador.asCompoundModel)
		agregarCampos(formJugador)
		agregarGrillaInfracciones(formJugador)
		agregarGrillaAmigos(formJugador)
		this.addChild(formJugador)
					
	}
	
	def agregarCampos(Form<JugadorUI> parent) {
		parent.addChild(new Label("nombre"))
		//parent.addChild(new Label("apodo")) En el dominio no tenemos Apodo
		parent.addChild(new Label("nivelJuego")) //Es el Handicap
		parent.addChild(new Label("promedioUltimoPartido"))
		parent.addChild(new Label("promedioTodosLosPartidos"))
		//parent.addChild(new Label("fechaNacimiento")) En el dominio no tenemos Fecha de Nacimiento
		parent.addChild(new Label("cantidadDePartidos"))
		
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
}