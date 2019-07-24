package com.sample.book.search.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class MyKeywordId implements Serializable{
	private static final long serialVersionUID = -6156174101762428411L;
	
	@Column(nullable = false, length=50)
	private String userId;
	@Column(nullable = false)
	private String keyword;

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}