package arena.prueba;

import arena.prueba.Conversor;
import java.awt.Color;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.SkinnableControl;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.ErrorsPanel;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;

/**
 * Ejemplo de conversor millas -> kilometros en xtend
 */
@SuppressWarnings("all")
public class ConversorWindow extends MainWindow<Conversor> {
  public ConversorWindow() {
    super(new Conversor());
  }
  
  public void createContents(final Panel mainPanel) {
    this.setTitle("Conversor de millas a kilometros (XTend)");
    VerticalLayout _verticalLayout = new VerticalLayout();
    mainPanel.setLayout(_verticalLayout);
    new ErrorsPanel(mainPanel, "Listo para convertir");
    Label _label = new Label(mainPanel);
    _label.setText("Ingrese la longitud en millas");
    TextBox _textBox = new TextBox(mainPanel);
    _textBox.<ControlBuilder>bindValueToProperty("millas");
    Button _button = new Button(mainPanel);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Convertir a kilometros");
        final Action _function = new Action() {
          public void execute() {
            Conversor _modelObject = ConversorWindow.this.getModelObject();
            _modelObject.convertir();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
    Label _label_1 = new Label(mainPanel);
    SkinnableControl _setBackground = _label_1.setBackground(Color.ORANGE);
    _setBackground.<ControlBuilder>bindValueToProperty("kilometros");
    Label _label_2 = new Label(mainPanel);
    _label_2.setText(" kilometros");
  }
  
  public static void main(final String[] args) {
    ConversorWindow _conversorWindow = new ConversorWindow();
    _conversorWindow.startApplication();
  }
}
