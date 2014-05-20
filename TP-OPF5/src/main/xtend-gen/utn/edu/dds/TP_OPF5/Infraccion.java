package utn.edu.dds.TP_OPF5;

@SuppressWarnings("all")
public class Infraccion {
  private String _fecha;
  
  public String getFecha() {
    return this._fecha;
  }
  
  public void setFecha(final String fecha) {
    this._fecha = fecha;
  }
  
  private String _motivo;
  
  public String getMotivo() {
    return this._motivo;
  }
  
  public void setMotivo(final String motivo) {
    this._motivo = motivo;
  }
  
  public Infraccion(final String motivoInf) {
    this.setMotivo(motivoInf);
  }
  
  public boolean vencer() {
    return false;
  }
}
