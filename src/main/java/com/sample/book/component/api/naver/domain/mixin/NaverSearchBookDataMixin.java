package com.sample.book.component.api.naver.domain.mixin;

import java.util.List;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sample.book.component.api.naver.domain.NaverSearchBook;

public class NaverSearchBookDataMixin {
	@JsonProperty("lastBuildDate")
	private DateTime lastBuildDate;
	@JsonProperty("total")
	private int total;
	@JsonProperty("start")
	private int start;
	@JsonProperty("display")
	private int display;
	@JsonProperty("items")
	private List<NaverSearchBook> books;

	public DateTime getLastBuildDate() {
		return lastBuildDate;
	}

	public void setLastBuildDate(DateTime lastBuildDate) {
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
}
