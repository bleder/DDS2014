package arena.prueba.seguidor.ui;

import arena.prueba.seguidor.applicationModel.IniciarMateria;
import arena.prueba.seguidor.domain.Materia;
import arena.prueba.seguidor.ui.CrearMateriaWindow;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.CheckBox;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;

/**
 * Ventana de búsqueda de celulares.
 * 
 * @see BuscadorCelular el modelo subyacente.
 * 
 * @author ?
 */
@SuppressWarnings("all")
public class IniciarMateriasWindow extends SimpleWindow<IniciarMateria> {
  public IniciarMateriasWindow(final WindowOwner parent) {
    super(parent, new IniciarMateria());
    IniciarMateria _modelObject = this.getModelObject();
    _modelObject.iniciar();
  }
  
  /**
   * El default de la vista es un formulario que permite disparar la búsqueda (invocando con super) Además
   * le agregamos una grilla con los resultados de esa búsqueda y acciones que pueden hacerse con elementos
   * de esa búsqueda
   */
  public void createMainTemplate(final Panel mainPanel) {
    this.setTitle("Seguidor de carrera");
    this.setTaskDescription("Seguidor de carrera");
    super.createMainTemplate(mainPanel);
    this.createResultsGrid(mainPanel);
    this.createGridActions(mainPanel);
  }
  
  /**
   * El panel principal de búsuqeda permite filtrar por número o nombre
   */
  public void createFormPanel(final Panel mainPanel) {
    Panel panel = new Panel(mainPanel);
    ColumnLayout _columnLayout = new ColumnLayout(2);
    panel.setLayout(_columnLayout);
    Label labelNumero = new Label(panel);
    labelNumero.setText("MATERIA:");
    TextBox _textBox = new TextBox(panel);
    _textBox.<ControlBuilder>bindValueToProperty("materiaSeleccionada.nombre");
    Label _label = new Label(panel);
    _label.setText("Anio:");
    TextBox _textBox_1 = new TextBox(panel);
    _textBox_1.<ControlBuilder>bindValueToProperty("materiaSeleccionada.anio");
    Label _label_1 = new Label(panel);
    _label_1.setText("Profesor:");
    TextBox _textBox_2 = new TextBox(panel);
    _textBox_2.<ControlBuilder>bindValueToProperty("materiaSeleccionada.profe");
    Label _label_2 = new Label(panel);
    _label_2.setText("Final Aprobado:");
    CheckBox check = new CheckBox(panel);
    check.<ControlBuilder>bindValueToProperty("materiaSeleccionada.finalAprobado");
  }
  
  /**
   * Acciones asociadas de la pantalla principal. Interesante para ver es cómo funciona el binding que mapea
   * la acción que se dispara cuando el usuario presiona click Para que el binding sea flexible necesito
   * decirle objeto al que disparo la acción y el mensaje a enviarle Contra: estoy atado a tener métodos sin
   * parámetros. Eso me impide poder pasarle parámetros como en el caso del alta/modificación.
   * Buscar/Limpiar -> son acciones que resuelve el modelo (BuscadorCelular) Nuevo -> necesita disparar una
   * pantalla de alta, entonces lo resuelve la vista (this)
   */
  protected void addActions(final Panel actionsPanel) {
  }
  
  /**
   * Se crea la grilla en el panel de abajo El binding es: el contenido de la grilla en base a los
   * resultados de la búsqueda Cuando el usuario presiona Buscar, se actualiza el model, y éste a su vez
   * dispara la notificación a la grilla que funciona como Observer
   */
  protected void createResultsGrid(final Panel mainPanel) {
    Table<Materia> table = new Table<Materia>(mainPanel, Materia.class);
    table.setHeigth(200);
    table.setWidth(450);
    table.bindItemsToProperty("resultados");
    table.<ControlBuilder>bindValueToProperty("materiaSeleccionada");
    this.describeResultsGrid(table);
  }
  
  /**
   * Define las columnas de la grilla Cada columna se puede bindear 1) contra una propiedad del model, como
   * en el caso del número o el nombre 2) contra un transformer que recibe el model y devuelve un tipo
   * (generalmente String), como en el caso de Recibe Resumen de Cuenta
   * 
   * @param table
   */
  public void describeResultsGrid(final Table<Materia> table) {
    Column<Materia> _column = new Column<Materia>(table);
    Column<Materia> _setTitle = _column.setTitle("Materia");
    Column<Materia> _setFixedSize = _setTitle.setFixedSize(150);
    _setFixedSize.bindContentsToProperty("nombre");
  }
  
  public void createGridActions(final Panel mainPanel) {
    Panel actionsPanel = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    actionsPanel.setLayout(_horizontalLayout);
    Button _button = new Button(actionsPanel);
    Button _setCaption = _button.setCaption("Nueva Materia");
    final Action _function = new Action() {
      public void execute() {
        IniciarMateriasWindow.this.agregarMateria();
      }
    };
    Button nueva = _setCaption.onClick(_function);
  }
  
  public void agregarMateria() {
    CrearMateriaWindow _crearMateriaWindow = new CrearMateriaWindow(this);
    this.openDialog(_crearMateriaWindow);
  }
  
  public void openDialog(final Dialog<?> dialog) {
    final Action _function = new Action() {
      public void execute() {
        IniciarMateria _modelObject = IniciarMateriasWindow.this.getModelObject();
        _modelObject.iniciar();
      }
    };
    dialog.onAccept(_function);
    dialog.open();
  }
}
