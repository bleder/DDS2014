package arena.prueba.seguidor.ui

import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import arena.prueba.seguidor.domain.Materia
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.Label

class NuevaMateria extends Dialog<Materia> {
	
	new(WindowOwner owner) {
		super(owner, new Materia)
	}
	
	
	override protected createFormPanel(Panel mainPanel) {
		val form = new Panel(mainPanel)
		form.layout = new VerticalLayout()
		
		new Label(form).setText("Nombre")
		new TextBox(form).bindValueToProperty("nombre")
	}
	

	
	override protected void addActions(Panel actions) {
		new Button(actions)
			.setCaption("Aceptar")
			.onClick [|this.accept]
			.setAsDefault.disableOnError

	}

}
	