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

	/**
	 * El default de la vista es un formulario que permite disparar la búsqueda (invocando con super) Además
	 * le agregamos una grilla con los resultados de esa búsqueda y acciones que pueden hacerse con elementos
	 * de esa búsqueda
	 */
	override def createMainTemplate(Panel mainPanel) {
		title = "Seguidor de carrera"
		taskDescription = "Seguidor de carrera"

		super.createMainTemplate(mainPanel)

		this.createResultsGrid(mainPanel)
		this.createGridActions(mainPanel)
	}

	// *************************************************************************
	// * FORMULARIO DE BUSQUEDA
	// *************************************************************************
	/**
	 * El panel principal de búsuqeda permite filtrar por número o nombre
	 */
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
		//check.bindEnabledToProperty("habilita")
		check.bindValueToProperty("materiaSeleccionada.finalAprobado")
		

/*
		var labelNombre = new Label(searchFormPanel)
		labelNombre.text = "Nombre del cliente"
		labelNombre.foreground = Color::BLUE

		new TextBox(searchFormPanel).bindValueToProperty("nombre")
		
		*/
	}

	/**
	 * Acciones asociadas de la pantalla principal. Interesante para ver es cómo funciona el binding que mapea
	 * la acción que se dispara cuando el usuario presiona click Para que el binding sea flexible necesito
	 * decirle objeto al que disparo la acción y el mensaje a enviarle Contra: estoy atado a tener métodos sin
	 * parámetros. Eso me impide poder pasarle parámetros como en el caso del alta/modificación.
	 * Buscar/Limpiar -> son acciones que resuelve el modelo (BuscadorCelular) Nuevo -> necesita disparar una
	 * pantalla de alta, entonces lo resuelve la vista (this)
	 *
	 */
	override protected addActions(Panel actionsPanel) {
		/* 
		new Button(actionsPanel)
			.setCaption("Buscar")
			.onClick [ | modelObject.search ] 
			.setAsDefault
			.disableOnError

		new Button(actionsPanel) //
			.setCaption("Limpiar")
			.onClick [ | modelObject.clear ]

		new Button(actionsPanel) //
			.setCaption("Nuevo Celular")
			.onClick [ | this.crearCelular ]
			
			*/
	}

	// *************************************************************************
	// ** RESULTADOS DE LA BUSQUEDA
	// *************************************************************************
	/**
	 * Se crea la grilla en el panel de abajo El binding es: el contenido de la grilla en base a los
	 * resultados de la búsqueda Cuando el usuario presiona Buscar, se actualiza el model, y éste a su vez
	 * dispara la notificación a la grilla que funciona como Observer
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
	 * Define las columnas de la grilla Cada columna se puede bindear 1) contra una propiedad del model, como
	 * en el caso del número o el nombre 2) contra un transformer que recibe el model y devuelve un tipo
	 * (generalmente String), como en el caso de Recibe Resumen de Cuenta
	 *
	 * @param table
	 */
	def void describeResultsGrid(Table<Materia> table) {
		new Column<Materia>(table) //
			.setTitle("Materia")
			.setFixedSize(150)
			.bindContentsToProperty("nombre")
		

/* 
		new Column<Materia>(table) //
			.setTitle("BOTON")
			.setFixedSize(100)
			//.bindContentsToProperty("numero")
			
			*/
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
