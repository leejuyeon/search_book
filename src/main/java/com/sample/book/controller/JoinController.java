package com.sample.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sample.book.join.domain.Member;
import com.sample.book.join.domain.MemberRole;
import com.sample.book.join.repository.MemberRepository;

@Controller
@RequestMapping("/join")
public class JoinController {
	@Autowired
	private MemberRepository memberRepository;

	@RequestMapping(value = "/member", method = RequestMethod.POST)
	public String create(Member member) {

		member.setRole(new MemberRole("ROLE_USER"));
		member.setUpw(new BCryptPasswordEncoder().encode(member.getUpw()));

		memberRepository.save(member);

		return "redirect:/login";
	}
}
