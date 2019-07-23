package com.sample.book.component.api.naver.client;

import com.sample.book.component.api.naver.domain.NaverSearchBookData;

public interface NaverSearchOpertaions {
	NaverSearchBookData searchBooks(String query, int page, int size);
}
