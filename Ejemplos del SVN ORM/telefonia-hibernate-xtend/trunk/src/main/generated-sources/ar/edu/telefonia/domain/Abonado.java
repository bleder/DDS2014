package ar.edu.telefonia.domain;

import ar.edu.telefonia.domain.Factura;
import ar.edu.telefonia.domain.Llamada;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO_ABONADO", discriminatorType = DiscriminatorType.STRING)
@SuppressWarnings("all")
public abstract class Abonado {
  private Long id;
  
  @Column
  private String _nombre;
  
  public String getNombre() {
    return this._nombre;
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
  }
  
  @Column
  private String _numero;
  
  public String getNumero() {
    return this._numero;
  }
  
  public void setNumero(final String numero) {
    this._numero = numero;
  }
  
  private List<Factura> facturas;
  
  private List<Llamada> llamadas;
  
  /**
   * Podríamos utilizar annotations de Hibernate a nivel
   * 1) property: par getter/setter como en este caso
   * 2) field - o variable
   * 
   * El problema es que al anotar como field recibimos un error:
   * Caused by: java.sql.BatchUpdateException: Field 'Abonado_id' doesn't have a default value
   * 
   * La explicación más razonable está aquí:
   * http://javaprogrammingtips4u.blogspot.com.ar/2010/04/field-versus-property-access-in.html
   * 
   * "As per the @AccessType implementation of hibernate, if we intend to get the identifier of an
   *  associated object in hibernate, if we use property level access, then hibernate understands that
   *  there is getId() method in the corresponding POJO and hence gets the id without initializing the
   *  proxy. However, this does not work if we use filed level access. If we intend to get the id of
   *  the associated object, since there is property level access defined, hibernate does not know
   *  about the accessor methods in this domain object and hence tries to initialize the proxy to get
   *  the id of the associated object! As a result, Hibernate team strongly suggests the use of property
   *  access if we do not want the proxy initialization to happen since that might result in lazy
   *  initialization exception if done out side the session.
   * 
   * "Adding fuel to this fire is the bug (*) reported in hibernate. While this points to the proxy
   *  initialization issue on calling getId() of an embedded object within hibernate, it is very clear that
   *  Property level access is being discouraged by Hibernate (though Spring's dictum is to opt for field
   *  level access only as in this link.
   *  (*) https://hibernate.atlassian.net/browse/HHH-3718
   * 
   * Best Practices
   * 1. There is not much of difference between the field and property level access with respect to performance.
   * 2. Field level access would be preferred if the code avoids hibernate proxy pitfalls!If there is a need
   *    for property access later, this can always be supported by adding the necessary accessors!
   * 3. Field level access proves to be good if you really want the annotations closer to the code.
   *    This not only gives a fare idea of the property details but also avoids unnecessary accessors
   *    that might prove to be great evil. Additionally, having accessors is emphatically not a good OO design strategy!
   * 4. If you are using field level access, remember that Hibernate would initialize the proxy on getting the id of
   *    an associated object at least until the bug gets resolved.
   * 5. Property level access can be implemented as long as you do not have business logic or validations
   *    within your domain objects since one such scenario can prove to be very dangerous!
   *    The positive aspect about this type of access is that Hibernate does not initialize the proxy
   *    in case of getting the identifier of the associated POJO.
   *  Overall, the usage of field and property level access depends much on the requirement as the first
   *  consideration and then the coding style!
   */
  @Id
  @GeneratedValue
  public Long getId() {
    return this.id;
  }
  
  public void setId(final Long unId) {
    this.id = unId;
  }
  
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  public List<Factura> getFacturas() {
    return this.facturas;
  }
  
  public void setFacturas(final List<Factura> unasFacturas) {
    this.facturas = unasFacturas;
  }
  
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  public List<Llamada> getLlamadas() {
    return this.llamadas;
  }
  
  public void setLlamadas(final List<Llamada> unasLlamadas) {
    this.llamadas = unasLlamadas;
  }
  
  /**
   * Constructor que necesita Hibernate
   */
  public Abonado() {
    ArrayList<Factura> _arrayList = new ArrayList<Factura>();
    this.facturas = _arrayList;
    ArrayList<Llamada> _arrayList_1 = new ArrayList<Llamada>();
    this.llamadas = _arrayList_1;
  }
  
  /**
   * FIN EXTRAS MANUALES QUE NECESITA HIBERNATE
   */
  public abstract float costo(final Llamada llamada);
  
  public boolean esMoroso() {
    Double _deuda = this.deuda();
    return ((_deuda).doubleValue() > 0);
  }
  
  public Double deuda() {
    final Function2<Double,Factura,Double> _function = new Function2<Double,Factura,Double>() {
      public Double apply(final Double acum, final Factura factura) {
        BigDecimal _saldo = factura.saldo();
        float _floatValue = _saldo.floatValue();
        return Double.valueOf(((acum).doubleValue() + _floatValue));
      }
    };
    return IterableExtensions.<Factura, Double>fold(this.facturas, Double.valueOf(0.0), _function);
  }
  
  public boolean agregarLlamada(final Llamada llamada) {
    return this.llamadas.add(llamada);
  }
  
  public boolean agregarFactura(final Factura factura) {
    return this.facturas.add(factura);
  }
  
  /**
   * EXTENSION METHODS
   */
  public Integer max(final Integer integer, final Integer integer2) {
    Integer _xifexpression = null;
    boolean _greaterThan = (integer.compareTo(integer2) > 0);
    if (_greaterThan) {
      _xifexpression = integer;
    } else {
      _xifexpression = integer2;
    }
    return _xifexpression;
  }
  
  public Integer min(final Integer integer, final Integer integer2) {
    return this.max(integer2, integer);
  }
}
