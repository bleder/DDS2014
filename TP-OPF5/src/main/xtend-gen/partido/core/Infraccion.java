package partido.core;

import java.io.Serializable;
import org.uqbar.commons.model.Entity;

@SuppressWarnings("all")
public class Infraccion extends Entity implements Serializable {
  /**
   * @Property
   */
  private int id_infraccion;
  
  /**
   * @Property
   */
  private String fecha;
  
  /**
   * @Property
   */
  private String motivo;
  
  public Infraccion() {
  }
  
  public Infraccion(final String motivoInf) {
    this.motivo = motivoInf;
  }
  
  public boolean vencer() {
    return false;
  }
  
  public int setId_infraccion(final int id_infraccion) {
    return this.id_infraccion = id_infraccion;
  }
  
  public int getId_infraccion() {
    return this.id_infraccion;
  }
  
  public String setFecha(final String fecha) {
    return this.fecha = fecha;
  }
  
  public String getFecha() {
    return this.fecha;
  }
  
  public String setMotivo(final String motivo) {
    return this.motivo = motivo;
  }
  
  public String getMotivo() {
    return this.motivo;
  }
}
