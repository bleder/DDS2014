package partido.calificaciones;

import com.google.common.base.Objects;
import exception.JugadorNoPerteneceAlPartido;
import exception.MeCalificoAMiMismo;
import exception.NotaIncorrecta;
import exception.YaLoCalifique;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import partido.calificaciones.Calificacion;
import partido.core.Jugador;
import partido.core.Partido;

@SuppressWarnings("all")
public class ClasificacionBuilder {
  private Partido _partido;
  
  public Partido getPartido() {
    return this._partido;
  }
  
  public void setPartido(final Partido partido) {
    this._partido = partido;
  }
  
  private int _nota;
  
  public int getNota() {
    return this._nota;
  }
  
  public void setNota(final int nota) {
    this._nota = nota;
  }
  
  private String _critica;
  
  public String getCritica() {
    return this._critica;
  }
  
  public void setCritica(final String critica) {
    this._critica = critica;
  }
  
  private Jugador _calificador;
  
  public Jugador getCalificador() {
    return this._calificador;
  }
  
  public void setCalificador(final Jugador calificador) {
    this._calificador = calificador;
  }
  
  private Jugador _calificado;
  
  public Jugador getCalificado() {
    return this._calificado;
  }
  
  public void setCalificado(final Jugador calificado) {
    this._calificado = calificado;
  }
  
  public Calificacion build() {
    try {
      Calificacion _xblockexpression = null;
      {
        Partido _partido = this.getPartido();
        Jugador _calificado = this.getCalificado();
        boolean _estaInscripto = _partido.estaInscripto(_calificado);
        boolean _not = (!_estaInscripto);
        if (_not) {
          throw new JugadorNoPerteneceAlPartido("No esta ese jugador en el partido");
        }
        Jugador _calificado_1 = this.getCalificado();
        List<Calificacion> _calificaciones = _calificado_1.getCalificaciones();
        final Function1<Calificacion,Boolean> _function = new Function1<Calificacion,Boolean>() {
          public Boolean apply(final Calificacion calificacion) {
            boolean _and = false;
            Jugador _jugadorQueCalifico = calificacion.getJugadorQueCalifico();
            Jugador _calificador = ClasificacionBuilder.this.getCalificador();
            boolean _equals = Objects.equal(_jugadorQueCalifico, _calificador);
            if (!_equals) {
              _and = false;
            } else {
              Partido _partido = calificacion.getPartido();
              Partido _partido_1 = ClasificacionBuilder.this.getPartido();
              boolean _equals_1 = Objects.equal(_partido, _partido_1);
              _and = _equals_1;
            }
            return Boolean.valueOf(_and);
          }
        };
        boolean _exists = IterableExtensions.<Calificacion>exists(_calificaciones, _function);
        if (_exists) {
          throw new YaLoCalifique("Ya califique a este jugador");
        }
        boolean _or = false;
        int _nota = this.getNota();
        boolean _lessThan = (_nota < 1);
        if (_lessThan) {
          _or = true;
        } else {
          int _nota_1 = this.getNota();
          boolean _greaterThan = (_nota_1 > 10);
          _or = _greaterThan;
        }
        if (_or) {
          throw new NotaIncorrecta("La nota ingresada no es correcta");
        }
        Jugador _calificado_2 = this.getCalificado();
        Jugador _calificador = this.getCalificador();
        boolean _equals = Objects.equal(_calificado_2, _calificador);
        if (_equals) {
          throw new MeCalificoAMiMismo("No puedo calificarme a mi mismo");
        }
        String _critica = this.getCritica();
        Jugador _calificador_1 = this.getCalificador();
        Partido _partido_1 = this.getPartido();
        int _nota_2 = this.getNota();
        _xblockexpression = new Calificacion(_critica, _calificador_1, _partido_1, _nota_2);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void conPartido(final Partido partido) {
    this.setPartido(partido);
  }
  
  public void conNota(final int nota) {
    this.setNota(nota);
  }
  
  public void conCritica(final String critica) {
    this.setCritica(critica);
  }
  
  public void conCalificador(final Jugador calificador) {
    this.setCalificador(calificador);
  }
  
  public void conCalificado(final Jugador calificado) {
    this.setCalificado(calificado);
  }
}
