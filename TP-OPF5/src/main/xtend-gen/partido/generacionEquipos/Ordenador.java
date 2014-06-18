package partido.generacionEquipos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import partido.calificaciones.Calificacion;
import partido.core.Jugador;

@SuppressWarnings("all")
public class Ordenador {
  private List<Function1<Jugador,Integer>> _criterios;
  
  public List<Function1<Jugador,Integer>> getCriterios() {
    return this._criterios;
  }
  
  public void setCriterios(final List<Function1<Jugador,Integer>> criterios) {
    this._criterios = criterios;
  }
  
  public Ordenador() {
    ArrayList<Function1<Jugador,Integer>> _arrayList = new ArrayList<Function1<Jugador, Integer>>();
    this.setCriterios(_arrayList);
  }
  
  public boolean agregarCriterioHandicap() {
    List<Function1<Jugador,Integer>> _criterios = this.getCriterios();
    final Function1<Jugador,Integer> _function = new Function1<Jugador,Integer>() {
      public Integer apply(final Jugador jugador) {
        return Integer.valueOf(jugador.getHandicap());
      }
    };
    return _criterios.add(_function);
  }
  
  public boolean agregarCriterioPromedioUltimoPartido() {
    List<Function1<Jugador,Integer>> _criterios = this.getCriterios();
    final Function1<Jugador,Integer> _function = new Function1<Jugador,Integer>() {
      public Integer apply(final Jugador jugador) {
        return Integer.valueOf(jugador.promedioUltimoPartido());
      }
    };
    return _criterios.add(_function);
  }
  
  public boolean agregarCriterioUltimasCalificaciones(final Integer n) {
    List<Function1<Jugador,Integer>> _criterios = this.getCriterios();
    final Function1<Jugador,Integer> _function = new Function1<Jugador,Integer>() {
      public Integer apply(final Jugador jugador) {
        int _xblockexpression = (int) 0;
        {
          final Iterable<Calificacion> ultimasCalificaciones = jugador.ultimasCalificaciones(n);
          final Function1<Calificacion,Integer> _function = new Function1<Calificacion,Integer>() {
            public Integer apply(final Calificacion calif) {
              return Integer.valueOf(calif.getNota());
            }
          };
          Iterable<Integer> _map = IterableExtensions.<Calificacion, Integer>map(ultimasCalificaciones, _function);
          final Function2<Integer,Integer,Integer> _function_1 = new Function2<Integer,Integer,Integer>() {
            public Integer apply(final Integer a, final Integer b) {
              return Integer.valueOf(((a).intValue() + (b).intValue()));
            }
          };
          Integer _reduce = IterableExtensions.<Integer>reduce(_map, _function_1);
          int _size = IterableExtensions.size(ultimasCalificaciones);
          _xblockexpression = ((_reduce).intValue() / _size);
        }
        return Integer.valueOf(_xblockexpression);
      }
    };
    return _criterios.add(_function);
  }
  
  public void volverAEmpezar() {
    ArrayList<Function1<Jugador,Integer>> _arrayList = new ArrayList<Function1<Jugador, Integer>>();
    this.setCriterios(_arrayList);
  }
  
  public List<Jugador> buildListaOrdenada(final List<Jugador> jugadores) {
    final Comparator<Jugador> _function = new Comparator<Jugador>() {
      public int compare(final Jugador jugador1, final Jugador jugador2) {
        List<Function1<Jugador,Integer>> _criterios = Ordenador.this.getCriterios();
        final Function1<Function1<Jugador,Integer>,Integer> _function = new Function1<Function1<Jugador,Integer>,Integer>() {
          public Integer apply(final Function1<Jugador,Integer> criterio) {
            return criterio.apply(jugador1);
          }
        };
        final List<Integer> notas1 = ListExtensions.<Function1<Jugador,Integer>, Integer>map(_criterios, _function);
        List<Function1<Jugador,Integer>> _criterios_1 = Ordenador.this.getCriterios();
        final Function1<Function1<Jugador,Integer>,Integer> _function_1 = new Function1<Function1<Jugador,Integer>,Integer>() {
          public Integer apply(final Function1<Jugador,Integer> criterio) {
            return criterio.apply(jugador2);
          }
        };
        final List<Integer> notas2 = ListExtensions.<Function1<Jugador,Integer>, Integer>map(_criterios_1, _function_1);
        final Function2<Integer,Integer,Integer> _function_2 = new Function2<Integer,Integer,Integer>() {
          public Integer apply(final Integer a, final Integer b) {
            return Integer.valueOf(((a).intValue() + (b).intValue()));
          }
        };
        Integer _reduce = IterableExtensions.<Integer>reduce(notas1, _function_2);
        int _size = notas1.size();
        final int promedio1 = ((_reduce).intValue() / _size);
        final Function2<Integer,Integer,Integer> _function_3 = new Function2<Integer,Integer,Integer>() {
          public Integer apply(final Integer a, final Integer b) {
            return Integer.valueOf(((a).intValue() + (b).intValue()));
          }
        };
        Integer _reduce_1 = IterableExtensions.<Integer>reduce(notas2, _function_3);
        int _size_1 = notas2.size();
        final int promedio2 = ((_reduce_1).intValue() / _size_1);
        if ((promedio1 >= promedio2)) {
          return (-1);
        }
        return 1;
      }
    };
    return IterableExtensions.<Jugador>sort(jugadores, _function);
  }
}
