package com.sample.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.book.search.domain.BookData;
import com.sample.book.search.domain.MySeletiveKeyword;
import com.sample.book.search.domain.SeletiveKeyword;
import com.sample.book.search.service.KeywordService;
import com.sample.book.search.service.SearchBookService;

@RestController
@RequestMapping(value = "/search")
public class SearchController {
	@Autowired
	private SearchBookService searchBookService;
	@Autowired
	private KeywordService keywordService;

	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(value = "/book", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public BookData searchBook(Authentication authentication, @RequestParam(required = true) String keyword,
			@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "10") int size) {
		return searchBookService.searchBook(authentication.getName(), keyword, page, size);
	}

	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(value = "/my", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MySeletiveKeyword> getMyKeywordHistory(Authentication authentication,
			@RequestParam(required = false, defaultValue = "10") int size) {
		return keywordService.getMySeletiveKeyword(authentication.getName(), size);
	}

	@RequestMapping(value = "/topic", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SeletiveKeyword> getTopicKeyword() {
		return keywordService.getPopluarayKeyword();
	}
}
