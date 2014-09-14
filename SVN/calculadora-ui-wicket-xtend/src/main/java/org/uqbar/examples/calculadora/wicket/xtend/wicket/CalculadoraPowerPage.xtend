package org.uqbar.examples.calculadora.wicket.xtend.wicket

import org.apache.wicket.markup.html.WebPage
import org.uqbar.examples.calculadora.wicket.xtend.domain.CalculadoraDivision
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods

/**
 * Version de la calculadora de division haciendo uso del poder
 * de extension methods de xtend.
 * 
 * @author jfernandes
 */
class CalculadoraPowerPage extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	
	new() {
		defaultModel = (new CalculadoraDivision).asCompoundModel
		this.form("calculadoraForm") [

			textField("dividendo")
			textField("divisor")
			label("resultado")
			feedbackPanel("feedbackPanel")
			
			button("dividir") [
				onClick = [| calculadora.dividir ]
			]
		]
	}
	
	def getCalculadora() {
		this.defaultModelObject as CalculadoraDivision
	}
	
}