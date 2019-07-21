package com.sample.book.search.domain;

import java.util.List;

public class BookData {
	private List<Book> books;
	private int page;
	private int total;
	
	public List<Book> getBooks() {
		return books;
	}
	public int getPage() {
		return page;
	}
	
	public BookData(List<Book> books, int page, int total) {
		super();
		this.books = books;
		this.page = page;
		this.total = total;
	}
	public int getTotal() {
		return total;
	}
}
