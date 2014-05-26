package partido.core;

import utn.edu.dds.TP_OPF5.TipoInscripcion;

@SuppressWarnings("all")
public class Inscripcion {
  private TipoInscripcion _tipoInscripcion;
  
  public TipoInscripcion getTipoInscripcion() {
    return this._tipoInscripcion;
  }
  
  public void setTipoInscripcion(final TipoInscripcion tipoInscripcion) {
    this._tipoInscripcion = tipoInscripcion;
  }
  
  private /* utn.edu.dds.TP_OPF5.Jugador */Object _jugador;
  
  public /* utn.edu.dds.TP_OPF5.Jugador */Object getJugador() {
    return this._jugador;
  }
  
  public void setJugador(final /* utn.edu.dds.TP_OPF5.Jugador */Object jugador) {
    this._jugador = jugador;
  }
  
  private boolean _estaConfirmada;
  
  public boolean isEstaConfirmada() {
    return this._estaConfirmada;
  }
  
  public void setEstaConfirmada(final boolean estaConfirmada) {
    this._estaConfirmada = estaConfirmada;
  }
  
  public Inscripcion(final /* utn.edu.dds.TP_OPF5.Jugador */Object jug, final TipoInscripcion tipoIncrip) {
    this.setTipoInscripcion(tipoIncrip);
    this.setJugador(jug);
    this.setEstaConfirmada(false);
  }
  
  public Object sosInscripcionDe(final /* utn.edu.dds.TP_OPF5.Jugador */Object otroJugador) {
    throw new Error("Unresolved compilation problems:"
      + "\n== cannot be resolved");
  }
  
  public void confirmar() {
    this.setEstaConfirmada(true);
  }
}
