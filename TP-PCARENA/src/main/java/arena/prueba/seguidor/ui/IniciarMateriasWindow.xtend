package arena.prueba.seguidor.ui



import org.uqbar.arena.bindings.NotNullObservable
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
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.CheckBox

/**
 * Ventana de búsqueda de celulares.
 *
 * @see BuscadorCelular el modelo subyacente.
 *
 * @author ?
 */
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
		labelNumero.setText("MATERIA:")
		

		new TextBox(panel).bindValueToProperty("materiaSeleccionada.nombre")
		
		new Label(panel).setText("Anio:")
		new TextBox(panel).bindValueToProperty("materiaSeleccionada.anio")
		
		new Label(panel).setText("Profesor:")
		new TextBox(panel).bindValueToProperty("materiaSeleccionada.profe")
		
		new Label(panel).setText("Final Aprobado:")
		var check = new CheckBox(panel)
		check.bindValueToProperty("materiaSeleccionada.finalAprobado")
	}

	/**
	 *
	 */
	override protected addActions(Panel actionsPanel) {
	}

	/**
	 * Se crea la grilla en el panel de abajo
	 */
	def protected createResultsGrid(Panel mainPanel) {
		var table = new Table<Materia>(mainPanel, typeof(Materia))
		table.heigth = 200
		table.width = 450
		table.bindItemsToProperty("resultados")
		table.bindValueToProperty("materiaSeleccionada")
		this.describeResultsGrid(table)

	}

	/**
	 * Define las columnas de la grilla
	 */
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
		var nueva = new Button(actionsPanel)
			.setCaption("Nueva Materia")
			.onClick [ | this.agregarMateria]
		
	}

	// ********************************************************
	// ** Acciones
	// ********************************************************
	def void agregarMateria() {
		this.openDialog(new CrearMateriaWindow(this))
	}



	def openDialog(Dialog<?> dialog) {
		dialog.onAccept[|modelObject.iniciar]
		dialog.open
	}

}
