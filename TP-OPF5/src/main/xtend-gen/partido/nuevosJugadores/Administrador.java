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
  
  public boolean existePropuesta(final String mail) {
    List<Propuesta> _posiblesJugadores = this.getPosiblesJugadores();
    final Function1<Propuesta,Boolean> _function = new Function1<Propuesta,Boolean>() {
      public Boolean apply(final Propuesta propuesta) {
        String _mail = propuesta.getMail();
        return Boolean.valueOf(Objects.equal(_mail, mail));
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
  
  public boolean removerPropuesta(final String mail) {
    List<Propuesta> _posiblesJugadores = this.getPosiblesJugadores();
    Propuesta _propuesta = this.getPropuesta(mail);
    return _posiblesJugadores.remove(_propuesta);
  }
  
  public boolean nuevaPropuesta(final Propuesta nuevaPropuesta) {
    List<Propuesta> _posiblesJugadores = this.getPosiblesJugadores();
    return _posiblesJugadores.add(nuevaPropuesta);
  }
  
  public boolean nuevoRechazo(final Rechazo nuevoRechazo) {
    List<Rechazo> _jugadoresRechazados = this.getJugadoresRechazados();
    return _jugadoresRechazados.add(nuevoRechazo);
  }
  
  public Jugador aceptarPropuesta(final String mail) {
    try {
      Jugador _xblockexpression = null;
      {
        boolean _existePropuesta = this.existePropuesta(mail);
        boolean _not = (!_existePropuesta);
        if (_not) {
          throw new NoExisteTalJugadorException("No existe propuesta para ese jugador");
        }
        Propuesta propuesta = this.getPropuesta(mail);
        String _nombre = propuesta.getNombre();
        Jugador jugador = new Jugador(_nombre, mail);
        Jugador _amigo = propuesta.getAmigo();
        String _mail = _amigo.getMail();
        jugador.agregarAmigo(_mail);
        this.removerPropuesta(mail);
        List<String> _mailsAmigos = propuesta.getMailsAmigos();
        for (final String mails : _mailsAmigos) {
          jugador.agregarAmigo(mails);
        }
        _xblockexpression = jugador;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public boolean rechazarPropuesta(final String mail, final String razon) {
    try {
      boolean _xblockexpression = false;
      {
        boolean _existePropuesta = this.existePropuesta(mail);
        boolean _not = (!_existePropuesta);
        if (_not) {
          throw new NoExisteTalJugadorException("No existe propuesta para ese jugador");
        }
        this.removerPropuesta(mail);
        Rechazo _rechazo = new Rechazo(mail, razon);
        _xblockexpression = this.nuevoRechazo(_rechazo);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
