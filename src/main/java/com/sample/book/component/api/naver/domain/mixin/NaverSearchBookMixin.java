package com.sample.book.component.api.naver.domain.mixin;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NaverSearchBookMixin {
	@JsonProperty("title")
	private String title;
	@JsonProperty("image")
	private String image;
	@JsonProperty("description")
	private String description;
	@JsonProperty("isbn")
	private String isbn;
	@JsonProperty("author")
	private String author;
	@JsonProperty("publisher")
	private String publisher;
	@JsonProperty("pubdate")
	private String pubdate;
	@JsonProperty("price")
	private int price;
	@JsonProperty("discount")
	private int discount;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPubdate() {
		return pubdate;
	}

	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

}
