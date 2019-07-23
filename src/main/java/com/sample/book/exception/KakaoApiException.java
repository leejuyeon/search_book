package com.sample.book.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Kakao Api Error")
public class KakaoApiException extends RuntimeException {
	private static final long serialVersionUID = -6242037800672293446L;

	public KakaoApiException() {
		super("External Api Error");
	}

	public KakaoApiException(String message) {
		super(message);
	}
	
	public KakaoApiException(String message, Throwable cause) {
		super(message, cause);
	}
}
