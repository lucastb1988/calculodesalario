package br.com.calculodesalario.exceptions;

public class ValidationException extends RuntimeException {

    private static final long serialVersionUID = -8566217208225359541L;

    public ValidationException(final String msg) {
        super(msg);
    }

    public ValidationException(final String msg, final Throwable cause) {
        super(msg, cause);
    }
}
