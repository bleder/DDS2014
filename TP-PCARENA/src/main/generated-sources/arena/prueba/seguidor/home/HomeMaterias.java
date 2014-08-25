package arena.prueba.seguidor.home;

import arena.prueba.seguidor.domain.Materia;
import java.util.List;
import org.apache.commons.collections15.Predicate;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.uqbar.commons.model.CollectionBasedHome;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class HomeMaterias extends CollectionBasedHome<Materia> {
  public HomeMaterias() {
    this.init();
  }
  
  public void init() {
    this.create("Mate discreta", 2005, true, "Alejandra Isola");
    this.create("Paradigmas", 2009, true, "Spagariol");
    this.create("Algebra", 2009, true, "Monica perez");
    this.create("Sistemas operativos", 2009, true, "Scarfiello");
  }
  
  public void create(final String nombre, final int anio, final boolean finalAprobado, final String profe) {
    Materia materia = new Materia();
    materia.setNombre(nombre);
    materia.setAnio(anio);
    materia.setFinalAprobado(Boolean.valueOf(finalAprobado));
    materia.setProfe(profe);
    this.create(materia);
  }
  
  public List<Materia> getMaterias() {
    return this.allInstances();
  }
  
  public List<Materia> iniciar() {
    List<Materia> _allInstances = this.allInstances();
    return IterableExtensions.<Materia>toList(_allInstances);
  }
  
  public Materia get(final String nom) {
    List<Materia> _materias = this.getMaterias();
    final Function1<Materia,Boolean> _function = new Function1<Materia,Boolean>() {
      public Boolean apply(final Materia materia) {
        String _nombre = materia.getNombre();
        return Boolean.valueOf(_nombre.equals(nom));
      }
    };
    return IterableExtensions.<Materia>findFirst(_materias, _function);
  }
  
  public Class<Materia> getEntityType() {
    return Materia.class;
  }
  
  public Materia createExample() {
    return new Materia();
  }
  
  public Predicate<Materia> getCriterio(final Materia example) {
    return null;
  }
}
