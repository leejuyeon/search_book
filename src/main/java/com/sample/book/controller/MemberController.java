package com.sample.book.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sample.book.join.domain.Member;
import com.sample.book.join.domain.MemberRole;
import com.sample.book.join.repository.MemberRepository;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	MemberRepository memberRepository;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String create(Member member) {
		MemberRole role = new MemberRole();
		role.setRoleName("BASIC");
		
		member.setRoles(Arrays.asList(role));
		member.setUpw(new BCryptPasswordEncoder().encode(member.getUpw()));
		
		memberRepository.save(member);
		
		return "redirect:/";
	}
}
