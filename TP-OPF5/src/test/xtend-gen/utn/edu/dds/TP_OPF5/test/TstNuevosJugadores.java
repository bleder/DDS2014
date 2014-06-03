package utn.edu.dds.TP_OPF5.test;

import exception.NoExisteTalJugadorException;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import partido.core.Jugador;
import partido.core.Partido;
import partido.nuevosJugadores.Administrador;

@SuppressWarnings("all")
public class TstNuevosJugadores {
  private Jugador jugador;
  
  private Partido partido;
  
  private Administrador administrador;
  
  private String amigo;
  
  @Before
  public void init() {
    Jugador _jugador = new Jugador("Rodolfo", "rodol@aol.com");
    this.jugador = _jugador;
    Administrador _administrador = new Administrador("admin@aol.com");
    this.administrador = _administrador;
    Partido _partido = new Partido("Partido_1", this.administrador);
    this.partido = _partido;
    this.amigo = "amigo@amail.com";
    this.jugador.agregarAmigo(this.amigo);
  }
  
  @Test
  public void jugadorCreaPropuestaLaPoseeElAdministrador() {
    throw new Error("Unresolved compilation problems:"
      + "\nInvalid number of arguments. The method crearPropuesta(String, Administrador, String, List<String>) is not applicable for the arguments (String,Administrador)");
  }
  
  @Test
  public void JugadorCreaPropuestaNoExisteAmigoProduceError() {
    throw new Error("Unresolved compilation problems:"
      + "\nInvalid number of arguments. The method crearPropuesta(String, Administrador, String, List<String>) is not applicable for the arguments (String,Administrador)");
  }
  
  @Test
  public void adminAceptaPropuestaYJugadorLoPoseeEntreSusAmigos() {
    throw new Error("Unresolved compilation problems:"
      + "\nInvalid number of arguments. The method crearPropuesta(String, Administrador, String, List<String>) is not applicable for the arguments (String,Administrador)"
      + "\nInvalid number of arguments. The method aceptarPropuesta(String) is not applicable for the arguments (String,String,ArrayList<Object>)");
  }
  
  @Test
  public void adminAceptaPropuestaNoExisteProduceError() {
    throw new Error("Unresolved compilation problems:"
      + "\nInvalid number of arguments. The method aceptarPropuesta(String) is not applicable for the arguments (String,String,ArrayList<Object>)");
  }
  
  @Test
  public void adminRechazaPropuestaYRegistraLaDenegacion() {
    throw new Error("Unresolved compilation problems:"
      + "\nInvalid number of arguments. The method crearPropuesta(String, Administrador, String, List<String>) is not applicable for the arguments (String,Administrador)");
  }
  
  @Test
  public void adminRechazaPropuestaNoExisteProduceError() {
    List<String> _amigos = this.jugador.getAmigos();
    final int len = _amigos.size();
    String amigoQueNoEsta = "amigoNoEsta@hotmail.com";
    try {
      this.administrador.rechazarPropuesta(amigoQueNoEsta, "pepe");
    } catch (final Throwable _t) {
      if (_t instanceof NoExisteTalJugadorException) {
        final NoExisteTalJugadorException e = (NoExisteTalJugadorException)_t;
        List<String> _amigos_1 = this.jugador.getAmigos();
        int _size = _amigos_1.size();
        boolean _equals = (_size == (len + 1));
        Assert.assertFalse(_equals);
        return;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    Assert.assertFalse(true);
  }
}
