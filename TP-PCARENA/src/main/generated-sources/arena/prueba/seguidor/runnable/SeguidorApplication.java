package arena.prueba.seguidor.runnable;

import arena.prueba.seguidor.domain.Materia;
import arena.prueba.seguidor.home.HomeMaterias;
import arena.prueba.seguidor.ui.IniciarMateriasWindow;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import org.uqbar.commons.utils.ApplicationContext;

@SuppressWarnings("all")
public class SeguidorApplication extends Application {
  public static void main(final String[] args) {
    SeguidorApplication _seguidorApplication = new SeguidorApplication();
    _seguidorApplication.start();
  }
  
  public Window<?> createMainWindow() {
    IniciarMateriasWindow _xblockexpression = null;
    {
      ApplicationContext _instance = ApplicationContext.getInstance();
      HomeMaterias _homeMaterias = new HomeMaterias();
      _instance.<HomeMaterias>configureSingleton(Materia.class, _homeMaterias);
      _xblockexpression = new IniciarMateriasWindow(this);
    }
    return _xblockexpression;
  }
}
