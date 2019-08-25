package com.sample.book.component.api.naver.client;

import java.io.IOException;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

public class NaverSearchConnectInterceptor implements ClientHttpRequestInterceptor {
	private String authKey;
	private String secret;

	public NaverSearchConnectInterceptor(String authKey, String secret) {
		super();
		this.authKey = authKey;
		this.secret = secret;
	}

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		request.getHeaders().add("X-Naver-Client-Id", authKey);
		request.getHeaders().add("X-Naver-Client-Secret", secret);
		request.getHeaders().add("Content-Type", "application/json");

		return execution.execute(request, body);
	}
}
