package com.sample.book.search.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import com.sample.book.component.api.kakao.connect.KaKaoSearchConnectionFactory;
import com.sample.book.component.api.kakao.domain.KaKaoSearchBookData;
import com.sample.book.component.api.kakao.domain.KaKaoSearchMeta;
import com.sample.book.search.domain.Book;
import com.sample.book.search.domain.BookData;

@Service
public class KakaoBookServiceImpl implements SearchApiService<KaKaoSearchBookData, KaKaoSearchBookData> {
	@Autowired
	private KaKaoSearchConnectionFactory kaKaoSearchConnectionFactory;

	@Override
	public BookData convertBookData(KaKaoSearchBookData booklist, int page) {
		List<Book> books = new ArrayList<Book>();

		if (ObjectUtils.isEmpty(booklist) == false && CollectionUtils.isEmpty(booklist.getBooks()) == false) {
			books.addAll(booklist.getBooks().stream().map(book -> new Book(book)).collect(Collectors.toList()));

			KaKaoSearchMeta meta = booklist.getMeta();
			if (ObjectUtils.isEmpty(meta))
				meta = new KaKaoSearchMeta();

			return new BookData(books, meta.getPageableCount(), meta.getPageableCount(), page);
		} else {
			return new BookData(Collections.emptyList());
		}
	}

	@Override
	public KaKaoSearchBookData searchBook(String keyword, int page, int size) {
		KaKaoSearchBookData book = kaKaoSearchConnectionFactory.getApi().kaKaoSearchOpertaions().searchBooks(keyword,
				page, size);
		return book;
	}
}
