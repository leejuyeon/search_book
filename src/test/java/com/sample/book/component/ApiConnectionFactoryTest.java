package com.sample.book.component;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sample.book.AbstractBookSearchApplicationTests;
import com.sample.book.component.api.kakao.client.KaKaoSearchApi;
import com.sample.book.component.api.kakao.connect.KaKaoSearchConnectionFactory;
import com.sample.book.component.api.kakao.domain.KaKaoSearchBookData;
import com.sample.book.component.api.naver.client.NaverSearchApi;
import com.sample.book.component.api.naver.connect.NaverSearchConnectionFactory;
import com.sample.book.component.api.naver.domain.NaverSearchBookData;

public class ApiConnectionFactoryTest extends AbstractBookSearchApplicationTests{
	@Autowired
	private NaverSearchConnectionFactory naverSearchConnectionFactory;
	@Autowired
	private KaKaoSearchConnectionFactory kaKaoSearchConnectionFactory;

	@Test
	public void searchBookFromKakao() {
		KaKaoSearchApi kakaoApi = kaKaoSearchConnectionFactory.getApi();
		KaKaoSearchBookData result = kakaoApi.kaKaoSearchOpertaions().searchBooks("abc", 1, 3);

		System.out.println(result.toString());
		assertNotNull(result);
	}
	@Test
	public void searchBookFromNaver() {
		NaverSearchApi naverApi = naverSearchConnectionFactory.getApi();
		NaverSearchBookData result = naverApi.naverSearchOpertaions().searchBooks("abc", 1, 3);

		System.out.println(result.toString());
		assertNotNull(result);
	}
}
