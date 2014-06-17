package partido.nuevosJugadores;

import com.google.common.base.Objects;
import exception.NoExisteTalJugadorException;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import partido.core.Jugador;
import partido.nuevosJugadores.Propuesta;
import partido.nuevosJugadores.Rechazo;
import partido.nuevosJugadores.jugadorBuilder;

@SuppressWarnings("all")
public class Administrador {
  private String _mail;
  
  public String getMail() {
    return this._mail;
  }
  
  public void setMail(final String mail) {
    this._mail = mail;
  }
  
  private List<Propuesta> _posiblesJugadores;
  
  public List<Propuesta> getPosiblesJugadores() {
    return this._posiblesJugadores;
  }
  
  public void setPosiblesJugadores(final List<Propuesta> posiblesJugadores) {
    this._posiblesJugadores = posiblesJugadores;
  }
  
  private List<Rechazo> _jugadoresRechazados;
  
  public List<Rechazo> getJugadoresRechazados() {
    return this._jugadoresRechazados;
  }
  
  public void setJugadoresRechazados(final List<Rechazo> jugadoresRechazados) {
    this._jugadoresRechazados = jugadoresRechazados;
  }
  
  public Administrador(final String adminMail) {
    this.setMail(adminMail);
    ArrayList<Propuesta> _arrayList = new ArrayList<Propuesta>();
    this.setPosiblesJugadores(_arrayList);
    ArrayList<Rechazo> _arrayList_1 = new ArrayList<Rechazo>();
    this.setJugadoresRechazados(_arrayList_1);
  }
  
  public boolean existePropuesta(final Propuesta propuesta) {
    List<Propuesta> _posiblesJugadores = this.getPosiblesJugadores();
    final Function1<Propuesta,Boolean> _function = new Function1<Propuesta,Boolean>() {
      public Boolean apply(final Propuesta p) {
        return Boolean.valueOf(Objects.equal(p, propuesta));
      }
    };
    return IterableExtensions.<Propuesta>exists(_posiblesJugadores, _function);
  }
  
  public Propuesta getPropuesta(final String mail) {
    List<Propuesta> _posiblesJugadores = this.getPosiblesJugadores();
    final Function1<Propuesta,Boolean> _function = new Function1<Propuesta,Boolean>() {
      public Boolean apply(final Propuesta propuesta) {
        String _mail = propuesta.getMail();
        return Boolean.valueOf(Objects.equal(_mail, mail));
      }
    };
    return IterableExtensions.<Propuesta>findFirst(_posiblesJugadores, _function);
  }
  
  public boolean removerPropuesta(final Propuesta propuesta) {
    List<Propuesta> _posiblesJugadores = this.getPosiblesJugadores();
    return _posiblesJugadores.remove(propuesta);
  }
  
  public boolean nuevaPropuesta(final Propuesta nuevaPropuesta) {
    List<Propuesta> _posiblesJugadores = this.getPosiblesJugadores();
    return _posiblesJugadores.add(nuevaPropuesta);
  }
  
  public Propuesta ultimaPropuestaAgregada() {
    Propuesta _xblockexpression = null;
    {
      List<Propuesta> _posiblesJugadores = this.getPosiblesJugadores();
      final int ultimo = _posiblesJugadores.size();
      List<Propuesta> _posiblesJugadores_1 = this.getPosiblesJugadores();
      _xblockexpression = _posiblesJugadores_1.get((ultimo - 1));
    }
    return _xblockexpression;
  }
  
  public boolean nuevoRechazo(final Rechazo nuevoRechazo) {
    List<Rechazo> _jugadoresRechazados = this.getJugadoresRechazados();
    return _jugadoresRechazados.add(nuevoRechazo);
  }
  
  public boolean aceptarPropuesta(final Propuesta propuesta) {
    boolean _xblockexpression = false;
    {
      jugadorBuilder nuevoJugador = new jugadorBuilder();
      nuevoJugador.conPropuesta(propuesta);
      nuevoJugador.suAdministrador(this);
      nuevoJugador.build();
      _xblockexpression = this.removerPropuesta(propuesta);
    }
    return _xblockexpression;
  }
  
  public boolean rechazarPropuesta(final Propuesta propuesta, final String razon) {
    try {
      boolean _xblockexpression = false;
      {
        boolean _existePropuesta = this.existePropuesta(propuesta);
        boolean _not = (!_existePropuesta);
        if (_not) {
          throw new NoExisteTalJugadorException("No existe propuesta para ese jugador");
        }
        final Rechazo rechazoNuevo = new Rechazo(razon, propuesta);
        this.nuevoRechazo(rechazoNuevo);
        _xblockexpression = this.removerPropuesta(propuesta);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void otogarNivelJuego(final Jugador jugador, final int nivelJuego) {
    jugador.tuNivelDeJuegoEs(nivelJuego);
  }
}
