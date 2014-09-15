package org.uqbar.examples.calculadora.wicket.xtend.domain;

import java.io.Serializable;
import org.uqbar.commons.model.UserException;

/**
 * Calculadora de division (permite tener más validaciones que la de suma/resta)
 * 
 * @author jfernandes
 */
@SuppressWarnings("all")
public class CalculadoraDivision implements Serializable {
  private double _dividendo;
  
  public double getDividendo() {
    return this._dividendo;
  }
  
  private double _divisor;
  
  public double getDivisor() {
    return this._divisor;
  }
  
  private double _resultado;
  
  public double getResultado() {
    return this._resultado;
  }
  
  public void setResultado(final double resultado) {
    this._resultado = resultado;
  }
  
  public void dividir() {
    double _divisor = this.getDivisor();
    this.validarDivisor(Double.valueOf(_divisor));
    double _dividendo = this.getDividendo();
    double _divisor_1 = this.getDivisor();
    double _divide = (_dividendo / _divisor_1);
    this.setResultado(_divide);
  }
  
  public void validarDivisor(final Double unDivisor) {
    boolean _equals = ((unDivisor).doubleValue() == 0);
    if (_equals) {
      throw new UserException("No se puede dividir por cero!");
    }
  }
  
  public void setDividendo(final double dividendo) {
    this.validarDividendo(Double.valueOf(dividendo));
    this._dividendo = dividendo;
  }
  
  public void validarDividendo(final Double dividendo) {
    int _minus = (-1);
    boolean _equals = ((dividendo).doubleValue() == _minus);
    if (_equals) {
      throw new UserException("No se puede usar el -1!");
    }
  }
  
  public void setDivisor(final double divisor) {
    this.validarDivisor(Double.valueOf(divisor));
    this._divisor = divisor;
  }
}
