package partido.calificaciones;

import partido.core.Jugador;
import partido.core.Partido;

@SuppressWarnings("all")
public class Calificacion {
  /**
   * @Property
   */
  private int id_calificacion;
  
  /**
   * @Property
   */
  private String critica;
  
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
  
  /**
   * @Property
   */
  private int nota;
  
  public Calificacion(final String string, final Jugador jugador, final Partido partidop, final int i) {
    this.critica = string;
    this.setJugadorQueCalifico(jugador);
    this.setPartido(partidop);
    this.nota = i;
  }
  
  public int setId_calificacion(final int id_calificacion) {
    return this.id_calificacion = id_calificacion;
  }
  
  public int getId_calificacion() {
    return this.id_calificacion;
  }
  
  public String setCritica(final String critica) {
    return this.critica = critica;
  }
  
  public String getCritica() {
    return this.critica;
  }
  
  public int setNota(final int nota) {
    return this.nota = nota;
  }
  
  public int getNota() {
    return this.nota;
  }
}
