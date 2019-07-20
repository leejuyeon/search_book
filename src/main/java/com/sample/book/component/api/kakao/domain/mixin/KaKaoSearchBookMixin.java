package com.sample.book.component.api.kakao.domain.mixin;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KaKaoSearchBookMixin {
	@JsonProperty("title")
	private String title;
	@JsonProperty("contents")
	private String contents;
	@JsonProperty("url")
	private String url;
	@JsonProperty("isbn")
	private String isbn;
	@JsonProperty("datetime")
	private String datetime;
	@JsonProperty("authors")
	private List<String> authors;
	@JsonProperty("publisher")
	private String publisher;
	@JsonProperty("translators")
	private List<String> translators;
	@JsonProperty("price")
	private String price;
	@JsonProperty("sale_price")
	private String salePrice;
	@JsonProperty("thumbnail")
	private String thumbnail;
	@JsonProperty("status")
	private String status;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public List<String> getTranslators() {
		return translators;
	}
	public void setTranslators(List<String> translators) {
		this.translators = translators;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
