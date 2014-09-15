package uqbar.celulares.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.uqbar.commons.utils.ApplicationContext;
import org.uqbar.commons.utils.Observable;
import uqbar.celulares.domain.Celular;
import uqbar.celulares.domain.HomeCelulares;

/**
 * Application model que representa la búsqueda de {@link Celular}.
 * Contiene:
 * <ul>
 * 	<li>El estado de los atributos por los cuales buscar: numero y nombre</li>
 *  <li>El comportamiento para realizar la búsqueda (en realidad delega en otros objetos)</li>
 *  <li>El estado del resultado de la búsqueda, es decir que recuerda la lista de Celulares resultado</li>
 *  <li>El estado de la selección de un Celular para poder utilizar el comportamiento que sigue...</li>
 *  <li>Comportamiento para eliminar un Celular seleccionado.</li>
 * </ul>
 * 
 * Este es un objeto transiente, que contiene estado de la ejecución para un usuario en particular
 * en una ejecución de la aplicación en particular.
 * 
 * @author npasserini
 */
@Observable
@SuppressWarnings("all")
public class BuscadorCelular implements Serializable {
  private Integer _numero;
  
  public Integer getNumero() {
    return this._numero;
  }
  
  public void setNumero(final Integer numero) {
    this._numero = numero;
  }
  
  private String _nombre;
  
  public String getNombre() {
    return this._nombre;
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
  }
  
  private List<Celular> _resultados;
  
  public List<Celular> getResultados() {
    return this._resultados;
  }
  
  public void setResultados(final List<Celular> resultados) {
    this._resultados = resultados;
  }
  
  private Celular _celularSeleccionado;
  
  public Celular getCelularSeleccionado() {
    return this._celularSeleccionado;
  }
  
  public void setCelularSeleccionado(final Celular celularSeleccionado) {
    this._celularSeleccionado = celularSeleccionado;
  }
  
  public void search() {
    ArrayList<Celular> _arrayList = new ArrayList<Celular>();
    this.setResultados(_arrayList);
    HomeCelulares _homeCelulares = this.getHomeCelulares();
    Integer _numero = this.getNumero();
    String _nombre = this.getNombre();
    List<Celular> _search = _homeCelulares.search(_numero, _nombre);
    this.setResultados(_search);
  }
  
  public void clear() {
    this.setNombre(null);
    this.setNumero(null);
  }
  
  public void eliminarCelularSeleccionado() {
    HomeCelulares _homeCelulares = this.getHomeCelulares();
    Celular _celularSeleccionado = this.getCelularSeleccionado();
    _homeCelulares.delete(_celularSeleccionado);
    this.search();
    this.setCelularSeleccionado(null);
  }
  
  public HomeCelulares getHomeCelulares() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    return _instance.<HomeCelulares>getSingleton(Celular.class);
  }
}
