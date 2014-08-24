package arena.prueba;

import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class Conversor {
  private double _millas;
  
  public double getMillas() {
    return this._millas;
  }
  
  public void setMillas(final double millas) {
    this._millas = millas;
  }
  
  private double _kilometros;
  
  public double getKilometros() {
    return this._kilometros;
  }
  
  public void setKilometros(final double kilometros) {
    this._kilometros = kilometros;
  }
  
  public void convertir() {
    double _millas = this.getMillas();
    double _multiply = (_millas * 1.60934);
    this.setKilometros(_multiply);
  }
}
