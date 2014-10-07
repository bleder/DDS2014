package partido.core;

@SuppressWarnings("all")
public class Infraccion {
  /* @Property
   */private /* String */Object fecha;
  
  /* @Property
   */private /* String */Object motivo;
  
  public Infraccion(final /* String */Object motivoInf) {
    this.motivo = motivoInf;
  }
  
  public boolean vencer() {
    return false;
  }
}
