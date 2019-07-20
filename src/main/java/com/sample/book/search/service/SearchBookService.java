package com.sample.book.search.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.book.component.api.kakao.connect.KaKaoSearchConnectionFactory;
import com.sample.book.component.api.kakao.domain.KaKaoSearchBookData;
import com.sample.book.search.domain.SeletiveKeyword;

@Service
public class SearchBookService {
	@Autowired
	private KaKaoSearchConnectionFactory kaKaoSearchConnectionFactory;
	
	@Autowired
	private KeywordService keywordService;


	/*
	public BookData searchBook(String keyword, String sort, int page, int size, String target) {
		List<Book> books = new ArrayList<Book>();
		KaKaoSearchBookData result = searchBookFromKakao(keyword, sort, page, size, target);
		
		result.getBooks().forEach(data -> {
			books.add(new Book(data));
		});
		
		return new BookData(books, page, size);
	}*/
	
	
	public KaKaoSearchBookData searchBook(String userId, String keyword, String sort, int page, int size, String target) {
		try {
			return searchBookFromKakao(keyword, sort, page, size, target);
		} finally {

			//키워드 저장
			if(keywordService.isExistsByKeyword(keyword)) {
				SeletiveKeyword seletive = keywordService.getKeyword(keyword);
				System.out.println(seletive.getCount());
				keywordService.saveSearchKeyword(keyword, seletive.getCount() + 1);
			}else {
				keywordService.saveSearchKeyword(keyword, 1);
			}
			
			//내 키워드 저장
			keywordService.saveMyKeyword(userId, keyword);
			
		}
	}

	public KaKaoSearchBookData searchBookFromKakao(String keyword, String sort, int page, int size, String target) {
		KaKaoSearchBookData kakaoSearchBookData = kaKaoSearchConnectionFactory.getApi().kaKaoSearchOpertaions().searchBooks(keyword, sort, page, size, target);
		return kakaoSearchBookData;
	}
}
