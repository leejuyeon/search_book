package com.sample.book.component.api.kakao.connect;

import org.springframework.lang.Nullable;

import com.sample.book.component.api.httpconnect.ConnectionData;
import com.sample.book.component.api.httpconnect.client.AbstractRestTemplateServiceProvider;
import com.sample.book.component.api.httpconnect.client.RestTemplateOperations;
import com.sample.book.component.api.kakao.client.KaKaoSearchApi;
import com.sample.book.component.api.kakao.client.KaKaoSearchApiTemplate;

public class KaKaoSearchServiceProvider extends AbstractRestTemplateServiceProvider<KaKaoSearchApi> {
	private String auth;
	
	public KaKaoSearchServiceProvider(RestTemplateOperations restTemplateOperations, String auth) {
		super(restTemplateOperations);
		this.auth = auth;
	}

	@Override
	public KaKaoSearchApi getApi(@Nullable ConnectionData connection) {
		return new KaKaoSearchApiTemplate(getClient(), auth);
	}

}