package com.sample.book.component.api.kakao.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.sample.book.component.api.kakao.domain.KaKaoSearchBookData;
import com.sample.book.exception.KakaoApiException;

public class KaKaoSearchOpertaionsTemplate implements KaKaoSearchOpertaions {
	private final RestTemplate client;

	public KaKaoSearchOpertaionsTemplate(RestTemplate client, String auth) {
		this.client = client;

		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
		interceptors.add(new KaKaoSearchConnectInterceptor(auth));

		this.client.setInterceptors(interceptors);
	}

	@Override
	public KaKaoSearchBookData searchBooks(String query, int page, int size) {
		try {
			KaKaoSearchBookData response = client.exchange(
					UriComponentsBuilder.fromUriString("/book").query("query={query}").queryParam("sort", "accuracy")
							.queryParam("page", page).queryParam("size", size).buildAndExpand(query).toUriString(),
					HttpMethod.GET, null, KaKaoSearchBookData.class).getBody();

			return Optional.ofNullable(response).orElse(new KaKaoSearchBookData());
		} catch (Exception e) {
			e.printStackTrace();
			throw new KakaoApiException();
		}
	}
}
