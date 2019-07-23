package com.sample.book.component.api.naver.domain;

import java.util.Date;

public class NaverSearchBook {
	private String title;
	private String image;
	private String description;
	private String isbn;
	private String author;
	private String publisher;
	private Date pubdate;
	private int price;
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
	public Date getPubdate() {
		return pubdate;
	}
	public void setPubdate(Date pubdate) {
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
	@Override
	public String toString() {
		return "NaverSearchBook [title=" + title + ", image=" + image + ", description=" + description + ", isbn="
				+ isbn + ", author=" + author + ", publisher=" + publisher + ", pubdate=" + pubdate + ", price=" + price
				+ ", discount=" + discount + "]";
	}
	
	
}
