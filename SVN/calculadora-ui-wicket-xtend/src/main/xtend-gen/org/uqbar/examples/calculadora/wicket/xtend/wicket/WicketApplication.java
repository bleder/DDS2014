package org.uqbar.examples.calculadora.wicket.xtend.wicket;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.uqbar.examples.calculadora.wicket.xtend.wicket.CalculadoraDivisionPage;

/**
 * Wicket application
 */
@SuppressWarnings("all")
public class WicketApplication extends WebApplication {
  public Class<? extends Page> getHomePage() {
    return CalculadoraDivisionPage.class;
  }
}
