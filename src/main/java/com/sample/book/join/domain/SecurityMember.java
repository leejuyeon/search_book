package com.sample.book.join.domain;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class SecurityMember extends User {
	private static final long serialVersionUID = 1L;
	private Member member;
	
	public Member getMember() {
		return member;
	}

	public SecurityMember(Member member) {
		super(member.getUemail(), member.getUpw(), makeGrantedAuthority(member.getRole()));
		this.member = member;
	}
	
	private static List<GrantedAuthority> makeGrantedAuthority(MemberRole role){
		return Arrays.asList(new SimpleGrantedAuthority(role.getRoleName()));
	}
}