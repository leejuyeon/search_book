package com.sample.book.component.api.naver.connect;

import org.springframework.lang.Nullable;

import com.sample.book.component.api.httpconnect.ConnectionData;
import com.sample.book.component.api.httpconnect.client.AbstractRestTemplateServiceProvider;
import com.sample.book.component.api.httpconnect.client.RestTemplateOperations;
import com.sample.book.component.api.naver.client.NaverSearchApi;
import com.sample.book.component.api.naver.client.NaverSearchApiTemplate;

public class NaverSearchServiceProvider extends AbstractRestTemplateServiceProvider<NaverSearchApi> {
	private String auth;
	private String secret;

	public NaverSearchServiceProvider(RestTemplateOperations restTemplateOperations, String auth, String secret) {
		super(restTemplateOperations);
		this.auth = auth;
		this.secret = secret;
	}

	@Override
	public NaverSearchApi getApi(@Nullable ConnectionData connection) {
		return new NaverSearchApiTemplate(getClient(), auth, secret);
	}

}