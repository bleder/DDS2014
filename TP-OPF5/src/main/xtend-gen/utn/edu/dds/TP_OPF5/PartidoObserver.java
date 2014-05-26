package utn.edu.dds.TP_OPF5;

import utn.edu.dds.TP_OPF5.Partido;

@SuppressWarnings("all")
public interface PartidoObserver {
  public abstract void jugadorInscripto(final /* Jugador */Object jugador, final Partido partido);
  
  public abstract void jugadorDadoDeBaja(final /* Jugador */Object jugador, final Partido partido);
  
  public abstract void jugadorConfirmado(final /* Jugador */Object jugador, final Partido partido);
}
