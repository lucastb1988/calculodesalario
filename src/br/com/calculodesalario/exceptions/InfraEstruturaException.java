package br.com.calculodesalario.exceptions;

public class InfraEstruturaException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InfraEstruturaException(final String msg) {
        super(msg);
    }

    public InfraEstruturaException(final String msg, final Throwable cause) {
        super(msg, cause);
    }
}
