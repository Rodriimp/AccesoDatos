package ej02.services;

public class ClientesServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClientesServiceException() {
	}

	public ClientesServiceException(String message) {
		super(message);

	}

	public ClientesServiceException(Throwable cause) {
		super(cause);

	}

	public ClientesServiceException(String message, Throwable cause) {
		super(message, cause);

	}

	public ClientesServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
