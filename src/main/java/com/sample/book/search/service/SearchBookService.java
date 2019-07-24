package com.sample.book.search.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.book.exception.KakaoApiException;
import com.sample.book.exception.NaverApiException;
import com.sample.book.search.domain.BookData;

@Service
public class SearchBookService{
	@Autowired
	private KeywordService keywordService;
	@Autowired
	private KakaoBookServiceImpl kakaoBookService;
	@Autowired
	private NaverBookServiceImpl naverBookService;
	
	public BookData searchBook(String userId, String keyword, int page, int size) {
		try {
			return kakaoBookService.convertBookData(kakaoBookService.searchBook(keyword, page, size), page);
		} catch (KakaoApiException e) {
			return naverBookService.convertBookData(naverBookService.searchBook(keyword, page, size), page);
		} catch (NaverApiException e) {
			return new BookData();
		} finally {
			if(page == 1) {
				// 키워드 저장
				keywordService.saveKeyword(keyword);

				// 내 키워드 저장
				keywordService.saveMyKeyword(userId, keyword);
			}
		}
	}
}
