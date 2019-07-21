package com.sample.book.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Authentication authentication) {
		return "index";
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String joinForm(HttpServletRequest req) {
		return "join";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm(HttpServletRequest req) {
		String referer = req.getHeader("Referer");
		req.getSession().setAttribute("prevPage", referer);
		
		return "login";
	}
}
