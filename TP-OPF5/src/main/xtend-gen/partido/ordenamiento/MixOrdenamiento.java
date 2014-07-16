package partido.ordenamiento;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import partido.core.Jugador;
import partido.core.Partido;
import partido.ordenamiento.Handicap;
import partido.ordenamiento.Ordenamiento;
import partido.ordenamiento.PromedioCalificaciones;
import partido.ordenamiento.PromedioNCalificaciones;

@SuppressWarnings("all")
public class MixOrdenamiento extends Ordenamiento {
  private List<Ordenamiento> _criterios;
  
  public List<Ordenamiento> getCriterios() {
    return this._criterios;
  }
  
  public void setCriterios(final List<Ordenamiento> criterios) {
    this._criterios = criterios;
  }
  
  public MixOrdenamiento(final Partido partido) {
    super(partido);
    ArrayList<Ordenamiento> _arrayList = new ArrayList<Ordenamiento>();
    this.setCriterios(_arrayList);
  }
  
  public boolean agregarCriterioHandicap() {
    List<Ordenamiento> _criterios = this.getCriterios();
    Partido _partido = this.getPartido();
    Handicap _handicap = new Handicap(_partido);
    return _criterios.add(_handicap);
  }
  
  public boolean agregarCriterioPromedioUltimoPartido() {
    List<Ordenamiento> _criterios = this.getCriterios();
    Partido _partido = this.getPartido();
    PromedioCalificaciones _promedioCalificaciones = new PromedioCalificaciones(_partido);
    return _criterios.add(_promedioCalificaciones);
  }
  
  public boolean agregarCriterioNCalificaciones(final Integer n) {
    List<Ordenamiento> _criterios = this.getCriterios();
    Partido _partido = this.getPartido();
    PromedioNCalificaciones _promedioNCalificaciones = new PromedioNCalificaciones(_partido, (n).intValue());
    return _criterios.add(_promedioNCalificaciones);
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
