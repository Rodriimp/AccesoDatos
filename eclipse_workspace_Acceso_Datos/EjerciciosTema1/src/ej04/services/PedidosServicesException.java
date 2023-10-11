package ej04.services;

public class PedidosServicesException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1468890452360694026L;

	public PedidosServicesException() {
	}

	public PedidosServicesException(String message) {
		super(message);

	}

	public PedidosServicesException(Throwable cause) {
		super(cause);

	}

	public PedidosServicesException(String message, Throwable cause) {
		super(message, cause);

	}

	public PedidosServicesException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
