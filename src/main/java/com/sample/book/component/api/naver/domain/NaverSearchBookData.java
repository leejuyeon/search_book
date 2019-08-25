package com.sample.book.component.api.naver.domain;

import java.util.Date;
import java.util.List;

public class NaverSearchBookData {
	private Date lastBuildDate;
	private int total;
	private int start;
	private int display;
	private List<NaverSearchBook> books;

	public Date getLastBuildDate() {
		return lastBuildDate;
	}

	public void setLastBuildDate(Date lastBuildDate) {
		this.lastBuildDate = lastBuildDate;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getDisplay() {
		return display;
	}

	public void setDisplay(int display) {
		this.display = display;
	}

	public List<NaverSearchBook> getBooks() {
		return books;
	}

	public void setBooks(List<NaverSearchBook> books) {
		this.books = books;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	@Override
	public String toString() {
		return "NaverSearchBookData [lastBuildDate=" + lastBuildDate + ", total=" + total + ", start=" + start
				+ ", display=" + display + ", books=" + books + "]";
	}
}
