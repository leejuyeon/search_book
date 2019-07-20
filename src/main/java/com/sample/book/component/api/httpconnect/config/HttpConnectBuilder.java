package com.sample.book.component.api.httpconnect.config;

import com.sample.book.component.api.httpconnect.client.RestTemplateOperations;

/**
 * {@code RestTemplateOperations.Builder} 또는 {@code WebClientOperations.Builder}를 생성합니다.
 * 
 * @since 2.0.0
 */
public final class HttpConnectBuilder {

	/**
	 * RestTemplateOperations을 생성할 수 있는 Builder를 얻습니다.
	 * @return RestTemplateOperations.Builder
	 */
	public static RestTemplateOperations.Builder client() {
		return RestTemplateOperations.builder();
	}

	private HttpConnectBuilder() {
		throw new IllegalStateException("Utility class");
	}

}