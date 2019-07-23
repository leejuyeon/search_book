package com.sample.book.search;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sample.book.AbstractBookSearchApplicationTests;
import com.sample.book.join.domain.Member;
import com.sample.book.join.domain.MemberRole;
import com.sample.book.join.repository.MemberRepository;
import com.sample.book.search.domain.BookData;
import com.sample.book.search.service.SearchBookService;

public class SearchBookTest extends AbstractBookSearchApplicationTests{
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private SearchBookService searchBookService;
	
	@Before
	public void insertMembers() {
		Member member = new Member();
		member.setUid("juyeon");
		member.setUpw("pwd");
		member.setUemail("jylee@a.com");
		member.setRole(new MemberRole("USER"));

		memberRepository.save(member);
	}
	
	@Test
	public void searchBook() {
		String userId = "jylee@a.com";
		BookData bookData = searchBookService.searchBook(userId, "강철", 1, 10);

		System.out.println(bookData.toString());

		assertThat(bookData).isNotNull();
		assertThat(bookData.getBooks()).isNotNull();
	}
}
