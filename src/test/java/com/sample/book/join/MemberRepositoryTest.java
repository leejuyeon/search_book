package com.sample.book.join;

import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sample.book.AbstractBookSearchApplicationTests;
import com.sample.book.join.domain.Member;
import com.sample.book.join.domain.MemberRole;
import com.sample.book.join.repository.MemberRepository;

public class MemberRepositoryTest extends AbstractBookSearchApplicationTests {
	@Autowired
	private MemberRepository memberRepository;

	@Test
	public void insertMembers() {
		Member member = new Member();
		member.setUid("jylee");
		member.setUpw("aaaa1111");
		member.setUemail("jylee@a.com");
		member.setRole(new MemberRole("ROLE_USER"));

		memberRepository.save(member);
	}

	@Test
	public void getMember() {
		Optional<Member> result = memberRepository.findByUemail("jylee@a.com");
		assertNotNull(result.get());
	}
}