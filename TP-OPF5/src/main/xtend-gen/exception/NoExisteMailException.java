package exception;

@SuppressWarnings("all")
public class NoExisteMailException extends Exception {
  public NoExisteMailException(final String message) {
    super(message);
  }
}
