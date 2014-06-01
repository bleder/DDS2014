package exception;

@SuppressWarnings("all")
public class JugadorNoPerteneceAlPartido extends Exception {
  public JugadorNoPerteneceAlPartido(final String message) {
    super(message);
  }
}
