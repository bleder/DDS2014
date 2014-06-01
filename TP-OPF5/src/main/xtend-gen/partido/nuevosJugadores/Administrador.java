package partido.nuevosJugadores;

import com.google.common.base.Objects;
import exception.NoExisteTalJugadorException;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import partido.core.Jugador;
import partido.nuevosJugadores.Propuesta;
import partido.nuevosJugadores.Rechazo;

@SuppressWarnings("all")
public class Administrador {
  private String _mail;
  
  public String getMail() {
    return this._mail;
  }
  
  public void setMail(final String mail) {
    this._mail = mail;
  }
  
  private List<Propuesta> posiblesJugadores;
  
  public Administrador(final String adminMail) {
    this.setMail(adminMail);
  }
  
  public boolean existePropuesta(final String mail) {
    final Function1<Propuesta,Boolean> _function = new Function1<Propuesta,Boolean>() {
      public Boolean apply(final Propuesta propuesta) {
        String _mail = propuesta.getMail();
        return Boolean.valueOf(Objects.equal(_mail, mail));
      }
    };
    return IterableExtensions.<Propuesta>exists(this.posiblesJugadores, _function);
  }
  
  public Propuesta getPropuesta(final String mail) {
    final Function1<Propuesta,Boolean> _function = new Function1<Propuesta,Boolean>() {
      public Boolean apply(final Propuesta propuesta) {
        String _mail = propuesta.getMail();
        return Boolean.valueOf(Objects.equal(_mail, mail));
      }
    };
    return IterableExtensions.<Propuesta>findFirst(this.posiblesJugadores, _function);
  }
  
  public boolean removerPropuesta(final String mail) {
    Propuesta _propuesta = this.getPropuesta(mail);
    return this.posiblesJugadores.remove(_propuesta);
  }
  
  public boolean nuevaPropuesta(final Propuesta nuevaPropuesta) {
    return this.posiblesJugadores.add(nuevaPropuesta);
  }
  
  public Jugador aceptarPropuesta(final String mail, final String nombre) {
    try {
      Jugador _xblockexpression = null;
      {
        boolean _existePropuesta = this.existePropuesta(mail);
        boolean _not = (!_existePropuesta);
        if (_not) {
          throw new NoExisteTalJugadorException("No existe propuesta para ese jugador");
        }
        Jugador jugador = new Jugador(nombre, mail);
        Propuesta _propuesta = this.getPropuesta(mail);
        Jugador _amigo = _propuesta.getAmigo();
        String _mail = _amigo.getMail();
        jugador.agregarAmigo(_mail);
        this.removerPropuesta(mail);
        _xblockexpression = jugador;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Rechazo rechazarPropuesta(final String mail, final String razon) {
    try {
      Rechazo _xblockexpression = null;
      {
        boolean _existePropuesta = this.existePropuesta(mail);
        boolean _not = (!_existePropuesta);
        if (_not) {
          throw new NoExisteTalJugadorException("No existe propuesta para ese jugador");
        }
        this.removerPropuesta(mail);
        _xblockexpression = new Rechazo(mail, razon);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
