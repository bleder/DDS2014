package arena.prueba.seguidor.ui

import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.widgets.Panel
import arena.prueba.seguidor.domain.Materia
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.Button
import org.uqbar.commons.utils.ApplicationContext
import arena.prueba.seguidor.home.HomeMaterias

class CrearMateriaWindow extends Dialog<Materia> {

	
	new(WindowOwner owner) {
		super(owner, new Materia)
	}
	
	override executeTask() {
		homeMaterias.create(modelObject)
		super.executeTask()
	}

	override protected createFormPanel(Panel mainPanel) {
		title = "Nueva Materia"
		val form = new Panel(mainPanel)
		form.layout = new VerticalLayout()
		
		new Label(form).setText("Nombre:")
		new TextBox(form)
			.bindValueToProperty("nombre")

	}

	override protected void addActions(Panel actions) {
		new Button(actions)
			.setCaption("Aceptar")
			.onClick [|this.accept]
			.setAsDefault.disableOnError

		new Button(actions) 
			.setCaption("Volver")
			.onClick [|
				this.cancel
			]
	}
	

	def getHomeMaterias() {
		ApplicationContext.instance.getSingleton(typeof(Materia)) as HomeMaterias
	}


}