package arena.prueba.seguidor.ui


import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.CheckBox
import arena.prueba.seguidor.domain.Nota


class EditarNotaWindow extends Dialog<Nota> {

	
	new(WindowOwner owner) {
		super(owner, new Nota)
	}
	
	override executeTask() {
		super.executeTask()
	}

	override protected createFormPanel(Panel mainPanel) {
		title = "Editar Nota"
		val form = new Panel(mainPanel)
		form.layout = new ColumnLayout(2)
		
		new Label(form).setText("Fecha:")
		new TextBox(form).bindValueToProperty("fecha")
		
		new Label(form).setText("Descripcion:")
		new TextBox(form).bindValueToProperty("descripcion")
		
		new Label(form).setText("Aprobado:")
		var check = new CheckBox(form)
		check.bindValueToProperty("aprobada")

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
	
}