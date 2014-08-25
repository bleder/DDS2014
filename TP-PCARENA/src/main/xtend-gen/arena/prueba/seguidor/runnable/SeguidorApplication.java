package arena.prueba.seguidor.runnable;

import arena.prueba.seguidor.domain.Materia;
import arena.prueba.seguidor.home.HomeMateria;
import arena.prueba.seguidor.ui.CrearSeguidorWindow;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import org.uqbar.commons.utils.ApplicationContext;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class SeguidorApplication extends Application {
  public Window<?> createMainWindow() {
    return new CrearSeguidorWindow(this);
  }
  
  public static void main(final String[] args) {
    ApplicationContext _instance = ApplicationContext.getInstance();
    HomeMateria _homeMateria = new HomeMateria();
    _instance.<HomeMateria>configureSingleton(Materia.class, _homeMateria);
    SeguidorApplication _seguidorApplication = new SeguidorApplication();
    _seguidorApplication.start();
  }
}
