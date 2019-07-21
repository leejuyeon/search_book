package com.sample.book.search.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class SeletiveKeyword {
	@Id
	private String keyword;
	
	private int count;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastSearchTime = new Date();
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	public Date getLastSearchTime() {
		return lastSearchTime;
	}
}
