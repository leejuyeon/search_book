package com.sample.book.component.api.kakao.client;

import org.springframework.web.client.RestTemplate;

import com.sample.book.component.api.httpconnect.client.AbstractRestTemplateApiBinding;

public class KaKaoSearchApiTemplate extends AbstractRestTemplateApiBinding implements KaKaoSearchApi  {
	private String authKey;
	
	public KaKaoSearchApiTemplate(RestTemplate client, String auth) {
		super(client);
		this.authKey = auth;
	}

	private KaKaoSearchOpertaions kaKaoSearchOpertaions;
	
	@Override
	public KaKaoSearchOpertaions kaKaoSearchOpertaions() {
		if (kaKaoSearchOpertaions == null) {
			kaKaoSearchOpertaions = new KaKaoSearchOpertaionsTemplate(getClient(), this.authKey);
		}
		
		return kaKaoSearchOpertaions;
	}
}
