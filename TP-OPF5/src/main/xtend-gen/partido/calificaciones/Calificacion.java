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
  
  private Jugador _jugadorQueCalifico;
  
  public Jugador getJugadorQueCalifico() {
    return this._jugadorQueCalifico;
  }
  
  public void setJugadorQueCalifico(final Jugador jugadorQueCalifico) {
    this._jugadorQueCalifico = jugadorQueCalifico;
  }
  
  private Partido _partido;
  
  public Partido getPartido() {
    return this._partido;
  }
  
  public void setPartido(final Partido partido) {
    this._partido = partido;
  }
  
  private int _nota;
  
  public int getNota() {
    return this._nota;
  }
  
  public void setNota(final int nota) {
    this._nota = nota;
  }
  
  public Calificacion(final String string, final Jugador jugador, final Partido partidop, final int i) {
    this.setCritica(string);
    this.setJugadorQueCalifico(jugador);
    this.setPartido(partidop);
    this.setNota(i);
  }
}
