package arena.prueba.seguidor.ui;

import arena.prueba.seguidor.domain.Materia;
import arena.prueba.seguidor.home.HomeMaterias;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.utils.ApplicationContext;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;

@SuppressWarnings("all")
public class CrearMateriaWindow extends Dialog<Materia> {
  public CrearMateriaWindow(final WindowOwner owner) {
    super(owner, new Materia());
  }
  
  public void executeTask() {
    HomeMaterias _homeMaterias = this.getHomeMaterias();
    Materia _modelObject = this.getModelObject();
    _homeMaterias.create(_modelObject);
    super.executeTask();
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    final Panel form = new Panel(mainPanel);
    VerticalLayout _verticalLayout = new VerticalLayout();
    form.setLayout(_verticalLayout);
    Label _label = new Label(form);
    _label.setText("Nombre:");
    TextBox _textBox = new TextBox(form);
    _textBox.<ControlBuilder>bindValueToProperty("nombre");
  }
  
  protected void addActions(final Panel actions) {
    Button _button = new Button(actions);
    Button _setCaption = _button.setCaption("Aceptar");
    final Action _function = new Action() {
      public void execute() {
        CrearMateriaWindow.this.accept();
      }
    };
    Button _onClick = _setCaption.onClick(_function);
    Button _setAsDefault = _onClick.setAsDefault();
    _setAsDefault.disableOnError();
    Button _button_1 = new Button(actions);
    Button _setCaption_1 = _button_1.setCaption("Volver");
    final Action _function_1 = new Action() {
      public void execute() {
        CrearMateriaWindow.this.cancel();
      }
    };
    _setCaption_1.onClick(_function_1);
  }
  
  public HomeMaterias getHomeMaterias() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    Object _singleton = _instance.<Object>getSingleton(Materia.class);
    return ((HomeMaterias) _singleton);
  }
}
