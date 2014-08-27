package arena.prueba.seguidor.ui




import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import arena.prueba.seguidor.applicationModel.IniciarMateria
import arena.prueba.seguidor.domain.Materia
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.CheckBox
import arena.prueba.seguidor.domain.Nota
import org.uqbar.arena.widgets.Selector
import com.uqbar.commons.StringUtils

class IniciarMateriasWindow extends SimpleWindow<IniciarMateria> {

	new(WindowOwner parent) {
		super(parent, new IniciarMateria)
		modelObject.iniciar()
	}

	override def createMainTemplate(Panel mainPanel) {
		title = "Seguidor de carrera"
		taskDescription = "Seguidor de carrera"

		super.createMainTemplate(mainPanel)

		this.createResultsGrid(mainPanel)
		this.createGridActions(mainPanel)
	}

	override def void createFormPanel(Panel mainPanel) {
		
		var panel = new Panel(mainPanel)
		panel.setLayout(new ColumnLayout(2))
		
		
	
		var labelNumero = new Label(panel)
		labelNumero.setText("Materia Seleccionada:")

		new TextBox(panel).bindValueToProperty("materiaSeleccionada.nombre")
		
		new Label(panel).setText("Anio:")
		new TextBox(panel)
		.withFilter [ event | StringUtils.isNumeric(event.potentialTextResult) ]
		.bindValueToProperty("materiaSeleccionada.anio")
		
		new Label(panel).setText("Profesor:")
		new TextBox(panel)
		.bindValueToProperty("materiaSeleccionada.profe")
		
		new Label(panel).setText("Final Aprobado:")
		var check = new CheckBox(panel)
		check.bindValueToProperty("materiaSeleccionada.finalAprobado")
		
		new Label(panel).setText("Ubicacion materia:")
		new Selector(panel) => [
			allowNull = false
			width = 100
			bindItemsToProperty("materiaSeleccionada.ubicaciones")
			bindValueToProperty("materiaSeleccionada.ubicacion")			
		]
	
		new Label(panel).setText("Notas de cursada:")
		var table = new Table<Nota>(panel, typeof(Nota))
		table.heigth = 200
		table.width = 450
		table.bindItemsToProperty("materiaSeleccionada.notas")
		table.bindValueToProperty("notaSeleccionada")
		
		new Column<Nota>(table) //
			.setTitle("Fecha")
			.setFixedSize(150)
			.bindContentsToProperty("fecha")
			
		new Column<Nota>(table) //
			.setTitle("Descripcion")
			.setFixedSize(150)
			.bindContentsToProperty("descripcion")

		new Column<Nota>(table) 
			.setTitle("Aprobado")
			.setFixedSize(150)		
			.bindContentsToTransformer([nota | if (nota.aprobada) "Si" else "No"])
			
		var panelNotas = new Panel(mainPanel)
		panelNotas.setLayout(new HorizontalLayout)
		new Button(panelNotas)
			.setCaption("Editar Nota")
			.onClick [ | this.editarNota]
			
	}


	override protected addActions(Panel actionsPanel) {
	}


	def protected createResultsGrid(Panel mainPanel) {
		var table = new Table<Materia>(mainPanel, typeof(Materia))
		table.heigth = 200
		table.width = 450
		table.bindItemsToProperty("resultados")
		table.bindValueToProperty("materiaSeleccionada")
		this.describeResultsGrid(table)

	}


	def void describeResultsGrid(Table<Materia> table) {
		
	
		new Column<Materia>(table) //
			.setTitle("Materia")
			.setFixedSize(150)
			.bindContentsToProperty("nombre")
			
		new Column<Materia>(table) //
			.setTitle("Profesor")
			.setFixedSize(150)
			.bindContentsToProperty("profe")
		
 
		new Column<Materia>(table) //
			.setTitle("Aprobada")
			.setFixedSize(100)
			.bindContentsToTransformer([materia | if (materia.finalAprobado) "Si" else "No"])
			
	}

	def void createGridActions(Panel mainPanel) {
		var actionsPanel = new Panel(mainPanel)
		actionsPanel.setLayout(new HorizontalLayout)
		new Button(actionsPanel)
			.setCaption("Nueva Materia")
			.onClick [ | this.agregarMateria]
		
	}


	// ** Acciones
	def void agregarMateria() {
		this.openDialog(new CrearMateriaWindow(this))
	}
	
	def void editarNota() {
		this.openDialog(new EditarNotaWindow(this))
	}



	def openDialog(Dialog<?> dialog) {
		dialog.onAccept[|modelObject.iniciar]
		dialog.open
	}

}
