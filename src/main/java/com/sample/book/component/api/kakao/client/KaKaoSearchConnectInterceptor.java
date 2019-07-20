package com.sample.book.component.api.kakao.client;

import java.io.IOException;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

public class KaKaoSearchConnectInterceptor implements ClientHttpRequestInterceptor {
	private String authKey;

	public KaKaoSearchConnectInterceptor(String authKey) {
		super();
		this.authKey = authKey;
	}

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		request.getHeaders().add("Authorization", String.format("KakaoAK %s", authKey));
		request.getHeaders().add("Content-Type", "application/json");
		
		return execution.execute(request, body);
	}
}
