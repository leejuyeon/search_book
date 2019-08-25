package com.sample.book.join.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sample.book.join.domain.Member;
import com.sample.book.join.domain.SecurityMember;
import com.sample.book.join.repository.MemberRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Member> member = memberRepository.findByUemail(email);

		if (member.isPresent()) {
			return new SecurityMember(member.get());
		}
		return null;
	}

}