package com.sample.book.join;

import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sample.book.AbstractBookSearchApplicationTests;
import com.sample.book.join.domain.Member;
import com.sample.book.join.domain.MemberRole;
import com.sample.book.join.repository.MemberRepository;

public class MemberRepositoryTest extends AbstractBookSearchApplicationTests{
	@Autowired
	private MemberRepository memberRepository;

	@Test
	public void insertMembers() {
			Member member = new Member();
			member.setUid("user");
			member.setUpw("pw");
			member.setUemail("hihi@");
			member.setRole(new MemberRole("USER"));

			memberRepository.save(member);	
	}

	@Test
	public void getMember() {
		Optional<Member> result = memberRepository.findById(20L);
		result.ifPresent(member -> System.out.println("member : " + member.toString()));

		assertNotNull(result.get());
	}
}