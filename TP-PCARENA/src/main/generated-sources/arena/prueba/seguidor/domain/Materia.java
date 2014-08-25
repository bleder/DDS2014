package arena.prueba.seguidor.domain;

import java.math.BigDecimal;
import java.util.Date;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class Materia {
  private String _nombre;
  
  public String getNombre() {
    return this._nombre;
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
  }
  
  private BigDecimal _anio;
  
  public BigDecimal getAnio() {
    return this._anio;
  }
  
  public void setAnio(final BigDecimal anio) {
    this._anio = anio;
  }
  
  private Boolean _finalAprobado = Boolean.valueOf(false);
  
  public Boolean getFinalAprobado() {
    return this._finalAprobado;
  }
  
  public void setFinalAprobado(final Boolean finalAprobado) {
    this._finalAprobado = finalAprobado;
  }
  
  private Date _fecha;
  
  public Date getFecha() {
    return this._fecha;
  }
  
  public void setFecha(final Date fecha) {
    this._fecha = fecha;
  }
  
  private String _profesor;
  
  public String getProfesor() {
    return this._profesor;
  }
  
  public void setProfesor(final String profesor) {
    this._profesor = profesor;
  }
  
  private Object _ubicacion;
  
  public Object getUbicacion() {
    return this._ubicacion;
  }
  
  public void setUbicacion(final Object ubicacion) {
    this._ubicacion = ubicacion;
  }
}
