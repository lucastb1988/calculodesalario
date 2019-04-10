package br.com.calculodesalario.exceptions;

public class ValidacaoException extends RuntimeException {

	private static final long serialVersionUID = -8566217208225359541L;

	public ValidacaoException(String msg) {
		super(msg);
	}

	public ValidacaoException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
