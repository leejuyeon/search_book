package com.sample.book.component.api.kakao.client;

import com.sample.book.component.api.kakao.domain.KaKaoSearchBookData;

public interface KaKaoSearchOpertaions {
	KaKaoSearchBookData searchBooks(String query, int page, int size);
}
