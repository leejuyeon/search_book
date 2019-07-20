package com.sample.book.component.api.httpconnect.client;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import com.sample.book.component.api.httpconnect.HttpClientOperations;

public abstract class AbstractRestTemplateApiBinding implements HttpClientOperations<RestTemplate>, InitializingBean {

	private final RestTemplate restTemplate;

	protected AbstractRestTemplateApiBinding(RestTemplate client) {
		this.restTemplate = configureRestTemplate(client);
	}

	protected RestTemplate configureRestTemplate(RestTemplate restTemplate) {
		return restTemplate;
	}

	@Override
	public RestTemplate getClient() {
		return this.restTemplate;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(this.restTemplate, "restTemplate is mandatory.");
	}

}