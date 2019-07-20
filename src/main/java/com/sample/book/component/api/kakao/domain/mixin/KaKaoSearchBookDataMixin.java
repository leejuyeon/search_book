package com.sample.book.component.api.kakao.domain.mixin;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sample.book.component.api.kakao.domain.KaKaoSearchBook;
import com.sample.book.component.api.kakao.domain.KaKaoSearchMeta;

public class KaKaoSearchBookDataMixin {
	@JsonProperty("meta")
	private KaKaoSearchMeta meta;
	@JsonProperty("documents")
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
}
