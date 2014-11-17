package ar.edu.telefonia.domain;

import ar.edu.telefonia.domain.Abonado;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
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
  
  public Long setId(final Long unId) {
    return this.id = unId;
  }
  
  public Abonado setOrigen(final Abonado unOrigen) {
    return this.origen = unOrigen;
  }
  
  public Abonado setDestino(final Abonado unDestino) {
    return this.destino = unDestino;
  }
  
  public Integer setDuracion(final Integer unaDuracion) {
    return this.duracion = unaDuracion;
  }
  
  public Llamada() {
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
