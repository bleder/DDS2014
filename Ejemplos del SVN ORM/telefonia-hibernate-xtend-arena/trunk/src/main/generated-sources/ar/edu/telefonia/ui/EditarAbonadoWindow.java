package ar.edu.telefonia.ui;

import ar.edu.telefonia.domain.Abonado;
import ar.edu.telefonia.repo.RepoTelefonia;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;

@SuppressWarnings("all")
public abstract class EditarAbonadoWindow extends Dialog<Abonado> {
  public EditarAbonadoWindow(final WindowOwner owner, final Abonado model) {
    super(owner, model);
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    final Panel form = new Panel(mainPanel);
    ColumnLayout _columnLayout = new ColumnLayout(2);
    form.setLayout(_columnLayout);
    Label _label = new Label(form);
    _label.setText("Número");
    final TextBox textNumero = new TextBox(form);
    textNumero.<Object, ControlBuilder>bindValueToProperty("numero");
    Label _label_1 = new Label(form);
    _label_1.setText("Nombre");
    TextBox _textBox = new TextBox(form);
    _textBox.<Object, ControlBuilder>bindValueToProperty("nombre");
    this.addFormPanel(form);
  }
  
  public abstract void addFormPanel(final Panel panel);
  
  protected void addActions(final Panel actions) {
    Button _button = new Button(actions);
    Button _setCaption = _button.setCaption("Aceptar");
    final Action _function = new Action() {
      public void execute() {
        EditarAbonadoWindow.this.aceptar();
      }
    };
    Button _onClick = _setCaption.onClick(_function);
    Button _setAsDefault = _onClick.setAsDefault();
    _setAsDefault.disableOnError();
    Button _button_1 = new Button(actions);
    Button _setCaption_1 = _button_1.setCaption("Cancelar");
    final Action _function_1 = new Action() {
      public void execute() {
        EditarAbonadoWindow.this.cancel();
      }
    };
    _setCaption_1.onClick(_function_1);
  }
  
  public void aceptar() {
    RepoTelefonia _instance = RepoTelefonia.getInstance();
    Abonado _modelObject = this.getModelObject();
    _instance.actualizarAbonado(_modelObject);
    this.close();
  }
}
