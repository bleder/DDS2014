package ar.edu.repo;

import ar.edu.domain.Materia;
import ar.edu.domain.Profesor;
import ar.edu.repo.RepoHibernateMaterias;
import ar.edu.repo.RepoHibernateProfesores;
import java.util.List;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.hibernate.LazyInitializationException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class TestProfesores {
  private Profesor spigariol;
  
  private Profesor passerini;
  
  private Profesor dodino;
  
  private Materia paradigmas;
  
  private Materia algoritmos;
  
  private Materia disenio;
  
  private RepoHibernateMaterias repoMaterias;
  
  private RepoHibernateProfesores repoProfes;
  
  @Before
  public void init() {
    Materia _materia = new Materia("Algoritmos y Estructura de Datos", 1);
    this.algoritmos = _materia;
    Materia _materia_1 = new Materia("Paradigmas de Programacion", 2);
    this.paradigmas = _materia_1;
    Materia _materia_2 = new Materia("Diseño de Sistemas", 3);
    this.disenio = _materia_2;
    RepoHibernateMaterias _repoHibernateMaterias = new RepoHibernateMaterias();
    this.repoMaterias = _repoHibernateMaterias;
    this.repoMaterias.add(this.algoritmos);
    this.repoMaterias.add(this.paradigmas);
    this.repoMaterias.add(this.disenio);
    Profesor _profesor = new Profesor("Lucas Spigariol");
    this.spigariol = _profesor;
    this.spigariol.agregarMateria(this.algoritmos);
    this.spigariol.agregarMateria(this.paradigmas);
    Profesor _profesor_1 = new Profesor("Nicolás Passerini");
    this.passerini = _profesor_1;
    this.passerini.agregarMateria(this.paradigmas);
    this.passerini.agregarMateria(this.disenio);
    Profesor _profesor_2 = new Profesor("Fernando Dodino");
    this.dodino = _profesor_2;
    this.dodino.agregarMateria(this.disenio);
    RepoHibernateProfesores _repoHibernateProfesores = new RepoHibernateProfesores();
    this.repoProfes = _repoHibernateProfesores;
    this.repoProfes.add(this.spigariol);
    this.repoProfes.add(this.passerini);
    this.repoProfes.add(this.dodino);
  }
  
  @After
  public void end() {
    this.repoProfes.delete(this.spigariol);
    this.repoProfes.delete(this.passerini);
    this.repoProfes.delete(this.dodino);
    this.repoMaterias.deleteAll();
  }
  
  @Test
  public void testSpigariolDaParadigmas() {
    final List<Profesor> profesQueDanParadigmas = this.repoProfes.getProfesores(this.paradigmas);
    InputOutput.<String>println(("profesQueDanParadigmas: " + profesQueDanParadigmas));
    InputOutput.<String>println(("spigariol: " + this.spigariol));
    boolean _contains = profesQueDanParadigmas.contains(this.spigariol);
    Assert.assertTrue(_contains);
  }
  
  @Test(expected = LazyInitializationException.class)
  public void testNoPuedoSaberQueMateriasDaUnProfesorHaciendoGetPorId() {
    Long _id = this.spigariol.getId();
    final Profesor spigariolBase = this.repoProfes.get(_id);
    Set<Materia> _materias = spigariolBase.getMaterias();
    String _plus = ("Materias de Spigariol: " + _materias);
    InputOutput.<String>println(_plus);
  }
  
  @Test
  public void testSiPuedoSaberQueMateriasDaUnProfesorHaciendoGetPorId() {
    Long _id = this.spigariol.getId();
    final Profesor spigariolBase = this.repoProfes.get(_id, true);
    Set<Materia> _materias = spigariolBase.getMaterias();
    String _plus = ("Materias de Spigariol: " + _materias);
    InputOutput.<String>println(_plus);
  }
}
