package com.digisight.platform.utility;

@SuppressWarnings("serial")

public class BaseRuntimeException extends RuntimeException {

	public BaseRuntimeException(String message, Throwable cause) {

		super(message, cause);

	}

	public BaseRuntimeException(String message) {

		super(message);

	}

	public BaseRuntimeException(Throwable cause) {

		super(cause);

	}

}