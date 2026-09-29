package EX10.EX50TryCatch;

public class ProcessamentoDadosException extends RuntimeException {
  public ProcessamentoDadosException(String mensagem, Throwable causa) {
    super(mensagem, causa);
  }
}
