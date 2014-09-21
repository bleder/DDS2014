package utn.edu.dds.TP_OPF5_VIEW

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
		val formJugador = new Form<Jugador>("nuevoCelularForm", this.jugador.asCompoundModel)
		agregarCamposEdicion(formJugador)
					
	}
	
	def agregarCamposEdicion(Form<Jugador> parent) {
		parent.addChild(new Label("nombre"))
		parent.addChild(new Label("apodo"))
		parent.addChild(new Label("handicap"))
		parent.addChild(new Label("promedioUltimoPartido"))
		parent.addChild(new Label("promedioTodosLosPartidos"))
		parent.addChild(new Label("fechaNacimiento"))
		parent.addChild(new Label("amigos"))//Esto tiene que ser una grilla
		parent.addChild(new Label("infracciones"))//Esto tiene que ser una grilla
		parent.addChild(new Label("cantidadDePartidos"))//Esto tiene que ser una grilla
		
	}
}