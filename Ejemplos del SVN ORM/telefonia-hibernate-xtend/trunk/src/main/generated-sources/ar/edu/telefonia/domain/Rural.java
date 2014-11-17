package ar.edu.telefonia.domain;

import ar.edu.telefonia.domain.Abonado;
import ar.edu.telefonia.domain.Llamada;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("RU")
@SuppressWarnings("all")
public class Rural extends Abonado {
  private Integer cantidadHectareas;
  
  /**
   * INICIO EXTRAS MANUALES QUE NECESITA HIBERNATE
   */
  @Column
  public Integer getCantidadHectareas() {
    return this.cantidadHectareas;
  }
  
  public void setCantidadHectareas(final Integer unaCantidadHectareas) {
    this.cantidadHectareas = unaCantidadHectareas;
  }
  
  /**
   * Constructor que necesita Hibernate
   */
  public Rural() {
  }
  
  /**
   * FIN EXTRAS MANUALES QUE NECESITA HIBERNATE
   */
  public Rural(final Integer unaCantidadHectareas) {
    this.cantidadHectareas = unaCantidadHectareas;
  }
  
  public float costo(final Llamada llamada) {
    Integer _duracion = llamada.getDuracion();
    Integer _integer = new Integer(5);
    Integer _max = this.max(_duracion, _integer);
    return (3 * (_max).intValue());
  }
}
