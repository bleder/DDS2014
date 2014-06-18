package partido.ordenamiento;

import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import partido.core.Jugador;
import partido.core.Partido;
import partido.ordenamiento.Ordenamiento;

@SuppressWarnings("all")
public class MixOrdenamiento extends Ordenamiento {
  private List<Ordenamiento> _criterios;
  
  public List<Ordenamiento> getCriterios() {
    return this._criterios;
  }
  
  public void setCriterios(final List<Ordenamiento> criterios) {
    this._criterios = criterios;
  }
  
  public MixOrdenamiento(final Partido partido, final List<Ordenamiento> criterios) {
    super(partido);
    this.setCriterios(criterios);
  }
  
  public int ordenar(final Jugador jugador) {
    int _xblockexpression = (int) 0;
    {
      List<Ordenamiento> _criterios = this.getCriterios();
      final Function1<Ordenamiento,Integer> _function = new Function1<Ordenamiento,Integer>() {
        public Integer apply(final Ordenamiento criterio) {
          return Integer.valueOf(criterio.ordenar(jugador));
        }
      };
      List<Integer> _map = ListExtensions.<Ordenamiento, Integer>map(_criterios, _function);
      final Function2<Integer,Integer,Integer> _function_1 = new Function2<Integer,Integer,Integer>() {
        public Integer apply(final Integer n1, final Integer n2) {
          return Integer.valueOf(((n1).intValue() + (n2).intValue()));
        }
      };
      final Integer sum = IterableExtensions.<Integer>reduce(_map, _function_1);
      List<Ordenamiento> _criterios_1 = this.getCriterios();
      final int cant = _criterios_1.size();
      final int resultado = ((sum).intValue() / cant);
      _xblockexpression = Integer.valueOf(resultado).intValue();
    }
    return _xblockexpression;
  }
}
