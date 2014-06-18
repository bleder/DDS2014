package utn.edu.dds.TP_OPF5.test;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import partido.core.Jugador;
import partido.generacionEquipos.Armador;
import partido.generacionEquipos.Equipo;

@SuppressWarnings("all")
public class TstArmador {
  private List<Jugador> jugadores;
  
  private Armador armador;
  
  @Before
  public void init() {
    Armador _armador = new Armador();
    this.armador = _armador;
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    this.jugadores = _arrayList;
    int i = 0;
    boolean _while = (i < 10);
    while (_while) {
      {
        Jugador _jugador = new Jugador("", "");
        this.jugadores.add(_jugador);
        i = (i + 1);
      }
      _while = (i < 10);
    }
  }
  
  @Test
  public void jugadoresBienDivididosParImpar() {
    final List<Equipo> equiposSeparados = this.armador.armarParImpar(this.jugadores);
    Equipo _get = equiposSeparados.get(0);
    List<Jugador> _equipo = _get.getEquipo();
    final Function1<Jugador,Boolean> _function = new Function1<Jugador,Boolean>() {
      public Boolean apply(final Jugador it) {
        Jugador _get = TstArmador.this.jugadores.get(0);
        return Boolean.valueOf(Objects.equal(it, _get));
      }
    };
    boolean _exists = IterableExtensions.<Jugador>exists(_equipo, _function);
    Assert.assertTrue(_exists);
    Equipo _get_1 = equiposSeparados.get(0);
    List<Jugador> _equipo_1 = _get_1.getEquipo();
    final Function1<Jugador,Boolean> _function_1 = new Function1<Jugador,Boolean>() {
      public Boolean apply(final Jugador it) {
        Jugador _get = TstArmador.this.jugadores.get(2);
        return Boolean.valueOf(Objects.equal(it, _get));
      }
    };
    boolean _exists_1 = IterableExtensions.<Jugador>exists(_equipo_1, _function_1);
    Assert.assertTrue(_exists_1);
    Equipo _get_2 = equiposSeparados.get(0);
    List<Jugador> _equipo_2 = _get_2.getEquipo();
    final Function1<Jugador,Boolean> _function_2 = new Function1<Jugador,Boolean>() {
      public Boolean apply(final Jugador it) {
        Jugador _get = TstArmador.this.jugadores.get(4);
        return Boolean.valueOf(Objects.equal(it, _get));
      }
    };
    boolean _exists_2 = IterableExtensions.<Jugador>exists(_equipo_2, _function_2);
    Assert.assertTrue(_exists_2);
    Equipo _get_3 = equiposSeparados.get(0);
    List<Jugador> _equipo_3 = _get_3.getEquipo();
    final Function1<Jugador,Boolean> _function_3 = new Function1<Jugador,Boolean>() {
      public Boolean apply(final Jugador it) {
        Jugador _get = TstArmador.this.jugadores.get(6);
        return Boolean.valueOf(Objects.equal(it, _get));
      }
    };
    boolean _exists_3 = IterableExtensions.<Jugador>exists(_equipo_3, _function_3);
    Assert.assertTrue(_exists_3);
    Equipo _get_4 = equiposSeparados.get(0);
    List<Jugador> _equipo_4 = _get_4.getEquipo();
    final Function1<Jugador,Boolean> _function_4 = new Function1<Jugador,Boolean>() {
      public Boolean apply(final Jugador it) {
        Jugador _get = TstArmador.this.jugadores.get(8);
        return Boolean.valueOf(Objects.equal(it, _get));
      }
    };
    boolean _exists_4 = IterableExtensions.<Jugador>exists(_equipo_4, _function_4);
    Assert.assertTrue(_exists_4);
    Equipo _get_5 = equiposSeparados.get(1);
    List<Jugador> _equipo_5 = _get_5.getEquipo();
    final Function1<Jugador,Boolean> _function_5 = new Function1<Jugador,Boolean>() {
      public Boolean apply(final Jugador it) {
        Jugador _get = TstArmador.this.jugadores.get(1);
        return Boolean.valueOf(Objects.equal(it, _get));
      }
    };
    boolean _exists_5 = IterableExtensions.<Jugador>exists(_equipo_5, _function_5);
    Assert.assertTrue(_exists_5);
    Equipo _get_6 = equiposSeparados.get(1);
    List<Jugador> _equipo_6 = _get_6.getEquipo();
    final Function1<Jugador,Boolean> _function_6 = new Function1<Jugador,Boolean>() {
      public Boolean apply(final Jugador it) {
        Jugador _get = TstArmador.this.jugadores.get(3);
        return Boolean.valueOf(Objects.equal(it, _get));
      }
    };
    boolean _exists_6 = IterableExtensions.<Jugador>exists(_equipo_6, _function_6);
    Assert.assertTrue(_exists_6);
    Equipo _get_7 = equiposSeparados.get(1);
    List<Jugador> _equipo_7 = _get_7.getEquipo();
    final Function1<Jugador,Boolean> _function_7 = new Function1<Jugador,Boolean>() {
      public Boolean apply(final Jugador it) {
        Jugador _get = TstArmador.this.jugadores.get(5);
        return Boolean.valueOf(Objects.equal(it, _get));
      }
    };
    boolean _exists_7 = IterableExtensions.<Jugador>exists(_equipo_7, _function_7);
    Assert.assertTrue(_exists_7);
    Equipo _get_8 = equiposSeparados.get(1);
    List<Jugador> _equipo_8 = _get_8.getEquipo();
    final Function1<Jugador,Boolean> _function_8 = new Function1<Jugador,Boolean>() {
      public Boolean apply(final Jugador it) {
        Jugador _get = TstArmador.this.jugadores.get(7);
        return Boolean.valueOf(Objects.equal(it, _get));
      }
    };
    boolean _exists_8 = IterableExtensions.<Jugador>exists(_equipo_8, _function_8);
    Assert.assertTrue(_exists_8);
    Equipo _get_9 = equiposSeparados.get(1);
    List<Jugador> _equipo_9 = _get_9.getEquipo();
    final Function1<Jugador,Boolean> _function_9 = new Function1<Jugador,Boolean>() {
      public Boolean apply(final Jugador it) {
        Jugador _get = TstArmador.this.jugadores.get(9);
        return Boolean.valueOf(Objects.equal(it, _get));
      }
    };
    boolean _exists_9 = IterableExtensions.<Jugador>exists(_equipo_9, _function_9);
    Assert.assertTrue(_exists_9);
  }
  
