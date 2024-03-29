package com.sample.book.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.sample.book.component.api.httpconnect.client.RestTemplateOperations;
import com.sample.book.component.api.httpconnect.config.HttpConnectBuilder;
import com.sample.book.component.api.kakao.connect.KaKaoSearchConnectionFactory;
import com.sample.book.component.api.kakao.domain.KakaoSearchModule;
import com.sample.book.component.api.naver.connect.NaverSearchConnectionFactory;
import com.sample.book.component.api.naver.domain.NaverSearchModule;

@Configuration
public class ApiConnectConfig {
	@Autowired
	private Environment env;

	@Bean
	public KaKaoSearchConnectionFactory kaKaoSearchConnectionFactory() {
		final String auth = env.getProperty("kakao.api.auth.key");
		final String domain = env.getProperty("kakao.api.domain");

		RestTemplateOperations operations = HttpConnectBuilder.client()
				.okHttpClient(options -> options.connectTimeout(3000).readTimeout(3000).connectionPool(5, 5).build())
				.uriBuilderFactory(domain)
				.messageConverter(options -> options
						.jackson(Jackson2ObjectMapperBuilder.json().modules(new KakaoSearchModule()).build()).build())
				.build();
		return new KaKaoSearchConnectionFactory("search_kakao", operations, auth);
	}

	@Bean
	public NaverSearchConnectionFactory naverSearchConnectionFactory() {
		final String auth = env.getProperty("naver.api.auth.key");
		final String secret = env.getProperty("naver.api.secret.key");
		final String domain = env.getProperty("naver.api.domain");

		RestTemplateOperations operations = HttpConnectBuilder.client()
				.okHttpClient(options -> options.connectTimeout(3000).readTimeout(3000).connectionPool(5, 5).build())
				.uriBuilderFactory(domain)
				.messageConverter(options -> options
						.jackson(Jackson2ObjectMapperBuilder.json().modules(new NaverSearchModule()).build()).build())
				.build();
		return new NaverSearchConnectionFactory("search_naver", operations, auth, secret);
	}

}
