package uqbar.celulares.domain;

import com.google.common.base.Objects;
import org.uqbar.commons.model.Entity;
import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;
import uqbar.celulares.domain.Modelo;

@Observable
@SuppressWarnings("all")
public class Celular extends Entity {
  private final int MAX_NUMERO = 100000;
  
  private Integer _numero;
  
  public Integer getNumero() {
    return this._numero;
  }
  
  public void setNumero(final Integer numero) {
    this._numero = numero;
  }
  
  private String _nombre;
  
  public String getNombre() {
    return this._nombre;
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
  }
  
  private Modelo _modeloCelular;
  
  public Modelo getModeloCelular() {
    return this._modeloCelular;
  }
  
  private Boolean _recibeResumenCuenta = Boolean.valueOf(false);
  
  public Boolean getRecibeResumenCuenta() {
    return this._recibeResumenCuenta;
  }
  
  public void setRecibeResumenCuenta(final Boolean recibeResumenCuenta) {
    this._recibeResumenCuenta = recibeResumenCuenta;
  }
  
  public void setModeloCelular(final Modelo unModeloCelular) {
    this._modeloCelular = unModeloCelular;
    Boolean _requiereResumenCuenta = unModeloCelular.getRequiereResumenCuenta();
    this.setRecibeResumenCuenta(_requiereResumenCuenta);
    boolean _isHabilitaResumenCuenta = this.isHabilitaResumenCuenta();
    ObservableUtils.firePropertyChanged(this, "habilitaResumenCuenta", Boolean.valueOf(_isHabilitaResumenCuenta));
  }
  
  /**
   * Valida que el celular esté correctamente cargado
   */
  public void validar() {
    Integer _numero = this.getNumero();
    boolean _equals = Objects.equal(_numero, null);
    if (_equals) {
      throw new UserException("Debe ingresar número");
    }
    Integer _numero_1 = this.getNumero();
    int _intValue = _numero_1.intValue();
    boolean _lessEqualsThan = (_intValue <= this.MAX_NUMERO);
    if (_lessEqualsThan) {
      String _plus = ("El número debe ser mayor a " + Integer.valueOf(this.MAX_NUMERO));
      throw new UserException(_plus);
    }
    boolean _ingresoNombre = this.ingresoNombre();
    boolean _not = (!_ingresoNombre);
    if (_not) {
      throw new UserException("Debe ingresar nombre");
    }
    Modelo _modeloCelular = this.getModeloCelular();
    boolean _equals_1 = Objects.equal(_modeloCelular, null);
    if (_equals_1) {
      throw new UserException("Debe ingresar un modelo de celular");
    }
  }
  
  public boolean ingresoNombre() {
    boolean _and = false;
    String _nombre = this.getNombre();
    boolean _notEquals = (!Objects.equal(_nombre, null));
    if (!_notEquals) {
      _and = false;
    } else {
      String _nombre_1 = this.getNombre();
      String _trim = _nombre_1.trim();
      boolean _equals = _trim.equals("");
      boolean _not = (!_equals);
      _and = _not;
    }
    return _and;
  }
  
  public boolean isHabilitaResumenCuenta() {
    Modelo _modeloCelular = this.getModeloCelular();
    Boolean _requiereResumenCuenta = _modeloCelular.getRequiereResumenCuenta();
    return (!(_requiereResumenCuenta).booleanValue());
  }
  
  public String toString() {
    String _xblockexpression = null;
    {
      StringBuffer result = new StringBuffer();
      String _elvis = null;
      String _nombre = this.getNombre();
      if (_nombre != null) {
        _elvis = _nombre;
      } else {
        _elvis = "Celular sin nombre";
      }
      result.append(_elvis);
      Modelo _modeloCelular = this.getModeloCelular();
      boolean _notEquals = (!Objects.equal(_modeloCelular, null));
      if (_notEquals) {
        Modelo _modeloCelular_1 = this.getModeloCelular();
        String _plus = (" - " + _modeloCelular_1);
        result.append(_plus);
      }
      Integer _numero = this.getNumero();
      boolean _notEquals_1 = (!Objects.equal(_numero, null));
      if (_notEquals_1) {
        Integer _numero_1 = this.getNumero();
        String _plus_1 = (" - " + _numero_1);
        result.append(_plus_1);
      }
      String _xifexpression = null;
      Boolean _recibeResumenCuenta = this.getRecibeResumenCuenta();
      if ((_recibeResumenCuenta).booleanValue()) {
        _xifexpression = " - recibe resumen";
      } else {
        _xifexpression = " - no recibe resumen";
      }
      result.append(_xifexpression);
      _xblockexpression = result.toString();
    }
    return _xblockexpression;
  }
}
