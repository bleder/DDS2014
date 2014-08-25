package arena.prueba.seguidor.ui;

import arena.prueba.seguidor.domain.ManejadorMaterias;
import arena.prueba.seguidor.domain.Materia;
import arena.prueba.seguidor.ui.NuevaMateria;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.utils.Observable;
import org.uqbar.lacar.ui.model.Action;

@Observable
@SuppressWarnings("all")
public class CrearSeguidorWindow extends SimpleWindow<ManejadorMaterias> {
  public CrearSeguidorWindow(final WindowOwner parent) {
    super(parent, new ManejadorMaterias());
    this.setTitle("Seguidor de carrera");
    this.setTaskDescription("Seguidor de carrera");
  }
  
  public void createFormPanel(final Panel mainPanel) {
    final Panel editorPanel = new Panel(mainPanel);
    VerticalLayout _verticalLayout = new VerticalLayout();
    editorPanel.setLayout(_verticalLayout);
    Label _label = new Label(editorPanel);
    _label.setText("Materias");
    Table<Materia> table = new Table<Materia>(mainPanel, Materia.class);
    table.setHeigth(200);
    table.setWidth(400);
    table.bindItemsToProperty("materias");
    Column<Materia> _column = new Column<Materia>(table);
    Column<Materia> _setTitle = _column.setTitle("Nombre");
    Column<Materia> _setFixedSize = _setTitle.setFixedSize(150);
    _setFixedSize.bindContentsToProperty("nombre");
    Column<Materia> _column_1 = new Column<Materia>(table);
    Column<Materia> _setTitle_1 = _column_1.setTitle("");
    Column<Materia> _setFixedSize_1 = _setTitle_1.setFixedSize(150);
    _setFixedSize_1.bindContentsToProperty("");
  }
  
  public void addActions(final Panel actionsPanel) {
    Button _button = new Button(actionsPanel);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Nueva Materia");
        it.setAsDefault();
        final Action _function = new Action() {
          public void execute() {
            CrearSeguidorWindow.this.nuevaMateria();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
  }
  
  public void nuevaMateria() {
    NuevaMateria _nuevaMateria = new NuevaMateria(this);
    this.openDialog(_nuevaMateria);
  }
  
  public void openDialog(final NuevaMateria dialog) {
    final Action _function = new Action() {
      public void execute() {
        CrearSeguidorWindow.this.getModelObject();
      }
    };
    dialog.onAccept(_function);
    dialog.open();
  }
}
