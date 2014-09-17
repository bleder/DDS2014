package utn.edu.dds.TP_OPF5_VIEW;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.CompoundPropertyModel;
import org.eclipse.xtext.xbase.lib.Extension;
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods;
import org.uqbar.wicket.xtend.XButton;

@SuppressWarnings("all")
public class GenerarEquiposPage extends WebPage {
  @Extension
  private WicketExtensionFactoryMethods _wicketExtensionFactoryMethods = new WicketExtensionFactoryMethods();
  
  public GenerarEquiposPage() {
    Object unForm = null;
    CompoundPropertyModel<Object> _compoundPropertyModel = new CompoundPropertyModel<Object>(unForm);
    final Form<Object> generarEquiposForm = new Form<Object>("generarEquiposForm", _compoundPropertyModel);
    this.agregarAcciones(generarEquiposForm);
    this._wicketExtensionFactoryMethods.addChild(this, generarEquiposForm);
  }
  
  public MarkupContainer agregarAcciones(final Form<Object> form) {
    XButton _xButton = new XButton("Generar");
    return this._wicketExtensionFactoryMethods.addChild(form, _xButton);
  }
  
  public Object agregarCamposEdicion(final Form<Object> form) {
    return null;
  }
}
