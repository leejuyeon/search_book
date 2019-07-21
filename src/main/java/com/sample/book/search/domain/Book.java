package com.sample.book.search.domain;

import java.util.Arrays;
import java.util.List;

import com.sample.book.component.api.kakao.domain.KaKaoSearchBook;
import com.sample.book.component.api.naver.domain.NaverSearchBook;

public class Book {
	private String title;
	private String contents;
	private String thumbnail;
	private String isbn;
	private List<String> authors;
	private String datetime;
	private String price;
	private String salePrice;
	private String publisher;
	
	public Book(KaKaoSearchBook result) {
		super();
		this.title = result.getTitle();
		this.contents = result.getContents();
		this.thumbnail = result.getThumbnail();
		this.isbn = result.getIsbn();
		this.authors = result.getAuthors();
		this.datetime = result.getDatetime();
		this.price = result.getPrice();
		this.salePrice = result.getSalePrice();
		this.publisher = result.getPublisher();
	}
	
	public Book(NaverSearchBook result) {
		super();
		this.title = result.getTitle();
		this.contents = result.getDescription();
		this.thumbnail = result.getImage();
		this.isbn = result.getIsbn();
		this.authors = Arrays.asList(result.getAuthor());
		this.datetime = result.getPubdate().toString();
		this.price = String.valueOf(result.getPrice());
		this.salePrice = String.valueOf(result.getDiscount());
		this.publisher = result.getPublisher();
	}
	
	

	public String getTitle() {
		return title;
	}

	public String getContents() {
		return contents;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public String getIsbn() {
		return isbn;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public String getDatetime() {
		return datetime;
	}

	public String getPrice() {
		return price;
	}

	public String getSalePrice() {
		return salePrice;
	}

	public String getPublisher() {
		return publisher;
	}

}
