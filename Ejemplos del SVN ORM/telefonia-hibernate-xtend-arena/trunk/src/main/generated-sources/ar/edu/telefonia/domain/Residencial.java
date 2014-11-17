package ar.edu.telefonia.domain;

import ar.edu.telefonia.domain.Abonado;
import ar.edu.telefonia.domain.Llamada;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("RS")
@SuppressWarnings("all")
public class Residencial extends Abonado {
  public float costo(final Llamada llamada) {
    Integer _duracion = llamada.getDuracion();
    return (2 * (_duracion).intValue());
  }
  
  @Transient
  public String getDatosEspecificos() {
    return "Residencial";
  }
}
