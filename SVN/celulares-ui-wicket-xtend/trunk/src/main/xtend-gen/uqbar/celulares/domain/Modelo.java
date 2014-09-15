package uqbar.celulares.domain;

import java.math.BigDecimal;
import org.uqbar.commons.model.Entity;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class Modelo extends Entity {
  private String _descripcion;
  
  public String getDescripcion() {
    return this._descripcion;
  }
  
  public void setDescripcion(final String descripcion) {
    this._descripcion = descripcion;
  }
  
  private BigDecimal _costo;
  
  public BigDecimal getCosto() {
    return this._costo;
  }
  
  public void setCosto(final BigDecimal costo) {
    this._costo = costo;
  }
  
  private Boolean _requiereResumenCuenta;
  
  public Boolean getRequiereResumenCuenta() {
    return this._requiereResumenCuenta;
  }
  
  public void setRequiereResumenCuenta(final Boolean requiereResumenCuenta) {
    this._requiereResumenCuenta = requiereResumenCuenta;
  }
  
  public String getDescripcionEntera() {
    String _descripcion = this.getDescripcion();
    String _concat = _descripcion.concat(" ($ ");
    BigDecimal _costo = this.getCosto();
    String _string = _costo.toString();
    String _concat_1 = _concat.concat(_string);
    return _concat_1.concat(")");
  }
  
  public String toString() {
    return this.getDescripcionEntera();
  }
}
