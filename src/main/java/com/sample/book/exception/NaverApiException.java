package com.sample.book.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Naver Api Error")
public class NaverApiException extends RuntimeException {
	private static final long serialVersionUID = -1617748561937469287L;

	public NaverApiException() {
		super("External Api Error");
	}

	public NaverApiException(String message) {
		super(message);
	}
	
	public NaverApiException(String message, Throwable cause) {
		super(message, cause);
	}
}
