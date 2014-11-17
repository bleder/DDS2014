package ar.edu.telefonia.domain;

import ar.edu.telefonia.domain.Abonado;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.uqbar.commons.utils.Observable;

@Entity
@Observable
@SuppressWarnings("all")
public class Llamada {
  private Long id;
  
  private Abonado origen;
  
  private Abonado destino;
  
  private Integer duracion;
  
  /**
   * INICIO EXTRAS MANUALES QUE NECESITA HIBERNATE
   */
  @Id
  @GeneratedValue
  public Long getId() {
    return this.id;
  }
  
  @ManyToOne
  public Abonado getOrigen() {
    return this.origen;
  }
  
  @ManyToOne
  public Abonado getDestino() {
    return this.destino;
  }
  
  @Column
  public Integer getDuracion() {
    return this.duracion;
  }
  
  public void setId(final Long unId) {
    this.id = unId;
  }
  
  public void setOrigen(final Abonado unOrigen) {
    this.origen = unOrigen;
  }
  
  public void setDestino(final Abonado unDestino) {
    this.destino = unDestino;
  }
  
  public void setDuracion(final Integer unaDuracion) {
    this.duracion = unaDuracion;
  }
  
  public Llamada() {
    this.origen = null;
    this.destino = null;
    Integer _integer = new Integer(0);
    this.duracion = _integer;
  }
  
  /**
   * FIN EXTRAS MANUALES QUE NECESITA HIBERNATE
   */
  public Llamada(final Abonado unOrigen, final Abonado unDestino, final Integer unaDuracion) {
    this.origen = unOrigen;
    this.destino = unDestino;
    this.duracion = unaDuracion;
  }
}
