package com.sample.book.search.service;

import com.sample.book.search.domain.BookData;

public interface SearchApiService<T1, T2> {
	BookData convertBookData(T1 t1, int page);

	T2 searchBook(String keyword, int page, int size);
}
