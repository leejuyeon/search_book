package com.sample.book.component.api.httpconnect.client;

import java.util.function.Consumer;

import org.springframework.web.client.RestTemplate;

public interface RestTemplateConfigurer {

	default void configureOkHttpClient(OkHttpClientOptions options) {
	}

	default Consumer<RestTemplate> customizer() {
		return client -> {
		};
	}

}
