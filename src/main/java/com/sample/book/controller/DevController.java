package com.sample.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.book.component.api.kakao.connect.KaKaoSearchConnectionFactory;
import com.sample.book.component.api.kakao.domain.KaKaoSearchBookData;
import com.sample.book.component.api.naver.connect.NaverSearchConnectionFactory;
import com.sample.book.component.api.naver.domain.NaverSearchBookData;
import com.sample.book.search.domain.MySeletiveKeyword;
import com.sample.book.search.domain.SeletiveKeyword;
import com.sample.book.search.service.KeywordService;

@RestController
@RequestMapping(value = "/dev")
public class DevController {
	@Autowired
	private KaKaoSearchConnectionFactory kaKaoSearchConnectionFactory;
	@Autowired
	private NaverSearchConnectionFactory naverSearchConnectionFactory;
	
	@Autowired
	private KeywordService keywordService;

	@RequestMapping(value = "/kakao", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public KaKaoSearchBookData searchBook(@RequestParam(required = true) String query){
		KaKaoSearchBookData kakaoSearchBookData = kaKaoSearchConnectionFactory.getApi().kaKaoSearchOpertaions()
				.searchBooks("미움받을 용기", 1, 10);
		return kakaoSearchBookData;
	}


	@RequestMapping(value = "/naver", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public NaverSearchBookData searchBookByNaver(@RequestParam(required = false, defaultValue="abc")  String query){
		NaverSearchBookData kakaoSearchBookData = naverSearchConnectionFactory.getApi().naverSearchOpertaions()
				.searchBooks(query, 1, 10);
		return kakaoSearchBookData;
	}
	

	@RequestMapping(value = "/pop", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SeletiveKeyword> popKey(){
		return keywordService.getPopluarayKeyword();
	}

	@RequestMapping(value = "/keyword", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public SeletiveKeyword kjey(@RequestParam(required = true) String keyword){
		
		if(keywordService.isExistsByKeyword(keyword)) {
			SeletiveKeyword seletive = keywordService.getKeyword(keyword);
			System.out.println(seletive.getCount());
			keywordService.saveSearchKeyword(keyword, seletive.getCount() + 1);
		}else {
			keywordService.saveSearchKeyword(keyword, 1);
		}
		
		return keywordService.getKeyword(keyword);
	}
	
	@RequestMapping(value = "/my", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MySeletiveKeyword> mykey(@RequestParam(required = false, defaultValue="aaa") String userId){
		return keywordService.getMySeletiveKeyword(userId, 10);
	}
	
	@RequestMapping(value = "/my/keyword", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public MySeletiveKeyword mykey1(@RequestParam(required = false, defaultValue="aaa") String userId
			, @RequestParam(required = false, defaultValue="abc") String keyword){
		return keywordService.saveMyKeyword(userId, keyword);
	}
	
}
