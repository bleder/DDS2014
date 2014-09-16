package utn.edu.dds.TP_OPF5_VIEW;

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
  }
  
  public void agregarAcciones() {
    final XButton generarEquipos = new XButton("GenerarEquipos");
  }
}
