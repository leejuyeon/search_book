package com.sample.book.search;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sample.book.AbstractBookSearchApplicationTests;
import com.sample.book.join.domain.Member;
import com.sample.book.join.domain.MemberRole;
import com.sample.book.search.domain.BookData;
import com.sample.book.search.service.KeywordService;
import com.sample.book.search.service.SearchBookService;

public class SearchBookTest extends AbstractBookSearchApplicationTests{
	@Autowired
	private SearchBookService searchBookService;

	@Autowired
	private KeywordService keywordService;
	
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
	public void searchBook() {
		BookData bookData = searchBookService.searchBook(member.getUemail(), "강철", 1, 10);

		assertThat(bookData).isNotNull();
		assertThat(bookData.getBooks()).isNotNull();
	}
	
	@Test
	public void saveKeyword() {
		boolean result = keywordService.saveKeyword("강철");

		assertTrue(result);
	}
}
