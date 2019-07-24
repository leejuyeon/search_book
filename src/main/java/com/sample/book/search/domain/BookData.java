package com.sample.book.search.domain;

import java.util.List;

public class BookData {
	private List<Book> books;
	private int page;
	private int total;
	private boolean endpage;
	private int currentPage = 1;

	public List<Book> getBooks() {
		return books;
	}

	public int getPage() {
		return page;
	}

	public int getTotal() {
		return total;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public boolean isEndpage() {
		return endpage;
	}

	public BookData(List<Book> books, int page, int total, int currentPage) {
		super();
		this.books = books;
		this.page = page;
		this.total = total;
		this.currentPage = currentPage;
	}

	public BookData() {
	}

	public BookData(List<Book> books) {
		super();
		this.books = books;
	}

	@Override
	public String toString() {
		return "BookData [books=" + books + ", page=" + page + ", total=" + total + ", endpage=" + endpage
				+ ", currentPage=" + currentPage + "]";
	}
}
