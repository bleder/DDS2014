package org.uqbar.examples.calculadora.wicket.xtend.wicket

import org.apache.wicket.protocol.http.WebApplication

/**
 * Wicket application
 */
class WicketApplication extends WebApplication {
	
	override getHomePage() {
		CalculadoraDivisionPage
	}
	
}