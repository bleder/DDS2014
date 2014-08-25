package arena.prueba.seguidor.domain;

import java.util.Date;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class Materia {
  private Date _fecha;
  
  public Date getFecha() {
    return this._fecha;
  }
  
  public void setFecha(final Date fecha) {
    this._fecha = fecha;
  }
  
  private String _descripcion;
  
  public String getDescripcion() {
    return this._descripcion;
  }
  
  public void setDescripcion(final String descripcion) {
    this._descripcion = descripcion;
  }
  
  private Boolean _aprobada = Boolean.valueOf(false);
  
  public Boolean getAprobada() {
    return this._aprobada;
  }
  
  public void setAprobada(final Boolean aprobada) {
    this._aprobada = aprobada;
  }
}
