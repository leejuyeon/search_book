package com.sample.book.search.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class MySeletiveKeyword implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * @Id
	 * 
	 * @Column(length = 8) private String userId; private String keyword;
	 */
	@EmbeddedId
	private MyKeywordId myKeywordId;

	@Column(columnDefinition = "datetime default sysdate()")
	@Temporal(TemporalType.TIMESTAMP)
	private Date searchTime;

	public Date getSearchTime() {
		return searchTime;
	}
	public void setSearchTime(Date searchTime) {
		this.searchTime = searchTime;
	}
	public MyKeywordId getMyKeywordId() {
		return myKeywordId;
	}
	public void setMyKeywordId(MyKeywordId myKeywordId) {
		this.myKeywordId = myKeywordId;
	}
}
