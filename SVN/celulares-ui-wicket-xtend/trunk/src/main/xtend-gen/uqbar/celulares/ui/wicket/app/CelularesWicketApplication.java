package uqbar.celulares.ui.wicket.app;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.uqbar.commons.utils.ApplicationContext;
import uqbar.celulares.domain.Celular;
import uqbar.celulares.domain.HomeCelulares;
import uqbar.celulares.domain.HomeModelos;
import uqbar.celulares.domain.Modelo;
import uqbar.celulares.ui.wicket.BusquedaCelularesPage;

@SuppressWarnings("all")
public class CelularesWicketApplication extends WebApplication {
  protected void init() {
    super.init();
    ApplicationContext _instance = ApplicationContext.getInstance();
    HomeModelos _homeModelos = new HomeModelos();
    _instance.<HomeModelos>configureSingleton(Modelo.class, _homeModelos);
    ApplicationContext _instance_1 = ApplicationContext.getInstance();
    HomeCelulares _homeCelulares = new HomeCelulares();
    _instance_1.<HomeCelulares>configureSingleton(Celular.class, _homeCelulares);
  }
  
  public Class<? extends Page> getHomePage() {
    return BusquedaCelularesPage.class;
  }
}
