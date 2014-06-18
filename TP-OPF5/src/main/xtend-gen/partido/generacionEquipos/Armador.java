package partido.generacionEquipos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pair;
import partido.core.Jugador;
import partido.generacionEquipos.Equipo;

@SuppressWarnings("all")
public class Armador {
  private HashMap<Integer,Integer> armadorParImpar;
  
  private HashMap<Integer,Integer> armadorRandom;
  
  public Armador() {
    Pair<Integer,Integer> _mappedTo = Pair.<Integer, Integer>of(Integer.valueOf(1), Integer.valueOf(0));
    Pair<Integer,Integer> _mappedTo_1 = Pair.<Integer, Integer>of(Integer.valueOf(2), Integer.valueOf(1));
    Pair<Integer,Integer> _mappedTo_2 = Pair.<Integer, Integer>of(Integer.valueOf(3), Integer.valueOf(0));
    Pair<Integer,Integer> _mappedTo_3 = Pair.<Integer, Integer>of(Integer.valueOf(4), Integer.valueOf(1));
    Pair<Integer,Integer> _mappedTo_4 = Pair.<Integer, Integer>of(Integer.valueOf(5), Integer.valueOf(0));
    Pair<Integer,Integer> _mappedTo_5 = Pair.<Integer, Integer>of(Integer.valueOf(6), Integer.valueOf(1));
    Pair<Integer,Integer> _mappedTo_6 = Pair.<Integer, Integer>of(Integer.valueOf(7), Integer.valueOf(0));
    Pair<Integer,Integer> _mappedTo_7 = Pair.<Integer, Integer>of(Integer.valueOf(8), Integer.valueOf(1));
    Pair<Integer,Integer> _mappedTo_8 = Pair.<Integer, Integer>of(Integer.valueOf(9), Integer.valueOf(0));
    Pair<Integer,Integer> _mappedTo_9 = Pair.<Integer, Integer>of(Integer.valueOf(10), Integer.valueOf(1));
    HashMap<Integer,Integer> _newHashMap = CollectionLiterals.<Integer, Integer>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3, _mappedTo_4, _mappedTo_5, _mappedTo_6, _mappedTo_7, _mappedTo_8, _mappedTo_9);
    this.armadorParImpar = _newHashMap;
    Pair<Integer,Integer> _mappedTo_10 = Pair.<Integer, Integer>of(Integer.valueOf(1), Integer.valueOf(0));
    Pair<Integer,Integer> _mappedTo_11 = Pair.<Integer, Integer>of(Integer.valueOf(2), Integer.valueOf(1));
    Pair<Integer,Integer> _mappedTo_12 = Pair.<Integer, Integer>of(Integer.valueOf(3), Integer.valueOf(1));
    Pair<Integer,Integer> _mappedTo_13 = Pair.<Integer, Integer>of(Integer.valueOf(4), Integer.valueOf(0));
    Pair<Integer,Integer> _mappedTo_14 = Pair.<Integer, Integer>of(Integer.valueOf(5), Integer.valueOf(0));
    Pair<Integer,Integer> _mappedTo_15 = Pair.<Integer, Integer>of(Integer.valueOf(6), Integer.valueOf(1));
    Pair<Integer,Integer> _mappedTo_16 = Pair.<Integer, Integer>of(Integer.valueOf(7), Integer.valueOf(1));
    Pair<Integer,Integer> _mappedTo_17 = Pair.<Integer, Integer>of(Integer.valueOf(8), Integer.valueOf(0));
    Pair<Integer,Integer> _mappedTo_18 = Pair.<Integer, Integer>of(Integer.valueOf(9), Integer.valueOf(0));
    Pair<Integer,Integer> _mappedTo_19 = Pair.<Integer, Integer>of(Integer.valueOf(10), Integer.valueOf(1));
    HashMap<Integer,Integer> _newHashMap_1 = CollectionLiterals.<Integer, Integer>newHashMap(_mappedTo_10, _mappedTo_11, _mappedTo_12, _mappedTo_13, _mappedTo_14, _mappedTo_15, _mappedTo_16, _mappedTo_17, _mappedTo_18, _mappedTo_19);
    this.armadorRandom = _newHashMap_1;
  }
  
  public ArrayList<Equipo> armarEquipos(final List<Jugador> jugadores, final HashMap<Integer,Integer> armador) {
    ArrayList<Equipo> _xblockexpression = null;
    {
      final ArrayList<Equipo> equipos = new ArrayList<Equipo>();
      Equipo _equipo = new Equipo();
      equipos.add(_equipo);
      Equipo _equipo_1 = new Equipo();
      equipos.add(_equipo_1);
      int i = 0;
      int _size = jugadores.size();
      boolean _lessThan = (i < _size);
      boolean _while = _lessThan;
      while (_while) {
        {
          Integer _get = armador.get(Integer.valueOf((i + 1)));
          Equipo _get_1 = equipos.get((_get).intValue());
          Jugador _get_2 = jugadores.get(i);
          _get_1.agregarJugador(_get_2);
          i = (i + 1);
        }
        int _size_1 = jugadores.size();
        boolean _lessThan_1 = (i < _size_1);
        _while = _lessThan_1;
      }
      _xblockexpression = equipos;
    }
    return _xblockexpression;
  }
  
  public ArrayList<Equipo> armarParImpar(final List<Jugador> jugadores) {
    return this.armarEquipos(jugadores, this.armadorParImpar);
  }
  
  public ArrayList<Equipo> armarRandom(final List<Jugador> jugadores) {
    return this.armarEquipos(jugadores, this.armadorRandom);
  }
}
