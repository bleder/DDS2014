package utn.edu.dds.TP_OPF5_VIEW;

import divisionEquipo.Divisor;
import org.apache.commons.collections15.Predicate;
import org.uqbar.commons.model.CollectionBasedHome;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class HomeCriteriosSeleccion extends CollectionBasedHome<Divisor> {
  public HomeCriteriosSeleccion() {
    this.init();
  }
  
  public Object init() {
    return null;
  }
  
  protected Predicate getCriterio(final Divisor arg0) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public Divisor createExample() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public Class<Divisor> getEntityType() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
}
