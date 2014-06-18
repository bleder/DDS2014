package partido.ordenamiento.builder;

import java.util.List;
import partido.core.Partido;
import partido.ordenamiento.builder.OrdenadorLista;

@SuppressWarnings("all")
public class OrdenadorListaCriterios extends OrdenadorLista {
  private List<OrdenadorLista> _criterios;
  
  public List<OrdenadorLista> getCriterios() {
    return this._criterios;
  }
  
  public void setCriterios(final List<OrdenadorLista> criterios) {
    this._criterios = criterios;
  }
  
  public void ordenar(final Partido partido) {
  }
}
