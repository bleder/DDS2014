package utn.edu.dds.TP_OPF5_VIEW;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.CompoundPropertyModel;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods;
import org.uqbar.wicket.xtend.XButton;
import utn.edu.dds.TP_OPF5_VIEW.GenerarEquiposPage;

@SuppressWarnings("all")
public class OFHomePage extends WebPage {
  @Extension
  private WicketExtensionFactoryMethods _wicketExtensionFactoryMethods = new WicketExtensionFactoryMethods();
  
  public OFHomePage() {
    Object objeto = null;
    CompoundPropertyModel<Object> _compoundPropertyModel = new CompoundPropertyModel<Object>(objeto);
    final Form<Object> generalForm = new Form<Object>("generalForm", _compoundPropertyModel);
    this.agregarAcciones(generalForm);
    this._wicketExtensionFactoryMethods.addChild(this, generalForm);
  }
  
  public MarkupContainer agregarAcciones(final Form<Object> form) {
    MarkupContainer _xblockexpression = null;
    {
      XButton _xButton = new XButton("GenerarEquipos");
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          OFHomePage.this.generarEquipos();
        }
      };
      XButton _setOnClick = _xButton.setOnClick(_function);
      this._wicketExtensionFactoryMethods.addChild(form, _setOnClick);
      XButton _xButton_1 = new XButton("BuscarJ");
      final Procedure0 _function_1 = new Procedure0() {
        public void apply() {
        }
      };
      XButton _setOnClick_1 = _xButton_1.setOnClick(_function_1);
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(form, _setOnClick_1);
    }
    return _xblockexpression;
  }
  
  public void generarEquipos() {
    GenerarEquiposPage _generarEquiposPage = new GenerarEquiposPage();
    this.setResponsePage(_generarEquiposPage);
  }
}
