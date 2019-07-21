package com.sample.book.search.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.book.component.api.kakao.connect.KaKaoSearchConnectionFactory;
import com.sample.book.component.api.kakao.domain.KaKaoSearchBookData;
import com.sample.book.search.domain.Book;
import com.sample.book.search.domain.BookData;

@Service
public class KakaoBookServiceImpl implements SearchApiService <KaKaoSearchBookData, KaKaoSearchBookData>{
	@Autowired
	private KaKaoSearchConnectionFactory kaKaoSearchConnectionFactory;
	
	@Override
	public BookData convertBookData(KaKaoSearchBookData booklist) {
		List<Book> books = new ArrayList<Book>();
		
		booklist.getBooks().forEach(data -> { books.add(new Book(data)); });
		
		return new BookData(books, booklist.getMeta().getPageableCount(), booklist.getMeta().getTotalCount());
	}

	@Override
	public KaKaoSearchBookData searchBook(String keyword, String sort, int page, int size) {
		return kaKaoSearchConnectionFactory.getApi().kaKaoSearchOpertaions()
				.searchBooks(keyword, sort, page, size);
	}
}
