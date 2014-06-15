package utn.edu.dds.TP_OPF5.test;

import exception.NoExisteMailException;
import exception.NoExisteTalJugadorException;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import partido.core.Jugador;
import partido.core.Partido;
import partido.nuevosJugadores.Administrador;
import partido.nuevosJugadores.Propuesta;
import partido.nuevosJugadores.Rechazo;

@SuppressWarnings("all")
public class TstNuevosJugadores {
  private Jugador jugador;
  
  private Partido partido;
  
  private Administrador administrador;
  
  private String amigo;
  
  private String nombre;
  
  private List<String> mailsAmigos;
  
  @Before
  public void init() {
    Jugador _jugador = new Jugador("Rodolfo", "rodol@aol.com");
    this.jugador = _jugador;
    Administrador _administrador = new Administrador("admin@aol.com");
    this.administrador = _administrador;
    this.nombre = "julian";
    ArrayList<String> _arrayList = new ArrayList<String>();
    this.mailsAmigos = _arrayList;
    this.mailsAmigos.add("juan@hotmail.com");
    this.mailsAmigos.add("pepe@gmail.com");
    Partido _partido = new Partido("Partido_1", this.administrador);
    this.partido = _partido;
    this.amigo = "amigo@amail.com";
    this.jugador.agregarAmigo(this.amigo);
  }
  
  @Test
  public void jugadorCreaPropuestaLaPoseeElAdministrador() {
    Administrador _administrador = this.partido.getAdministrador();
    this.jugador.crearPropuesta(this.amigo, _administrador, this.nombre, this.mailsAmigos);
    Administrador _administrador_1 = this.partido.getAdministrador();
    boolean _existePropuesta = _administrador_1.existePropuesta(this.amigo);
    Assert.assertTrue(_existePropuesta);
  }
  
  @Test
  public void JugadorNoPuedeCrearPropuestaQueNoExisteAmigo() {
    String amigoQueNoEsta = "amigoNoEsta@hotmail.com";
    try {
      Administrador _administrador = this.partido.getAdministrador();
      this.jugador.crearPropuesta(amigoQueNoEsta, _administrador, this.nombre, this.mailsAmigos);
      Assert.fail("No se puede crear propuesta de un jugador que no es amigo");
    } catch (final Throwable _t) {
      if (_t instanceof NoExisteMailException) {
        final NoExisteMailException e = (NoExisteMailException)_t;
        Administrador _administrador_1 = this.partido.getAdministrador();
        List<Propuesta> _posiblesJugadores = _administrador_1.getPosiblesJugadores();
        boolean _isEmpty = _posiblesJugadores.isEmpty();
        Assert.assertTrue(_isEmpty);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Test
  public void adminAceptaPropuestaYJugadorLoPoseeEntreSusAmigos() {
    Administrador _administrador = this.partido.getAdministrador();
    this.jugador.crearPropuesta(this.amigo, _administrador, this.nombre, this.mailsAmigos);
    Administrador _administrador_1 = this.partido.getAdministrador();
    _administrador_1.aceptarPropuesta(this.amigo);
    boolean _existeAmigo = this.jugador.existeAmigo(this.amigo);
    Assert.assertTrue(_existeAmigo);
  }
  
  @Test
  public void adminNoPuedeAceptarPropuestaQueNoExiste() {
    List<String> _amigos = this.jugador.getAmigos();
    final int len = _amigos.size();
    String amigoQueNoEsta = "amigoNoEsta@hotmaill.com";
    try {
      this.administrador.aceptarPropuesta(amigoQueNoEsta);
      Assert.fail("No se puede aceptar propuesta que no existe");
    } catch (final Throwable _t) {
      if (_t instanceof NoExisteTalJugadorException) {
        final NoExisteTalJugadorException e = (NoExisteTalJugadorException)_t;
        List<String> _amigos_1 = this.jugador.getAmigos();
        int _size = _amigos_1.size();
        Assert.assertNotSame(Integer.valueOf(_size), Integer.valueOf((len + 1)));
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Test
  public void adminRechazaPropuestaYRegistraLaDenegacion() {
    List<Rechazo> _jugadoresRechazados = this.administrador.getJugadoresRechazados();
    final int len = _jugadoresRechazados.size();
    Administrador _administrador = this.partido.getAdministrador();
    this.jugador.crearPropuesta(this.amigo, _administrador, this.nombre, this.mailsAmigos);
    Administrador _administrador_1 = this.partido.getAdministrador();
    _administrador_1.rechazarPropuesta(this.amigo, "Rechazado por X motivo");
    List<Rechazo> _jugadoresRechazados_1 = this.administrador.getJugadoresRechazados();
    int _size = _jugadoresRechazados_1.size();
    boolean _equals = (_size == (len + 1));
    Assert.assertTrue(_equals);
  }
  
  @Test
  public void adminRechazaPropuestaNoExisteProduceError() {
    List<String> _amigos = this.jugador.getAmigos();
    final int len = _amigos.size();
    String amigoQueNoEsta = "amigoNoEsta@hotmail.com";
    try {
      this.administrador.rechazarPropuesta(amigoQueNoEsta, "Rechazado por X motivo");
      Assert.fail("No se puede rechazar propuesta que no existe");
    } catch (final Throwable _t) {
      if (_t instanceof NoExisteTalJugadorException) {
        final NoExisteTalJugadorException e = (NoExisteTalJugadorException)_t;
        List<String> _amigos_1 = this.jugador.getAmigos();
        int _size = _amigos_1.size();
        Assert.assertNotSame(Integer.valueOf(_size), Integer.valueOf((len + 1)));
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
