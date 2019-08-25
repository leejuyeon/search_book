package com.sample.book.component.api.naver.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.sample.book.component.api.naver.domain.NaverSearchBookData;
import com.sample.book.exception.NaverApiException;

public class NaverSearchOpertaionsTemplate implements NaverSearchOpertaions {
	private final RestTemplate client;

	public NaverSearchOpertaionsTemplate(RestTemplate client, String auth, String secret) {
		this.client = client;

		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
		interceptors.add(new NaverSearchConnectInterceptor(auth, secret));

		this.client.setInterceptors(interceptors);
	}

	@Override
	public NaverSearchBookData searchBooks(String query, int page, int size) {
		try {
			NaverSearchBookData resonse = client.exchange(
					UriComponentsBuilder.fromUriString("/book.json").query("query={query}").queryParam("sort", "sim")
							.queryParam("start", page).queryParam("display", size).buildAndExpand(query).toUriString(),
					HttpMethod.GET, null, NaverSearchBookData.class).getBody();

			return Optional.ofNullable(resonse).orElse(new NaverSearchBookData());
		} catch (Exception e) {
			e.printStackTrace();
			throw new NaverApiException();
		}
	}
}