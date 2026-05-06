package Lista;

public class InvalidIndexException extends RuntimeException {

    public InvalidIndexException(String mensagem) {
        super(mensagem);
    }
}