package uqbar.celulares.ui.wicket;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.model.CompoundPropertyModel;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods;
import org.uqbar.wicket.xtend.XButton;
import org.uqbar.wicket.xtend.XListView;
import uqbar.celulares.domain.BuscadorCelular;
import uqbar.celulares.domain.Celular;
import uqbar.celulares.ui.wicket.EditarCelularPage;

/**
 * Pagina de busqueda de la aplicacion de celulares.
 */
@SuppressWarnings("all")
public class BusquedaCelularesPage extends WebPage {
  @Extension
  private WicketExtensionFactoryMethods _wicketExtensionFactoryMethods = new WicketExtensionFactoryMethods();
  
  private BuscadorCelular buscador;
  
  public BusquedaCelularesPage() {
    BuscadorCelular _buscadorCelular = new BuscadorCelular();
    this.buscador = _buscadorCelular;
    CompoundPropertyModel<BuscadorCelular> _compoundPropertyModel = new CompoundPropertyModel<BuscadorCelular>(this.buscador);
    final Form<BuscadorCelular> buscarForm = new Form<BuscadorCelular>("buscarCelularesForm", _compoundPropertyModel);
    this.agregarCamposBusqueda(buscarForm);
    this.agregarAcciones(buscarForm);
    this.agregarGrillaResultados(buscarForm);
    this._wicketExtensionFactoryMethods.addChild(this, buscarForm);
    this.buscarCelulares();
  }
  
  public void buscarCelulares() {
    this.buscador.search();
  }
  
  public MarkupContainer agregarCamposBusqueda(final Form<BuscadorCelular> parent) {
    MarkupContainer _xblockexpression = null;
    {
      TextField<String> _textField = new TextField<String>("numero");
      this._wicketExtensionFactoryMethods.addChild(parent, _textField);
      TextField<String> _textField_1 = new TextField<String>("nombre");
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(parent, _textField_1);
    }
    return _xblockexpression;
  }
  
  public MarkupContainer agregarAcciones(final Form<BuscadorCelular> parent) {
    MarkupContainer _xblockexpression = null;
    {
      final XButton buscarButton = new XButton("buscar");
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          BusquedaCelularesPage.this.buscador.search();
        }
      };
      buscarButton.setOnClick(_function);
      this._wicketExtensionFactoryMethods.addChild(parent, buscarButton);
      XButton _xButton = new XButton("limpiar");
      final Procedure0 _function_1 = new Procedure0() {
        public void apply() {
          BusquedaCelularesPage.this.buscador.clear();
        }
      };
      XButton _setOnClick = _xButton.setOnClick(_function_1);
      this._wicketExtensionFactoryMethods.addChild(parent, _setOnClick);
      XButton _xButton_1 = new XButton("nuevo");
      final Procedure0 _function_2 = new Procedure0() {
        public void apply() {
          Celular _celular = new Celular();
          BusquedaCelularesPage.this.editar(_celular);
        }
      };
      XButton _setOnClick_1 = _xButton_1.setOnClick(_function_2);
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(parent, _setOnClick_1);
    }
    return _xblockexpression;
  }
  
  public void editar(final Celular celular) {
    EditarCelularPage _editarCelularPage = new EditarCelularPage(celular, this);
    this.setResponsePage(_editarCelularPage);
  }
  
  public MarkupContainer agregarGrillaResultados(final Form<BuscadorCelular> parent) {
    MarkupContainer _xblockexpression = null;
    {
      final XListView<Celular> listView = new XListView<Celular>("resultados");
      final Procedure1<ListItem<Celular>> _function = new Procedure1<ListItem<Celular>>() {
        public void apply(final ListItem<Celular> item) {
          Celular _modelObject = item.getModelObject();
          CompoundPropertyModel<Celular> _asCompoundModel = BusquedaCelularesPage.this._wicketExtensionFactoryMethods.<Celular>asCompoundModel(_modelObject);
          item.setModel(_asCompoundModel);
          Label _label = new Label("nombre");
          BusquedaCelularesPage.this._wicketExtensionFactoryMethods.addChild(item, _label);
          Label _label_1 = new Label("numero");
          BusquedaCelularesPage.this._wicketExtensionFactoryMethods.addChild(item, _label_1);
          Label _label_2 = new Label("modeloCelular.descripcion");
          BusquedaCelularesPage.this._wicketExtensionFactoryMethods.addChild(item, _label_2);
          final CheckBox checkResumen = new CheckBox("recibeResumenCuenta");
          checkResumen.setEnabled(false);
          BusquedaCelularesPage.this._wicketExtensionFactoryMethods.addChild(item, checkResumen);
          XButton _xButton = new XButton("editar");
          final Procedure0 _function = new Procedure0() {
            public void apply() {
              Celular _modelObject = item.getModelObject();
              BusquedaCelularesPage.this.editar(_modelObject);
            }
          };
          XButton _setOnClick = _xButton.setOnClick(_function);
          BusquedaCelularesPage.this._wicketExtensionFactoryMethods.addChild(item, _setOnClick);
          XButton _xButton_1 = new XButton("eliminar");
          final Procedure0 _function_1 = new Procedure0() {
            public void apply() {
              Celular _modelObject = item.getModelObject();
              BusquedaCelularesPage.this.buscador.setCelularSeleccionado(_modelObject);
              BusquedaCelularesPage.this.buscador.eliminarCelularSeleccionado();
            }
          };
          XButton _setOnClick_1 = _xButton_1.setOnClick(_function_1);
          BusquedaCelularesPage.this._wicketExtensionFactoryMethods.addChild(item, _setOnClick_1);
        }
      };
      listView.setPopulateItem(_function);
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(parent, listView);
    }
    return _xblockexpression;
  }
}
