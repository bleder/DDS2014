package partido.core.tiposDeInscripcion;

import exception.PartidoNoCumpleCondicionesExcepcion;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import partido.core.Jugador;
import partido.core.Partido;
import partido.core.tiposDeInscripcion.TipoInscripcion;

@SuppressWarnings("all")
public class Condicional implements TipoInscripcion {
  /**
   * @Property
   */
  private int id_tipo_incripcion;
  
  private Function1<Partido,Boolean> _condicion = new Function1<Partido,Boolean>() {
    public Boolean apply(final Partido partido) {
      return Boolean.valueOf(true);
    }
  };
  
  public Function1<Partido,Boolean> getCondicion() {
    return this._condicion;
  }
  
  public void setCondicion(final Function1<Partido,Boolean> condicion) {
    this._condicion = condicion;
  }
  
  public Condicional() {
  }
  
  public Condicional(final Function1<Partido,Boolean> miCondicion) {
    this.setCondicion(miCondicion);
  }
  
  public void inscribirA(final Jugador jugador, final Partido partido) {
    try {
      Function1<Partido,Boolean> _condicion = this.getCondicion();
      Boolean _apply = _condicion.apply(partido);
      boolean _not = (!(_apply).booleanValue());
      if (_not) {
        throw new PartidoNoCumpleCondicionesExcepcion("El partido no cumple la condicion impuesta por el jugador");
      }
      partido.agregarJugador(jugador, this);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public boolean tienePrioridad() {
    return false;
  }
  
  public boolean dejaAnotar() {
    return true;
  }
  
  public int setId_tipo_inscripcion(final int id_tipo_inscripcion) {
    return this.id_tipo_incripcion = id_tipo_inscripcion;
  }
  
  public int getId_tipo_inscripcion() {
    return this.id_tipo_incripcion;
  }
}
