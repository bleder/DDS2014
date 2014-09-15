package uqbar.celulares.domain;

import com.google.common.base.Objects;
import java.util.List;
import org.apache.commons.collections15.Predicate;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.uqbar.commons.model.CollectionBasedHome;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.ApplicationContext;
import org.uqbar.commons.utils.Observable;
import uqbar.celulares.domain.Celular;
import uqbar.celulares.domain.HomeModelos;
import uqbar.celulares.domain.Modelo;

@Observable
@SuppressWarnings("all")
public class HomeCelulares extends CollectionBasedHome<Celular> {
  public HomeCelulares() {
    this.init();
  }
  
  public void init() {
    Modelo _modelo = this.getModelo("NOKIA LUMIA 625");
    this.create("Laura Iturbe", Integer.valueOf(88022202), _modelo, Boolean.valueOf(false));
    Modelo _modelo_1 = this.getModelo("NOKIA ASHA 501");
    this.create("Julieta Passerini", Integer.valueOf(45636453), _modelo_1, Boolean.valueOf(false));
    Modelo _modelo_2 = this.getModelo("NOKIA ASHA 501");
    this.create("Debora Fortini", Integer.valueOf(45610892), _modelo_2, Boolean.valueOf(true));
    Modelo _modelo_3 = this.getModelo("NOKIA ASHA 501");
    this.create("Chiara Dodino", Integer.valueOf(68026976), _modelo_3, Boolean.valueOf(false));
    Modelo _modelo_4 = this.getModelo("LG OPTIMUS L3 II");
    this.create("Melina Dodino", Integer.valueOf(40989911), _modelo_4, Boolean.valueOf(true));
  }
  
  public Modelo getModelo(final String modeloDescripcion) {
    ApplicationContext _instance = ApplicationContext.getInstance();
    Object _singleton = _instance.<Object>getSingleton(Modelo.class);
    return ((HomeModelos) _singleton).get(modeloDescripcion);
  }
  
  public void create(final String pNombre, final Integer pNumero, final Modelo pModeloCelular, final Boolean pRecibeResumenCuenta) {
    Celular celular = new Celular();
    celular.setNombre(pNombre);
    celular.setNumero(pNumero);
    celular.setModeloCelular(pModeloCelular);
    celular.setRecibeResumenCuenta(pRecibeResumenCuenta);
    this.create(celular);
  }
  
  public void validateCreate(final Celular celular) {
    celular.validar();
    this.validarClientesDuplicados(celular);
  }
  
  public void validarClientesDuplicados(final Celular celular) {
    final Integer numero = celular.getNumero();
    List<Celular> _search = this.search(numero);
    boolean _isEmpty = _search.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      String _plus = ("Ya existe un celular con el número: " + numero);
      throw new UserException(_plus);
    }
  }
  
  public List<Celular> search(final Integer numero) {
    return this.search(numero, null);
  }
  
  /**
   * Busca los celulares que coincidan con los datos recibidos. Tanto número como nombre pueden ser nulos,
   * en ese caso no se filtra por ese atributo.
   * 
   * Soporta búsquedas por substring, por ejemplo el celular (12345, "Juan Gonzalez") será contemplado por
   * la búsqueda (23, "Gonza")
   */
  public List<Celular> search(final Integer numero, final String nombre) {
    List<Celular> _allInstances = this.allInstances();
    final Function1<Celular,Boolean> _function = new Function1<Celular,Boolean>() {
      public Boolean apply(final Celular celular) {
        boolean _and = false;
        Integer _numero = celular.getNumero();
        boolean _match = HomeCelulares.this.match(numero, _numero);
        if (!_match) {
          _and = false;
        } else {
          String _nombre = celular.getNombre();
          boolean _match_1 = HomeCelulares.this.match(nombre, _nombre);
          _and = _match_1;
        }
        return Boolean.valueOf(_and);
      }
    };
    Iterable<Celular> _filter = IterableExtensions.<Celular>filter(_allInstances, _function);
    return IterableExtensions.<Celular>toList(_filter);
  }
  
  public boolean match(final Object expectedValue, final Object realValue) {
    boolean _xblockexpression = false;
    {
      boolean _equals = Objects.equal(expectedValue, null);
      if (_equals) {
        return true;
      }
      boolean _equals_1 = Objects.equal(realValue, null);
      if (_equals_1) {
        return false;
      }
      String _string = realValue.toString();
      String _lowerCase = _string.toLowerCase();
      String _string_1 = expectedValue.toString();
      String _lowerCase_1 = _string_1.toLowerCase();
      _xblockexpression = _lowerCase.contains(_lowerCase_1);
    }
    return _xblockexpression;
  }
  
  public Class<Celular> getEntityType() {
    return Celular.class;
  }
  
  public Celular createExample() {
    return new Celular();
  }
  
  public Predicate getCriterio(final Celular example) {
    return null;
  }
  
  /**
   * Para el proyecto web - se mantiene la busqueda por Identificador
   */
  public Celular searchById(final int id) {
    List<Celular> _allInstances = this.allInstances();
    final Function1<Celular,Boolean> _function = new Function1<Celular,Boolean>() {
      public Boolean apply(final Celular celular) {
        Integer _id = celular.getId();
        return Boolean.valueOf(_id.equals(Integer.valueOf(id)));
      }
    };
    return IterableExtensions.<Celular>findFirst(_allInstances, _function);
  }
}
