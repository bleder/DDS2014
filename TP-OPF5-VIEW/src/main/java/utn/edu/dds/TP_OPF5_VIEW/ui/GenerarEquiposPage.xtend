package utn.edu.dds.TP_OPF5_VIEW.ui

import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import partido.core.Partido
import partido.core.Jugador
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.model.CompoundPropertyModel
import org.apache.wicket.markup.html.form.DropDownChoice
import org.apache.wicket.markup.html.form.CheckBox
import org.apache.wicket.markup.html.form.TextField
import org.uqbar.wicket.xtend.XButton
import org.uqbar.wicket.xtend.XListView
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.AttributeModifier

class GenerarEquiposPage extends MenuPrincipal {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	
	var GenerarEquipos generador
	
	new(Partido partido) {
		generador = new GenerarEquipos(partido)
		val Form <GenerarEquipos> form = new Form<GenerarEquipos>("generarForm",new CompoundPropertyModel<GenerarEquipos>(generador))
		agregarCriteriosDivision(form)
		agregarCriteriosOrdenamiento(form)
		agregarAcciones(form)
		
		agregarGrillaEquipos(form)
		
		this.addChild(form)
	}
	
	def agregarGrillaEquipos(Form<GenerarEquipos> form){
		agregarGrillasEquipo(form,"equipo1")
		agregarGrillasEquipo(form,"equipo2")
	}
	
	def agregarGrillasEquipo(Form<GenerarEquipos> form, String equipo) {
		val listView = new XListView(equipo)
		listView.populateItem = [ item |
			item.model = item.modelObject.asCompoundModel
			val colorAzul = new AttributeModifier("class", colorHandicap(item.modelObject))
			item.addChild(new Label("nombre").add(colorAzul))
			item.addChild(new XButton("verDatos").onClick = [| verJugador(item.modelObject) ])
			]
		form.addChild(listView)
	}
	
	
	
	
	
	def agregarAcciones(Form<GenerarEquipos> form) {
		form.addChild(new XButton("Generar")
			.onClick = [| generador.generarEquipos()]
		)
		form.addChild(new XButton("Confirmar")
			.onClick = [| 
				generador.confirmarEquipos() responsePage = new OFHomePage
			]
		)
		form.addChild(new XButton("Volver")
		.onClick=[| responsePage = new OFHomePage]
		)
	}
	
	def agregarCriteriosOrdenamiento(Form<GenerarEquipos> form) {
		var handler = new OrdenamientosHandler
		generador.handler = handler
		val handlerForm = new Form<OrdenamientosHandler> ("ordenador", new CompoundPropertyModel<OrdenamientosHandler>(handler))
		
		handlerForm.addChild(new CheckBox("handicap"))
		handlerForm.addChild(new CheckBox("promedioUltimo"))
		handlerForm.addChild(new CheckBox("checkUltimosN"))
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
	
	def colorHandicap(Jugador jug){
		if(jug.nivelJuego>8)"azul"else""
	}
}
