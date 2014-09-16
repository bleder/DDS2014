package utn.edu.dds.TP_OPF5_VIEW;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.CompoundPropertyModel;
import org.eclipse.xtext.xbase.lib.Extension;
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods;
import org.uqbar.wicket.xtend.XButton;

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
      this._wicketExtensionFactoryMethods.addChild(form, _xButton);
      XButton _xButton_1 = new XButton("BuscarJugadores");
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(form, _xButton_1);
    }
    return _xblockexpression;
  }
}
