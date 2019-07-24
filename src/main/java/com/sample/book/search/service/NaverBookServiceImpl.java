package com.sample.book.search.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

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
		
		if(ObjectUtils.isEmpty(booklist) == false && CollectionUtils.isEmpty(booklist.getBooks()) == false) {
			books.addAll(
					booklist.getBooks()
					.stream()
					.map(book -> new Book(book))
					.collect(Collectors.toList())
			);
			
			return new BookData(books, booklist.getStart(), booklist.getTotal(), page);
		}else {
			return new BookData(Collections.emptyList());
		}
	}

	@Override
	public NaverSearchBookData searchBook(String keyword, int page, int size) {
		return naverSearchConnectionFactory.getApi().naverSearchOpertaions()
				.searchBooks(keyword, page, size);
	}
}
