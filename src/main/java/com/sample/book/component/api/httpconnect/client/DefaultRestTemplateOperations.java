package com.sample.book.component.api.httpconnect.client;

import org.springframework.web.client.RestTemplate;

class DefaultRestTemplateOperations implements RestTemplateOperations {

	private final DefaultRestTemplateOperationsBuilder builder;

	private final RestTemplate client;

	DefaultRestTemplateOperations(DefaultRestTemplateOperationsBuilder builder) {
		this.builder = builder;
		this.client = builder.buildRestTemplate();
	}

	@Override
	public Builder mutate() {
		return new DefaultRestTemplateOperationsBuilder(this.builder);
	}

	@Override
	public RestTemplate getClient() {
		return this.client;
	}

}