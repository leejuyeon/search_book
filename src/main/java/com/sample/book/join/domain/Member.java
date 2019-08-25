package com.sample.book.join.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Member {
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false, unique = true, length = 50)
	private String uid;

	@Column(nullable = false, length = 200)
	private String upw;

	@Column(nullable = false, unique = true, length = 50)
	private String uemail;

	@CreationTimestamp
	private Date regdate;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id")
	private MemberRole role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUpw() {
		return upw;
	}

	public void setUpw(String upw) {
		this.upw = upw;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public MemberRole getRole() {
		return role;
	}

	public void setRole(MemberRole role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", uid=" + uid + ", upw=" + upw + ", uemail=" + uemail + ", regdate=" + regdate
				+ ", role=" + role + "]";
	}
}
