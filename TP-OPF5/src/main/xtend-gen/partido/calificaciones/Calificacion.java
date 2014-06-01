package partido.calificaciones;

import partido.core.Jugador;
import partido.core.Partido;

@SuppressWarnings("all")
public class Calificacion {
  private String _critica;
  
  public String getCritica() {
    return this._critica;
  }
  
  public void setCritica(final String critica) {
    this._critica = critica;
  }
  
  private Jugador jugadorQueCalifico;
  
  private Partido partido;
  
  private int _nota;
  
  public int getNota() {
    return this._nota;
  }
  
  public void setNota(final int nota) {
    this._nota = nota;
  }
  
  public Calificacion(final String string, final Jugador jugador, final Partido partidop, final int i) {
    this.setCritica(string);
    this.jugadorQueCalifico = jugador;
    this.partido = partidop;
    this.setNota(i);
  }
}
