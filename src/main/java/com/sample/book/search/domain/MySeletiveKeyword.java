package com.sample.book.search.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table
public class MySeletiveKeyword implements Serializable {
	private static final long serialVersionUID = 1001635344797960925L;

	@EmbeddedId
	private MyKeywordId myKeywordId;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date searchTime;

	public Date getSearchTime() {
		return searchTime;
	}

	public MyKeywordId getMyKeywordId() {
		return myKeywordId;
	}

	public MySeletiveKeyword(MyKeywordId myKeywordId) {
		super();
		this.myKeywordId = myKeywordId;
	}
}