  @Test
  public void jugadoresBienDivididosRandom() {
    final List<Equipo> equiposSeparados = this.armador.armarRandom(this.jugadores);
    Equipo _get = equiposSeparados.get(0);
    List<Jugador> _equipo = _get.getEquipo();
    final Function1<Jugador,Boolean> _function = new Function1<Jugador,Boolean>() {
      public Boolean apply(final Jugador it) {
        Jugador _get = TstArmador.this.jugadores.get(0);
        return Boolean.valueOf(Objects.equal(it, _get));
      }
    };
    boolean _exists = IterableExtensions.<Jugador>exists(_equipo, _function);
    Assert.assertTrue(_exists);
    Equipo _get_1 = equiposSeparados.get(0);
    List<Jugador> _equipo_1 = _get_1.getEquipo();
    final Function1<Jugador,Boolean> _function_1 = new Function1<Jugador,Boolean>() {
      public Boolean apply(final Jugador it) {
        Jugador _get = TstArmador.this.jugadores.get(3);
        return Boolean.valueOf(Objects.equal(it, _get));
      }
    };
    boolean _exists_1 = IterableExtensions.<Jugador>exists(_equipo_1, _function_1);
    Assert.assertTrue(_exists_1);
    Equipo _get_2 = equiposSeparados.get(0);
    List<Jugador> _equipo_2 = _get_2.getEquipo();
    final Function1<Jugador,Boolean> _function_2 = new Function1<Jugador,Boolean>() {
      public Boolean apply(final Jugador it) {
        Jugador _get = TstArmador.this.jugadores.get(4);
        return Boolean.valueOf(Objects.equal(it, _get));
      }
    };
    boolean _exists_2 = IterableExtensions.<Jugador>exists(_equipo_2, _function_2);
    Assert.assertTrue(_exists_2);
    Equipo _get_3 = equiposSeparados.get(0);
    List<Jugador> _equipo_3 = _get_3.getEquipo();
    final Function1<Jugador,Boolean> _function_3 = new Function1<Jugador,Boolean>() {
      public Boolean apply(final Jugador it) {
        Jugador _get = TstArmador.this.jugadores.get(7);
        return Boolean.valueOf(Objects.equal(it, _get));
      }
    };
    boolean _exists_3 = IterableExtensions.<Jugador>exists(_equipo_3, _function_3);
    Assert.assertTrue(_exists_3);
    Equipo _get_4 = equiposSeparados.get(0);
    List<Jugador> _equipo_4 = _get_4.getEquipo();
    final Function1<Jugador,Boolean> _function_4 = new Function1<Jugador,Boolean>() {
      public Boolean apply(final Jugador it) {
        Jugador _get = TstArmador.this.jugadores.get(8);
        return Boolean.valueOf(Objects.equal(it, _get));
      }
    };
    boolean _exists_4 = IterableExtensions.<Jugador>exists(_equipo_4, _function_4);
    Assert.assertTrue(_exists_4);
    Equipo _get_5 = equiposSeparados.get(1);
    List<Jugador> _equipo_5 = _get_5.getEquipo();
    final Function1<Jugador,Boolean> _function_5 = new Function1<Jugador,Boolean>() {
      public Boolean apply(final Jugador it) {
        Jugador _get = TstArmador.this.jugadores.get(1);
        return Boolean.valueOf(Objects.equal(it, _get));
      }
    };
    boolean _exists_5 = IterableExtensions.<Jugador>exists(_equipo_5, _function_5);
    Assert.assertTrue(_exists_5);
    Equipo _get_6 = equiposSeparados.get(1);
    List<Jugador> _equipo_6 = _get_6.getEquipo();
    final Function1<Jugador,Boolean> _function_6 = new Function1<Jugador,Boolean>() {
      public Boolean apply(final Jugador it) {
        Jugador _get = TstArmador.this.jugadores.get(2);
        return Boolean.valueOf(Objects.equal(it, _get));
      }
    };
    boolean _exists_6 = IterableExtensions.<Jugador>exists(_equipo_6, _function_6);
    Assert.assertTrue(_exists_6);
    Equipo _get_7 = equiposSeparados.get(1);
    List<Jugador> _equipo_7 = _get_7.getEquipo();
    final Function1<Jugador,Boolean> _function_7 = new Function1<Jugador,Boolean>() {
      public Boolean apply(final Jugador it) {
        Jugador _get = TstArmador.this.jugadores.get(5);
        return Boolean.valueOf(Objects.equal(it, _get));
      }
    };
    boolean _exists_7 = IterableExtensions.<Jugador>exists(_equipo_7, _function_7);
    Assert.assertTrue(_exists_7);
    Equipo _get_8 = equiposSeparados.get(1);
    List<Jugador> _equipo_8 = _get_8.getEquipo();
    final Function1<Jugador,Boolean> _function_8 = new Function1<Jugador,Boolean>() {
      public Boolean apply(final Jugador it) {
        Jugador _get = TstArmador.this.jugadores.get(6);
        return Boolean.valueOf(Objects.equal(it, _get));
      }
    };
    boolean _exists_8 = IterableExtensions.<Jugador>exists(_equipo_8, _function_8);
    Assert.assertTrue(_exists_8);
    Equipo _get_9 = equiposSeparados.get(1);
    List<Jugador> _equipo_9 = _get_9.getEquipo();
    final Function1<Jugador,Boolean> _function_9 = new Function1<Jugador,Boolean>() {
      public Boolean apply(final Jugador it) {
        Jugador _get = TstArmador.this.jugadores.get(9);
        return Boolean.valueOf(Objects.equal(it, _get));
      }
    };
    boolean _exists_9 = IterableExtensions.<Jugador>exists(_equipo_9, _function_9);
    Assert.assertTrue(_exists_9);
  }
}
