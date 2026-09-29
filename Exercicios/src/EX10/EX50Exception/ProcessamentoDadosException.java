package EX10.EX50Exception;

public class ProcessamentoDadosException extends RuntimeException {
  public ProcessamentoDadosException(String mensagem, Throwable causa) {
    super(mensagem, causa);
  }
}
