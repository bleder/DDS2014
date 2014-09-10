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
import org.uqbar.arena.widgets.TextFilter
import org.uqbar.arena.widgets.TextInputEvent
import java.util.ArrayList

class EditarNotaWindow extends Dialog<Nota> {

	
	new(WindowOwner owner, Nota nota) {
		super(owner, nota)
	}
	
	override executeTask() {
		super.executeTask()
	}

	override protected createFormPanel(Panel mainPanel) {
		title = "Editar Nota"
		val form = new Panel(mainPanel)
		form.layout = new ColumnLayout(2)
		
		new Label(form).setText("Fecha: (dd/mm/aaaa)")
		new TextBox(form)
		.withFilter(new DateTextFilter)
		
		
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


class DateTextFilter implements TextFilter {
      override accept(TextInputEvent event) {
            val expected = new ArrayList(#["\\d", "\\d?", "/", "\\d", "\\d?", "/", "\\d{0,4}"])
            val regex = expected.reverse.fold("")[result, element| '''(«element»«result»)?''']
            event.potentialTextResult.matches(regex)
      }
}