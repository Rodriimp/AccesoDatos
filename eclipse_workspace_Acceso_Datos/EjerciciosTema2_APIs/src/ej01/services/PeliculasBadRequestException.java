package ej01.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PeliculasBadRequestException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3394319610854877185L;

	public PeliculasBadRequestException() {
		// TODO Auto-generated constructor stub
	}

	public PeliculasBadRequestException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PeliculasBadRequestException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public PeliculasBadRequestException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PeliculasBadRequestException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
