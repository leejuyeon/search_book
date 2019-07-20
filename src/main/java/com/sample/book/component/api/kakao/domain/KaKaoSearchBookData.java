package com.sample.book.component.api.kakao.domain;

import java.util.List;

public class KaKaoSearchBookData {
	private KaKaoSearchMeta meta;
	private List<KaKaoSearchBook> books;
	
	public KaKaoSearchMeta getMeta() {
		return meta;
	}
	public void setMeta(KaKaoSearchMeta meta) {
		this.meta = meta;
	}
	public List<KaKaoSearchBook> getBooks() {
		return books;
	}
	public void setBooks(List<KaKaoSearchBook> books) {
		this.books = books;
	}
	
	@Override
	public String toString() {
		return "KaKaoSearchBookData [meta=" + meta + ", books=" + books + "]";
	}
	
}
