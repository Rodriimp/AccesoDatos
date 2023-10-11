package ej03.services;

public class PagosServicesException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PagosServicesException() {
	}

	public PagosServicesException(String message) {
		super(message);

	}

	public PagosServicesException(Throwable cause) {
		super(cause);

	}

	public PagosServicesException(String message, Throwable cause) {
		super(message, cause);

	}

	public PagosServicesException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
