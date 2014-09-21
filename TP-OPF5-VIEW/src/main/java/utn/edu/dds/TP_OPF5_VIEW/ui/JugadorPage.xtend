package utn.edu.dds.TP_OPF5_VIEW.ui

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.basic.Label
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import partido.core.Jugador
import org.apache.wicket.markup.html.form.Form

class JugadorPage extends WebPage  {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	private final Jugador jugador
	
	
	new(Jugador jugadorAvisualizar) {
		this.jugador=jugadorAvisualizar	
		val formJugador = new Form<Jugador>("jugadorView", this.jugador.asCompoundModel)
		agregarCampos(formJugador)
					
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
		
	}
	
	def agregarGrillaAmigos(Form<Jugador> parent){
		
	}
}