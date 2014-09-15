package org.uqbar.examples.calculadora.wicket.xtend.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.CompoundPropertyModel;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.examples.calculadora.wicket.xtend.domain.CalculadoraDivision;
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods;
import org.uqbar.wicket.xtend.XButton;

/**
 * Version de la calculadora de division haciendo uso del poder
 * de extension methods de xtend.
 * 
 * @author jfernandes
 */
@SuppressWarnings("all")
public class CalculadoraPowerPage extends WebPage {
  @Extension
  private WicketExtensionFactoryMethods _wicketExtensionFactoryMethods = new WicketExtensionFactoryMethods();
  
  public CalculadoraPowerPage() {
    CalculadoraDivision _calculadoraDivision = new CalculadoraDivision();
    CompoundPropertyModel<CalculadoraDivision> _asCompoundModel = this._wicketExtensionFactoryMethods.<CalculadoraDivision>asCompoundModel(_calculadoraDivision);
    this.setDefaultModel(_asCompoundModel);
    final Procedure1<Form<Object>> _function = new Procedure1<Form<Object>>() {
      public void apply(final Form<Object> it) {
        CalculadoraPowerPage.this._wicketExtensionFactoryMethods.<Object>textField(it, "dividendo");
        CalculadoraPowerPage.this._wicketExtensionFactoryMethods.<Object>textField(it, "divisor");
        CalculadoraPowerPage.this._wicketExtensionFactoryMethods.label(it, "resultado");
        CalculadoraPowerPage.this._wicketExtensionFactoryMethods.feedbackPanel(it, "feedbackPanel");
        final Procedure1<XButton> _function = new Procedure1<XButton>() {
          public void apply(final XButton it) {
            final Procedure0 _function = new Procedure0() {
              public void apply() {
                CalculadoraDivision _calculadora = CalculadoraPowerPage.this.getCalculadora();
                _calculadora.dividir();
              }
            };
            it.setOnClick(_function);
          }
        };
        CalculadoraPowerPage.this._wicketExtensionFactoryMethods.button(it, "dividir", _function);
      }
    };
    this._wicketExtensionFactoryMethods.<Object>form(this, "calculadoraForm", _function);
  }
  
  public CalculadoraDivision getCalculadora() {
    Object _defaultModelObject = this.getDefaultModelObject();
    return ((CalculadoraDivision) _defaultModelObject);
  }
}
