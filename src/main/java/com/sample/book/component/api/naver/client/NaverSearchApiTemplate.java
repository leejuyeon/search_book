package com.sample.book.component.api.naver.client;

import org.springframework.web.client.RestTemplate;

import com.sample.book.component.api.httpconnect.client.AbstractRestTemplateApiBinding;

public class NaverSearchApiTemplate extends AbstractRestTemplateApiBinding implements NaverSearchApi  {
	private String authKey;
	private String secret;
	
	public NaverSearchApiTemplate(RestTemplate client, String auth, String secret) {
		super(client);
		this.authKey = auth;
		this.secret = secret;
	}

	private NaverSearchOpertaions naverSearchOpertaions;
	
	@Override
	public NaverSearchOpertaions naverSearchOpertaions() {
		if (naverSearchOpertaions == null) {
			naverSearchOpertaions = new NaverSearchOpertaionsTemplate(getClient(), this.authKey, this.secret);
		}
		
		return naverSearchOpertaions;
	}
}
