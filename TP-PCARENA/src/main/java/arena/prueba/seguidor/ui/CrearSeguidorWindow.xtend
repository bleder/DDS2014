package arena.prueba.seguidor.ui



import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.commons.utils.Observable
import arena.prueba.seguidor.domain.Materia
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.widgets.tables.Column
import java.util.List
import java.util.ArrayList
import arena.prueba.seguidor.domain.ManejadorMaterias

/**
 * 
 */
@Observable
class CrearSeguidorWindow extends SimpleWindow<ManejadorMaterias> {
	
	new(WindowOwner parent) {
		super(parent, new ManejadorMaterias)
		title = "Seguidor de carrera"
		taskDescription = "Seguidor de carrera"
	}

	override createFormPanel(Panel mainPanel) {
		val editorPanel = new Panel(mainPanel)
		editorPanel.setLayout(new VerticalLayout())
		
		new Label(editorPanel).setText("Materias")
		
		var table = new Table<Materia>(mainPanel, typeof(Materia))
		table.heigth = 200
		table.width = 400
		table.bindItemsToProperty("materias")
		//table.bindValueToProperty("")
		
		new Column<Materia>(table) //
			.setTitle("Nombre")
			.setFixedSize(150)
			.bindContentsToProperty("nombre")
		
		new Column<Materia>(table) //
			.setTitle("")
			.setFixedSize(150)
			.bindContentsToProperty("")

	}

	override addActions(Panel actionsPanel) {
		new Button(actionsPanel) => [
			caption = "Nueva Materia"
			setAsDefault
			onClick[|
				nuevaMateria
			]
		]
	}


//Acciones
	def void nuevaMateria() {
		this.openDialog(new NuevaMateria(this))
	}
	
	def openDialog(NuevaMateria dialog) {
		dialog.onAccept([| modelObject])
		dialog.open()
	}

}


