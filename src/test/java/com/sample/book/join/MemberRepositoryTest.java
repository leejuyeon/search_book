package com.sample.book.join;

import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sample.book.AbstractBookSearchApplicationTests;
import com.sample.book.join.domain.Member;
import com.sample.book.join.domain.MemberRole;
import com.sample.book.join.repository.MemberRepository;

public class MemberRepositoryTest extends AbstractBookSearchApplicationTests{
	@Autowired
	private MemberRepository memberRepository;

	@Before
	public void insertMembers() {
		for (int i = 0; i < 30; i++) {
			Member member = new Member();
			member.setUid("user" + i);
			member.setUpw("pw" + i);
			member.setUemail("hihi@" + i);

			if (i <= 26)
				member.setRole(new MemberRole("USER"));
			else
				member.setRole(new MemberRole("ADMIN"));

			memberRepository.save(member);
		}
	}

	@Test
	public void getMember() {
		Optional<Member> result = memberRepository.findById(20L);
		result.ifPresent(member -> System.out.println("member : " + member.toString()));

		assertNotNull(result.get());
	}
}