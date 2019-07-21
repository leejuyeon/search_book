package com.sample.book.component.api.naver.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.sample.book.component.api.naver.domain.NaverSearchBookData;

public class NaverSearchOpertaionsTemplate implements NaverSearchOpertaions {
	private final RestTemplate client;

	public NaverSearchOpertaionsTemplate(RestTemplate client, String auth, String secret) {
		this.client = client;

		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
		interceptors.add(new NaverSearchConnectInterceptor(auth, secret));

		this.client.setInterceptors(interceptors);
	}

	@Override
	public NaverSearchBookData searchBooks(String query, String sort, int page, int size) {
		ResponseEntity<NaverSearchBookData> resonse = client.exchange(
				UriComponentsBuilder.fromUriString("/book").query("query={query}").queryParam("sort", sort)
						.queryParam("start", page).queryParam("display", size).buildAndExpand(query).toUriString(),
				HttpMethod.GET, null, NaverSearchBookData.class);

		System.out.println(resonse.getBody().toString());
		return Optional.ofNullable(resonse.getBody()).orElse(new NaverSearchBookData());
	}
}
	