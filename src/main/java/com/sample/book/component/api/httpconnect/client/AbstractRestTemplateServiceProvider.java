package com.sample.book.component.api.httpconnect.client;

import org.springframework.web.client.RestTemplate;

import com.sample.book.component.api.httpconnect.HttpClientServiceProvider;

public abstract class AbstractRestTemplateServiceProvider<A> extends HttpClientServiceProvider<RestTemplate, RestTemplateOperations, A> {

	public AbstractRestTemplateServiceProvider(RestTemplateOperations operations) {
		super(operations);
	}

}