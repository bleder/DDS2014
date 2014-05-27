package partido.mailSender;

@SuppressWarnings("all")
public interface Notificador {
  public abstract void notificar(final String mail, final String mensaje);
}
