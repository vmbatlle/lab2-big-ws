package translator.exception;

public class TranslatorException extends RuntimeException {

  private static final long serialVersionUID = 7094604538630942965L;

  public TranslatorException(String message) {
    super(message);
  }

  public TranslatorException(String message, Throwable cause) {
    super(message, cause);
  }
}
