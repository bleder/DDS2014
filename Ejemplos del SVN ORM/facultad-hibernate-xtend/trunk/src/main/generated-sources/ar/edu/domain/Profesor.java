package ar.edu.domain;

import ar.edu.domain.Materia;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
@SuppressWarnings("all")
public class Profesor implements Serializable {
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
  private String _nombreCompleto;
  
  public String getNombreCompleto() {
    return this._nombreCompleto;
  }
  
  public void setNombreCompleto(final String nombreCompleto) {
    this._nombreCompleto = nombreCompleto;
  }
  
  @ManyToMany(fetch = FetchType.LAZY)
  private Set<Materia> _materias;
  
  public Set<Materia> getMaterias() {
    return this._materias;
  }
  
  public void setMaterias(final Set<Materia> materias) {
    this._materias = materias;
  }
  
  public Profesor() {
  }
  
  public Profesor(final String nombreCompleto) {
    HashSet<Materia> _hashSet = new HashSet<Materia>();
    this.setMaterias(_hashSet);
    this.setNombreCompleto(nombreCompleto);
  }
  
  public void agregarMateria(final Materia materia) {
    Set<Materia> _materias = this.getMaterias();
    _materias.add(materia);
  }
  
  public boolean dicta(final Materia materia) {
    Set<Materia> _materias = this.getMaterias();
    return _materias.contains(materia);
  }
  
  public String toString() {
    String _nombreCompleto = this.getNombreCompleto();
    String _plus = (_nombreCompleto + " (");
    Long _id = this.getId();
    String _plus_1 = (_plus + _id);
    return (_plus_1 + ")");
  }
  
  public void clearMaterias() {
    Set<Materia> _materias = this.getMaterias();
    _materias.clear();
  }
  
  public boolean equals(final Object otroProfesor) {
    Long _id = this.getId();
    Long _id_1 = ((Profesor) otroProfesor).getId();
    return _id.equals(_id_1);
  }
  
  public int hashCode() {
    Long _id = this.getId();
    return _id.hashCode();
  }
}
