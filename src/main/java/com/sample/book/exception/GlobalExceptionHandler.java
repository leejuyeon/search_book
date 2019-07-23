package com.sample.book.exception;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ExceptionHandler(value = { KakaoApiException.class, NaverApiException.class })
	public ResponseEntity<ExceptionMessageWrapper> apiExceptions(Exception e, HttpServletRequest request) {
		HttpStatus httpStatus = HttpStatus.FORBIDDEN;
		return new ResponseEntity<ExceptionMessageWrapper>(exceptionMessage(e, request, httpStatus), httpStatus);
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<ExceptionMessageWrapper> systemExceptions(Exception e, HttpServletRequest request) {
		HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		return new ResponseEntity<ExceptionMessageWrapper>(exceptionMessage(e, request, httpStatus), httpStatus);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { MissingServletRequestParameterException.class })
	public ResponseEntity<ExceptionMessageWrapper> missRequestParameterException(Exception e, HttpServletRequest request) {
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		return new ResponseEntity<ExceptionMessageWrapper>(exceptionMessage(e, request, httpStatus), httpStatus);
	}

	@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ExceptionMessageWrapper> accessDeniedException(Exception e, HttpServletRequest request) {
		HttpStatus httpStatus = HttpStatus.SERVICE_UNAVAILABLE;
		return new ResponseEntity<ExceptionMessageWrapper>(exceptionMessage(e, request, httpStatus), httpStatus);
	}
	
	private ExceptionMessageWrapper exceptionMessage(Exception e, HttpServletRequest request, HttpStatus httpStatus) {
		return new ExceptionMessageWrapper(new DateTime(), e.getMessage(), request.getPathInfo(), e.getClass().getSimpleName(),
				httpStatus);
	}
}