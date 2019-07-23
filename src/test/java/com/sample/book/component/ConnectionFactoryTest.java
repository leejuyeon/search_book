package com.sample.book.component;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sample.book.component.api.httpconnect.config.HttpConnectBuilder;
import com.sample.book.component.api.kakao.client.KaKaoSearchApi;
import com.sample.book.component.api.kakao.connect.KaKaoSearchConnectionFactory;
import com.sample.book.component.api.naver.client.NaverSearchApi;
import com.sample.book.component.api.naver.connect.NaverSearchConnectionFactory;

public class ConnectionFactoryTest{
	@Test
	public void getProviderId() {
		KaKaoSearchConnectionFactory kakaoConnectionFactory = new KaKaoSearchConnectionFactory("search_kakao", HttpConnectBuilder.client().build(), "auth");
		assertEquals("search_kakao", kakaoConnectionFactory.getProviderId());
		
		NaverSearchConnectionFactory naverConnectionFactory = new NaverSearchConnectionFactory("search_naver", HttpConnectBuilder.client().build(), "auth", "secret");
		assertEquals("search_naver", naverConnectionFactory.getProviderId());
	}

	@Test
	public void getApi() {
		KaKaoSearchConnectionFactory kakaoConnectionFactory = new KaKaoSearchConnectionFactory("search_kakao", HttpConnectBuilder.client().build(), "auth");
		assertTrue(kakaoConnectionFactory.getApi() instanceof KaKaoSearchApi);
		
		NaverSearchConnectionFactory naverConnectionFactory = new NaverSearchConnectionFactory("search_naver", HttpConnectBuilder.client().build(), "auth", "secret");
		assertTrue(naverConnectionFactory.getApi() instanceof NaverSearchApi);
	}
}
