package partido.mailSender;

@SuppressWarnings("all")
public interface Notificador {
  public abstract void notificar(final /* String */Object mail, final /* String */Object mensaje);
}
