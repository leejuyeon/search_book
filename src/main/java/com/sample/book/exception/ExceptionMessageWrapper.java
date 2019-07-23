package com.sample.book.exception;

import org.joda.time.DateTime;
import org.springframework.http.HttpStatus;

public class ExceptionMessageWrapper {

	private long timestamp;
	private String message;
	private String path;
	private String exceptionClassName;
	private int status;
	private String error;
	

	public ExceptionMessageWrapper(DateTime timestamp, String message, String path, String exceptionClassName, HttpStatus httpStatus) {
		this.timestamp = timestamp.getMillis();
		this.message = message;
		this.path = path;
		this.exceptionClassName = exceptionClassName;
		this.status = httpStatus.value();
		this.error = httpStatus.getReasonPhrase();
	}

	public long getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getPath() {
		return path;
	}

	public String getError() {
		return error;
	}
	
	public int getStatus() {
		return status;
	}
	
	public String getExceptionClassName() {
		return exceptionClassName;
	}

	@Override
	public String toString() {
		return "AionExceptionMessageWrapper [timestamp=" + timestamp + ", message=" + message + ", path=" + path
				+ ", exceptionClassName=" + exceptionClassName + ", status=" + status + ", error=" + error + "]";
	}
	
}
