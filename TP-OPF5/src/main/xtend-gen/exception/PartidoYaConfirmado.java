package exception;

@SuppressWarnings("all")
public class PartidoYaConfirmado extends Exception {
  public PartidoYaConfirmado(final String message) {
    super(message);
  }
}
