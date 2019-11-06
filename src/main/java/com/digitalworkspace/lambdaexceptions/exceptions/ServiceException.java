package com.digitalworkspace.lambdaexceptions.exceptions;

/**
 * A standard business exception
 */
public class ServiceException extends RuntimeException {

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}
}
