package uqbar.celulares.ui.wicket;

import java.util.List;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.commons.model.Home;
import org.uqbar.commons.model.UserException;
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods;
import org.uqbar.wicket.xtend.XButton;
import uqbar.celulares.domain.Celular;
import uqbar.celulares.domain.Modelo;
import uqbar.celulares.ui.wicket.BusquedaCelularesPage;

@SuppressWarnings("all")
public class EditarCelularPage extends WebPage {
  @Extension
  private WicketExtensionFactoryMethods _wicketExtensionFactoryMethods = new WicketExtensionFactoryMethods();
  
  private final Celular celular;
  
  private final boolean alta;
  
  private final BusquedaCelularesPage mainPage;
  
  public EditarCelularPage(final Celular celularAEditar, final BusquedaCelularesPage mainPage) {
    this.mainPage = mainPage;
    boolean _isNew = celularAEditar.isNew();
    this.alta = _isNew;
    this.celular = celularAEditar;
    String _xifexpression = null;
    if (this.alta) {
      _xifexpression = "Nuevo Celular";
    } else {
      _xifexpression = "Editar Datos del Celular";
    }
    Label _label = new Label("titulo", _xifexpression);
    this._wicketExtensionFactoryMethods.addChild(this, _label);
    CompoundPropertyModel<Celular> _asCompoundModel = this._wicketExtensionFactoryMethods.<Celular>asCompoundModel(this.celular);
    final Form<Celular> buscarForm = new Form<Celular>("nuevoCelularForm", _asCompoundModel);
    this.agregarCamposEdicion(buscarForm);
    this.agregarAcciones(buscarForm);
    this._wicketExtensionFactoryMethods.addChild(this, buscarForm);
  }
  
  public void agregarAcciones(final Form<Celular> parent) {
    XButton _xButton = new XButton("aceptar");
    final Procedure1<XButton> _function = new Procedure1<XButton>() {
      public void apply(final XButton it) {
        final Procedure0 _function = new Procedure0() {
          public void apply() {
            try {
              EditarCelularPage.this.celular.validar();
              if (EditarCelularPage.this.alta) {
                Home<Celular> _home = EditarCelularPage.this._wicketExtensionFactoryMethods.<Celular>home(Celular.class);
                _home.create(EditarCelularPage.this.celular);
              } else {
                Home<Celular> _home_1 = EditarCelularPage.this._wicketExtensionFactoryMethods.<Celular>home(Celular.class);
                _home_1.delete(EditarCelularPage.this.celular);
                Home<Celular> _home_2 = EditarCelularPage.this._wicketExtensionFactoryMethods.<Celular>home(Celular.class);
                _home_2.create(EditarCelularPage.this.celular);
              }
              EditarCelularPage.this.volver();
            } catch (final Throwable _t) {
              if (_t instanceof UserException) {
                final UserException e = (UserException)_t;
                String _message = e.getMessage();
                it.info(_message);
              } else if (_t instanceof RuntimeException) {
                final RuntimeException e_1 = (RuntimeException)_t;
                it.error("Ocurrió un error al procesar el pedido del celular. Consulte al administrador del sistema");
              } else {
                throw Exceptions.sneakyThrow(_t);
              }
            }
          }
        };
        it.setOnClick(_function);
      }
    };
    XButton _doubleArrow = ObjectExtensions.<XButton>operator_doubleArrow(_xButton, _function);
    this._wicketExtensionFactoryMethods.addChild(parent, _doubleArrow);
    XButton _xButton_1 = new XButton("cancelar");
    final Procedure1<XButton> _function_1 = new Procedure1<XButton>() {
      public void apply(final XButton it) {
        final Procedure0 _function = new Procedure0() {
          public void apply() {
            EditarCelularPage.this.volver();
          }
        };
        it.setOnClick(_function);
      }
    };
    XButton _doubleArrow_1 = ObjectExtensions.<XButton>operator_doubleArrow(_xButton_1, _function_1);
    this._wicketExtensionFactoryMethods.addChild(parent, _doubleArrow_1);
  }
  
  public void volver() {
    this.mainPage.buscarCelulares();
    this.setResponsePage(this.mainPage);
  }
  
  public MarkupContainer agregarCamposEdicion(final Form<Celular> parent) {
    MarkupContainer _xblockexpression = null;
    {
      TextField<String> _textField = new TextField<String>("numero");
      this._wicketExtensionFactoryMethods.addChild(parent, _textField);
      TextField<String> _textField_1 = new TextField<String>("nombre");
      this._wicketExtensionFactoryMethods.addChild(parent, _textField_1);
      DropDownChoice<Modelo> _dropDownChoice = new DropDownChoice<Modelo>("modeloCelular");
      final Procedure1<DropDownChoice<Modelo>> _function = new Procedure1<DropDownChoice<Modelo>>() {
        public void apply(final DropDownChoice<Modelo> it) {
          final Function0<List<Modelo>> _function = new Function0<List<Modelo>>() {
            public List<Modelo> apply() {
              Home<Modelo> _home = EditarCelularPage.this._wicketExtensionFactoryMethods.<Modelo>home(Modelo.class);
              return _home.allInstances();
            }
          };
          LoadableDetachableModel<List<Modelo>> _loadableModel = EditarCelularPage.this._wicketExtensionFactoryMethods.<List<Modelo>>loadableModel(_function);
          it.setChoices(_loadableModel);
          final Function1<Modelo,String> _function_1 = new Function1<Modelo,String>() {
            public String apply(final Modelo m) {
              return m.getDescripcion();
            }
          };
          ChoiceRenderer<Modelo> _choiceRenderer = EditarCelularPage.this._wicketExtensionFactoryMethods.<Modelo>choiceRenderer(_function_1);
          it.setChoiceRenderer(_choiceRenderer);
        }
      };
      DropDownChoice<Modelo> _doubleArrow = ObjectExtensions.<DropDownChoice<Modelo>>operator_doubleArrow(_dropDownChoice, _function);
      this._wicketExtensionFactoryMethods.addChild(parent, _doubleArrow);
      CheckBox _checkBox = new CheckBox("recibeResumenCuenta");
      this._wicketExtensionFactoryMethods.addChild(parent, _checkBox);
      FeedbackPanel _feedbackPanel = new FeedbackPanel("feedbackPanel");
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(parent, _feedbackPanel);
    }
    return _xblockexpression;
  }
}
