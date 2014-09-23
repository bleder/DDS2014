package utn.edu.dds.TP_OPF5_VIEW.ui

import org.apache.wicket.markup.html.WebPage
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import partido.core.Partido
import partido.core.Jugador
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.model.CompoundPropertyModel
import org.apache.wicket.markup.html.form.DropDownChoice
import org.apache.wicket.markup.html.form.CheckBox
import org.apache.wicket.markup.html.form.TextField
import org.uqbar.wicket.xtend.XButton
import divisionEquipo.DivParImpar
import divisionEquipo.DivPosiciones

class GenerarEquiposPage extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	
	var GenerarEquipos generador
	
	new(Partido partido) {
		generador = new GenerarEquipos(partido)
		val Form <GenerarEquipos> form = new Form<GenerarEquipos>("generarForm",new CompoundPropertyModel<GenerarEquipos>(generador))
		agregarCriteriosDivision(form)
		agregarCriteriosOrdenamiento(form)
		agregarAcciones(form)
		
		agregarGrillasEquipos(form)
		
		this.addChild(form)
	}
	
	def agregarGrillasEquipos(Form<GenerarEquipos> form) {
		//TODO: Esto deberia mostrar los equipos que se van generando
	}
	
	def agregarAcciones(Form<GenerarEquipos> form) {
		form.addChild(new XButton("Generar")
			.onClick = [| generador.generarEquipos()]
		)
		form.addChild(new XButton("Confirmar")
			.onClick = [| generador.confirmarEquipos()]
		)
	}
	
	def agregarCriteriosOrdenamiento(Form<GenerarEquipos> form) {
		var handler = new OrdenamientosHandler
		generador.handler = handler
		val handlerForm = new Form<OrdenamientosHandler> ("ordenador", new CompoundPropertyModel<OrdenamientosHandler>(handler))
		
		handlerForm.addChild(new CheckBox("handicap"))
		handlerForm.addChild(new CheckBox("promedioUltimo"))
		handlerForm.addChild(new TextField("ultimosN"))
		
		form.addChild(handlerForm)
	}
	
	def agregarCriteriosDivision(Form<GenerarEquipos> form) {
		val dropDown = new DropDownChoice("criterio", #["Par/Impar", "Posiciones"])
		form.addChild(dropDown)
	}
	
	def verJugador(Jugador jug) {
		responsePage = new JugadorPage(jug, this)
	}
	
}
