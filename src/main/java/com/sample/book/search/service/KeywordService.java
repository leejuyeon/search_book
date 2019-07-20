package com.sample.book.search.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sample.book.search.domain.MyKeywordId;
import com.sample.book.search.domain.MySeletiveKeyword;
import com.sample.book.search.domain.SeletiveKeyword;
import com.sample.book.search.repository.MySeletiveRepository;
import com.sample.book.search.repository.SeletiveRepository;

@Service
public class KeywordService {
	@Autowired
	private MySeletiveRepository mySeletiveRepository;
	@Autowired
	private SeletiveRepository seletiveRepository;
	
	public List<MySeletiveKeyword> getMySeletiveKeyword(String userId){
		return mySeletiveRepository.findByMyKeywordIdUserId(userId, PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "searchTime"))).getContent();
	}
	public MySeletiveKeyword saveMyKeyword(String userId, String keyword) {
		MyKeywordId myId = new MyKeywordId();
		myId.setKeyword(keyword);
		myId.setUserId(userId);		
		
		MySeletiveKeyword my = new MySeletiveKeyword();
		my.setMyKeywordId(myId);
		my.setSearchTime(new Date());
		
		return mySeletiveRepository.save(my);
	}

	public List<SeletiveKeyword> getPopluarayKeyword(){
		return seletiveRepository.findAll(PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "count"))).getContent();
	};

	public SeletiveKeyword getKeyword(String keyword){
		return seletiveRepository.findByKeyword(keyword);
	};
	
	public boolean isExistsByKeyword(String keyword) {
		return seletiveRepository.existsByKeyword(keyword);
	}
	
	public SeletiveKeyword saveSearchKeyword(String keyword, int count) {
		SeletiveKeyword seletive = new SeletiveKeyword();
		seletive.setKeyword(keyword);
		seletive.setCount(count);
		
		return seletiveRepository.save(seletive);
	}
}
