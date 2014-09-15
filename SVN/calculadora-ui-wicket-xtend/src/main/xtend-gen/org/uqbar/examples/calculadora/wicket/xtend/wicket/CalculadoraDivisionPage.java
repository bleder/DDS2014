package org.uqbar.examples.calculadora.wicket.xtend.wicket;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.uqbar.examples.calculadora.wicket.xtend.domain.CalculadoraDivision;
import org.uqbar.wicket.xtend.PropertyValidator;
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods;
import org.uqbar.wicket.xtend.XButton;
import org.uqbar.wicket.xtend.XForm;

/**
 * @author jfernandes
 */
@SuppressWarnings("all")
public class CalculadoraDivisionPage extends WebPage {
  @Extension
  private WicketExtensionFactoryMethods _wicketExtensionFactoryMethods = new WicketExtensionFactoryMethods();
  
  public CalculadoraDivisionPage() {
    CalculadoraDivision _calculadoraDivision = new CalculadoraDivision();
    CompoundPropertyModel<Object> _compoundPropertyModel = new CompoundPropertyModel<Object>(_calculadoraDivision);
    final XForm<CalculadoraDivision> form = new XForm<CalculadoraDivision>("calculadoraForm", _compoundPropertyModel);
    this._wicketExtensionFactoryMethods.addChild(this, form);
    this.addFields(form);
    this.addActions(form);
  }
  
  public MarkupContainer addFields(final Form<CalculadoraDivision> form) {
    MarkupContainer _xblockexpression = null;
    {
      TextField<Double> _crearDividendoTextField = this.crearDividendoTextField(form);
      this._wicketExtensionFactoryMethods.addChild(form, _crearDividendoTextField);
      TextField<Double> _crearDivisorTextField = this.crearDivisorTextField(form);
      this._wicketExtensionFactoryMethods.addChild(form, _crearDivisorTextField);
      Label _label = new Label("resultado");
      this._wicketExtensionFactoryMethods.addChild(form, _label);
      FeedbackPanel _feedbackPanel = new FeedbackPanel("feedbackPanel");
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(form, _feedbackPanel);
    }
    return _xblockexpression;
  }
  
  public TextField<Double> crearDividendoTextField(final Form<CalculadoraDivision> form) {
    final TextField<Double> dividendoTextField = new TextField<Double>("dividendo");
    final IValidator<Double> _function = new IValidator<Double>() {
      public void validate(final IValidatable<Double> validatable) {
        CalculadoraDivision _modelObject = form.getModelObject();
        Double _value = validatable.getValue();
        _modelObject.validarDividendo(_value);
      }
    };
    dividendoTextField.add(_function);
    return dividendoTextField;
  }
  
  public TextField<Double> crearDivisorTextField(final Form<CalculadoraDivision> form) {
    final TextField<Double> divisorTextField = new TextField<Double>("divisor");
    PropertyValidator<Double> _propertyValidator = new PropertyValidator<Double>();
    divisorTextField.add(_propertyValidator);
    return divisorTextField;
  }
  
  public MarkupContainer addActions(final Form<CalculadoraDivision> form) {
    MarkupContainer _xblockexpression = null;
    {
      final XButton button = new XButton("dividir");
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          CalculadoraDivision _modelObject = form.getModelObject();
          _modelObject.dividir();
        }
      };
      button.setOnClick(_function);
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(form, button);
    }
    return _xblockexpression;
  }
}
