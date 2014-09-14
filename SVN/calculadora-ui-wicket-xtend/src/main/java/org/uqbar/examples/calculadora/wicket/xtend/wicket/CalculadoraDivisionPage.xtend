package org.uqbar.examples.calculadora.wicket.xtend.wicket

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.markup.html.form.TextField
import org.apache.wicket.markup.html.panel.FeedbackPanel
import org.apache.wicket.model.CompoundPropertyModel
import org.uqbar.examples.calculadora.wicket.xtend.domain.CalculadoraDivision
import org.uqbar.wicket.xtend.PropertyValidator
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import org.uqbar.wicket.xtend.XButton
import org.uqbar.wicket.xtend.XForm

/**
 * @author jfernandes
 */
class CalculadoraDivisionPage extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	
	new() {
		val form = new XForm<CalculadoraDivision>("calculadoraForm", new CompoundPropertyModel(new CalculadoraDivision))
		this.addChild(form)
		
		this.addFields(form)
		this.addActions(form)
	}
	
	def addFields(Form<CalculadoraDivision> form) {
		form.addChild(crearDividendoTextField(form))
		form.addChild(crearDivisorTextField(form))
		form.addChild(new Label("resultado"))
		form.addChild(new FeedbackPanel("feedbackPanel"))
	}
	
	def crearDividendoTextField(Form<CalculadoraDivision> form) {
		// dividendo
		val dividendoTextField = new TextField<Double>("dividendo")
		// agregamos un validator
		dividendoTextField.add([validatable |
			form.modelObject.validarDividendo(validatable.value) 
		])
		return dividendoTextField
	}
	
	def crearDivisorTextField(Form<CalculadoraDivision> form) {
		val divisorTextField = new TextField<Double>("divisor")
		divisorTextField.add(new PropertyValidator)  // validator generico, llama a un método del dominio validarXXXX()
		return divisorTextField
	}
	
	def addActions(Form<CalculadoraDivision> form) {
		val button = new XButton("dividir")
		button.onClick = [| form.modelObject.dividir ]
		form.addChild(button)
	}

}