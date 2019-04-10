package br.com.calculodesalario.exceptions;

public class InfrastructureException extends Exception {

    private static final long serialVersionUID = 1L;

    public InfrastructureException(final String msg) {
        super(msg);
    }

    public InfrastructureException(final String msg, final Throwable cause) {
        super(msg, cause);
    }
}
