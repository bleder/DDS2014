package uqbar.celulares.domain;

import java.math.BigDecimal;
import java.util.List;
import org.apache.commons.collections15.Predicate;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.uqbar.commons.model.CollectionBasedHome;
import org.uqbar.commons.utils.Observable;
import uqbar.celulares.domain.Modelo;

@Observable
@SuppressWarnings("all")
public class HomeModelos extends CollectionBasedHome<Modelo> {
  public HomeModelos() {
    this.init();
  }
  
  public void init() {
    this.create("NOKIA ASHA 501", 700f, true);
    this.create("LG OPTIMUS L5 II", 920f, false);
    this.create("LG OPTIMUS L3 II", 450f, true);
    this.create("NOKIA LUMIA 625", 350f, true);
    this.create("MOTOROLA RAZR V3", 350f, false);
  }
  
  public void create(final String descripcion, final float costo, final boolean requiereResumenCuenta) {
    Modelo modelo = new Modelo();
    modelo.setDescripcion(descripcion);
    BigDecimal _bigDecimal = new BigDecimal(costo);
    modelo.setCosto(_bigDecimal);
    modelo.setRequiereResumenCuenta(Boolean.valueOf(requiereResumenCuenta));
    this.create(modelo);
  }
  
  public List<Modelo> getModelos() {
    return this.allInstances();
  }
  
  public Modelo get(final String descripcion) {
    List<Modelo> _modelos = this.getModelos();
    final Function1<Modelo,Boolean> _function = new Function1<Modelo,Boolean>() {
      public Boolean apply(final Modelo modelo) {
        String _descripcion = modelo.getDescripcion();
        return Boolean.valueOf(_descripcion.equals(descripcion));
      }
    };
    return IterableExtensions.<Modelo>findFirst(_modelos, _function);
  }
  
  public Class<Modelo> getEntityType() {
    return Modelo.class;
  }
  
  public Modelo createExample() {
    return new Modelo();
  }
  
  public Predicate getCriterio(final Modelo example) {
    return null;
  }
}
