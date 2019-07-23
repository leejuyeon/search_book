package com.sample.book.search.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.book.component.api.naver.connect.NaverSearchConnectionFactory;
import com.sample.book.component.api.naver.domain.NaverSearchBookData;
import com.sample.book.search.domain.Book;
import com.sample.book.search.domain.BookData;

@Service
public class NaverBookServiceImpl implements SearchApiService<NaverSearchBookData, NaverSearchBookData>{
	@Autowired
	private NaverSearchConnectionFactory naverSearchConnectionFactory;

	
	@Override
	public BookData convertBookData(NaverSearchBookData booklist, int page) {
		List<Book> books = new ArrayList<Book>();
		
		booklist.getBooks().forEach(data -> { books.add(new Book(data)); });
		
		return new BookData(books, booklist.getStart(), booklist.getTotal(), page);
	}

	@Override
	public NaverSearchBookData searchBook(String keyword, int page, int size) {
		return naverSearchConnectionFactory.getApi().naverSearchOpertaions()
				.searchBooks(keyword, page, size);
	}
}
