package com.sample.book.search.domain;

import java.util.List;

public class BookData {
	private List<Book> books;
	private int page;
	private int size;
	
	public List<Book> getBooks() {
		return books;
	}
	public int getPage() {
		return page;
	}
	public int getSize() {
		return size;
	}
	
	public BookData(List<Book> books, int page, int size) {
		super();
		this.books = books;
		this.page = page;
		this.size = size;
	}
}
