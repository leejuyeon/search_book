package com.sample.book.search.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class SeletiveKeyword {
	@Id
	private String keyword;

	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public SeletiveKeyword(String keyword, int count) {
		super();
		this.keyword = keyword;
		this.count = count;
	}

	public SeletiveKeyword() {
	}
}
