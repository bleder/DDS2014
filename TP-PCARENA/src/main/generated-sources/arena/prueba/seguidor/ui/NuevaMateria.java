package arena.prueba.seguidor.ui;

import arena.prueba.seguidor.domain.Materia;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;

@SuppressWarnings("all")
public class NuevaMateria extends Dialog<Materia> {
  public NuevaMateria(final WindowOwner owner) {
    super(owner, new Materia());
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    final Panel form = new Panel(mainPanel);
    VerticalLayout _verticalLayout = new VerticalLayout();
    form.setLayout(_verticalLayout);
    Label _label = new Label(form);
    _label.setText("Nombre");
    TextBox _textBox = new TextBox(form);
    _textBox.<ControlBuilder>bindValueToProperty("nombre");
  }
  
  protected void addActions(final Panel actions) {
    Button _button = new Button(actions);
    Button _setCaption = _button.setCaption("Aceptar");
    final Action _function = new Action() {
      public void execute() {
        NuevaMateria.this.accept();
      }
    };
    Button _onClick = _setCaption.onClick(_function);
    Button _setAsDefault = _onClick.setAsDefault();
    _setAsDefault.disableOnError();
  }
}
