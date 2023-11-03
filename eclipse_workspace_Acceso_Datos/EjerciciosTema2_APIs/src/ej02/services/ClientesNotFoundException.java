package ej02.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ClientesNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8358987792487636944L;

	public ClientesNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public ClientesNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ClientesNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public ClientesNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ClientesNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
