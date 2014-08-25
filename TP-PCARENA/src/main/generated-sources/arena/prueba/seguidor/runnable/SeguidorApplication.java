package arena.prueba.seguidor.runnable;

import arena.prueba.seguidor.ui.CrearSeguidorWindow;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

@SuppressWarnings("all")
public class SeguidorApplication extends Application {
  public Window<?> createMainWindow() {
    return new CrearSeguidorWindow(this);
  }
  
  public static void main(final String[] args) {
    SeguidorApplication _seguidorApplication = new SeguidorApplication();
    _seguidorApplication.start();
  }
}
