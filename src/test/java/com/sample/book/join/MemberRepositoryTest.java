package com.sample.book.join;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sample.book.join.domain.Member;
import com.sample.book.join.domain.MemberRole;
import com.sample.book.join.repository.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {
	@Autowired
	MemberRepository memberRepository;

	@Test
	public void insertTest() {
		for (int i = 0; i < 100; i++) {
			Member member = new Member();
			member.setUid("user" + i);
			member.setUpw("pw" + i);
			member.setUemail("hihi@" + i);
			MemberRole role = new MemberRole();
			if (i <= 80) {
				role.setRoleName("BASIC");
			} else if (i <= 90) {
				role.setRoleName("MANAGER");
			} else {
				role.setRoleName("ADMIN");
			}
			member.setRoles(Arrays.asList(role));
			memberRepository.save(member);
		}
	}

	@Test
	public void testMember() {
		Optional<Member> result = memberRepository.findById(85L);
		result.ifPresent(member -> System.out.println("member " + member.toString()));
	}
	
	@Test
	public void testMembers() {
		Optional<List<Member>> result = Optional.ofNullable(memberRepository.findAll());
		result.ifPresent(members -> {
			members.stream().forEach(member -> System.out.println("member " + member.toString()));
		});
	}
}