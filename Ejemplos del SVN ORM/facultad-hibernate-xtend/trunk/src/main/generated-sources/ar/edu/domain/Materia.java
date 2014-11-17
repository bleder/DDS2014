package ar.edu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@SuppressWarnings("all")
public class Materia {
  @Id
  @GeneratedValue
  private Long _id;
  
  public Long getId() {
    return this._id;
  }
  
  public void setId(final Long id) {
    this._id = id;
  }
  
  @Column
  private String _nombre;
  
  public String getNombre() {
    return this._nombre;
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
  }
  
  @Column
  private int _anio;
  
  public int getAnio() {
    return this._anio;
  }
  
  public void setAnio(final int anio) {
    this._anio = anio;
  }
  
  public Materia() {
  }
  
  public Materia(final String nombre, final int anio) {
    this.setNombre(nombre);
    this.setAnio(anio);
  }
  
  public String toString() {
    String _nombre = this.getNombre();
    String _plus = (_nombre + " (");
    int _anio = this.getAnio();
    String _plus_1 = (_plus + Integer.valueOf(_anio));
    return (_plus_1 + ")");
  }
}
