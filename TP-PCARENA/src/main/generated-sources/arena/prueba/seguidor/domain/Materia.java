package arena.prueba.seguidor.domain;

import org.uqbar.commons.model.Entity;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class Materia extends Entity {
  private String _nombre;
  
  public String getNombre() {
    return this._nombre;
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
  }
  
  private int _anio;
  
  public int getAnio() {
    return this._anio;
  }
  
  public void setAnio(final int anio) {
    this._anio = anio;
  }
  
  private Boolean _finalAprobado = Boolean.valueOf(false);
  
  public Boolean getFinalAprobado() {
    return this._finalAprobado;
  }
  
  public void setFinalAprobado(final Boolean finalAprobado) {
    this._finalAprobado = finalAprobado;
  }
  
  private String _profe;
  
  public String getProfe() {
    return this._profe;
  }
  
  public void setProfe(final String profe) {
    this._profe = profe;
  }
  
  private Object _ubicacion;
  
  public Object getUbicacion() {
    return this._ubicacion;
  }
  
  public void setUbicacion(final Object ubicacion) {
    this._ubicacion = ubicacion;
  }
}
