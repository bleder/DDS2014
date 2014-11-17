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
import javax.persistence.Transient;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.uqbar.commons.utils.Observable;

@Observable
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO_ABONADO", discriminatorType = DiscriminatorType.STRING)
@SuppressWarnings("all")
public abstract class Abonado {
  private Long id;
  
  private String nombre;
  
  private String numero;
  
  private List<Factura> facturas;
  
  private List<Llamada> llamadas;
  
  /**
   * INICIO EXTRAS MANUALES QUE NECESITA HIBERNATE
   */
  @Id
  @GeneratedValue
  public Long getId() {
    return this.id;
  }
  
  public void setId(final Long unId) {
    this.id = unId;
  }
  
  @Column
  public String getNombre() {
    return this.nombre;
  }
  
  public void setNombre(final String unNombre) {
    this.nombre = unNombre;
  }
  
  @Column
  public String getNumero() {
    return this.numero;
  }
  
  public void setNumero(final String unNumero) {
    this.numero = unNumero;
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
  
  @Transient
  public abstract String getDatosEspecificos();
  
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
