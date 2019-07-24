package com.sample.book.search;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sample.book.AbstractBookSearchApplicationTests;
import com.sample.book.join.domain.Member;
import com.sample.book.join.domain.MemberRole;
import com.sample.book.search.domain.MyKeywordId;
import com.sample.book.search.domain.MySeletiveKeyword;
import com.sample.book.search.repository.MySeletiveRepository;

public class MySeletiveRepositoryTest extends AbstractBookSearchApplicationTests {
	@Autowired
	private MySeletiveRepository mySeletiveRepository;

	private Member member;
	
	@Before
	public void initMember() {
		Member member = new Member();
		member.setUid("jylee");
		member.setUpw("aaaa1111");
		member.setUemail("jylee@a.com");
		member.setRole(new MemberRole("ROLE_USER"));
		
		this.member = member;
	}
	
	@Test
	public void saveKeyword() {
		MyKeywordId myId = new MyKeywordId();
		myId.setKeyword("강철");
		myId.setUserId(member.getUemail());		
		
		MySeletiveKeyword my = new MySeletiveKeyword();
		my.setMyKeywordId(myId);
		my.setSearchTime(new Date());
		
		MySeletiveKeyword result = mySeletiveRepository.save(my);
		
		assertNotNull(result);
	}
}